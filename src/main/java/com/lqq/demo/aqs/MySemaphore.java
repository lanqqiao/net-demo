package com.lqq.demo.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MySemaphore {
    private Sync sync;

    public MySemaphore(int permits) {
        this.sync = new Sync(permits);
    }

    //我觉得不应该响应中断，因为被中断的锁显然没有获取到锁，这时就会走 finally 中的 release() 方法来释放锁，这样就可能会抛 error 错误了
    public void acquire() {
        sync.acquireShared(1);
    }

    public void release() {
        sync.releaseShared(1);
    }

    public int availablePermits() {
        return sync.getPermits();
    }

    static class Sync extends AbstractQueuedSynchronizer {
        private int max;

        public Sync(int permits) {
            setState(permits);
            max = permits;
        }

        final int getPermits() {
            return getState();
        }

        @Override
        protected int tryAcquireShared(int arg) {
            int state;
            for (; ; ) {
                //当资源不够的时候就要阻塞当前线程了，否则一直循环CAS，直到成功为止，因为只要有资源就不应该被阻塞
                if ((state = getState()) - arg < 0)
                    return -1;
                if (compareAndSetState(state, state - arg)) {
                    return 1;
                }
            }
        }

        @Override
        //因为没有办法判断线程是否持有共享锁，为了防止随意释放，就直接抛 error 了
        //每次释放必定成功，因为每次释放，都应该唤醒等待队列中的线程
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int state = getState();
                int nextS = state + arg;
                if (nextS > max) {
                    throw new Error("acquire 和  release 的个数不相同！");
                }
                if (compareAndSetState(state, nextS)) {
                    return true;
                }
            }
        }
    }


}
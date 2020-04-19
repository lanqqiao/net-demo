package com.lqq.demo.sort;

import java.util.Arrays;

/**
 * @ClassName CountSort
 * @Description TODO
 * @Author jiebai
 * @Date 2020/1/9 11:44
 * @Version 1.0
 **/
public class CountSort {

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] aa = {3, -1, 2, 3, 1};
        CountingSort(aa);
    }
}

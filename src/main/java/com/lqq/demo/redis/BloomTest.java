package com.lqq.demo.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.math.BigInteger;

/**
 * @ClassName BloomTest
 * @Description TODO
 * @Author jiebai
 * @Date 2019/12/2 17:33
 * @Version 1.0
 **/
public class BloomTest {

    public static void main(String[] args) {
        BloomFilter bloomFilter = BloomFilter.create(Funnels.byteArrayFunnel(), 1000);

        //Putting elements into the filter
        //A BigInteger representing a key of some sort
        BigInteger bigInteger = new BigInteger("20");
        bloomFilter.put(bigInteger.toByteArray());
        BigInteger bitIntegerII = new BigInteger("22");
        //Testing for element in set
        boolean mayBeContained = bloomFilter.mightContain(bigInteger.toByteArray());
        System.out.println(mayBeContained);
    }
}

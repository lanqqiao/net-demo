package com.lqq.demo.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @ClassName 合并排序
 * @Description TODO
 * @Author jiebai
 * @Date 2020/1/6 15:27
 * @Version 1.0
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {85,3,52,9,7,1,5,4, 2};
        merge(arr);
    }

    /**
     *
     * @param arr
     */
    static void merge(int[] arr) {
        int length = arr.length;
        int mid = length / 2;
        if (mid == 0) {
            return;
        }
        int[] leftArr= Arrays.copyOfRange(arr,0,mid);//拷贝数组array的左半部分
        int[] rightArr=Arrays.copyOfRange(arr,mid,length);//拷贝数组array的右半部分
        System.out.println("-----------------------");
        System.out.println(JSON.toJSONString(leftArr));
        System.out.println(JSON.toJSONString(rightArr));
        // 递归至最小单位
        merge(leftArr); // 这里把arr变掉了！！找了半天
        merge(rightArr);
        sort(arr, leftArr, rightArr); // 这里的arr就是每个left,right
        System.out.println("++++++++++++++++++++++");
        System.out.println(JSON.toJSONString(arr));
    }

    /**
     * 排序
     * @param result
     * @param left
     * @param right
     */
    static void sort(int[] result, int[] left, int[] right) {
        int i=0,l=0,r=0;
        while(l<left.length&&r<right.length){
            if(left[l]<right[r]){
                result[i]=left[l];
                i++;
                l++;
            }else{
                result[i]=right[r];
                i++;
                r++;
            }
        }
        while(r<right.length){//如果右边剩下合并右边的
            result[i]=right[r];
            r++;
            i++;
        }
        while(l<left.length){
            result[i]=left[l];
            l++;
            i++;
        }
    }
}

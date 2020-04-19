package com.lqq.demo.sort;

/**
 * @ClassName FastSort
 * @Description 快速排序
 * @Author jiebai
 * @Date 2020/1/8 16:53
 * @Version 1.0
 **/
public class FastSort {
    public static int[] qsort(int arr[],int start,int end) {
        if (start > end) {
            return arr;
        }
        int i = start;
        int j = end;
        int temp = arr[start];
        while (i != j) {
            while (j > i && arr[j] >= temp) {
                j--; // 循环右边直到找到比temp小的值
            }
            while (j > i && arr[i] <= temp) {
                i++; // 循环左边直到找到比temp大的值
            }
            if (j > i) {
                int tem = arr[i]; // 将大值放右边，小值放左边
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }
        // 这个时候i等于j，互换中间那个数字和temp的位置，因为中间那个值肯定是小于temp的，所以放左边
        arr[start] = arr[i];
        arr[i] = temp;
        qsort(arr, start, i - 1); // 递归处理左边的
        qsort(arr, i + 1, end); // 递归处理右边的
        return (arr);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{5,3,2,9,8,10,7,6,1,4};
        int len = arr.length-1;
        arr=qsort(arr,0,len);
        for (int i:arr) {
            System.out.print(i+"\t");
        }
    }
}

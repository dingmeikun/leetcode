package com.java.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 1.挑选一个基准数据P，排序：小于P的放左边，大于P的放右边，这样P就在队列中间了，左为L1，右为R1
 * 2.分别对L1、R1做第一步处理，直至所有子序列都有序 -- 递归
 *
 */
public class 快速排序 {

    public static void main(String[] args) {
        int arr[] = new int[]{3,5,4,6,8,2,1,0,9};
        int brr[] = quickSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(brr));
    }

    private static int[] quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = pivot(arr, l, r);
            quickSort(arr, l, pivot);
            quickSort(arr, pivot, r);
        }

        return arr;
    }

    private static int pivot(int[] arr, int l, int r) {
        int pivot = l;
        int index = pivot + 1;
        for (int i = index; i <= r; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, index, i);
                index ++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    /*public static int[] quickSort(int[] arr, int left, int right) {
        int len = arr.length, partitionIndex;
        if (left < right) {
            partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);
        }
        return arr;
    }

    static int partition(int[] arr, int left ,int right) { // 分区操作
        int pivot = left, // 设定基准值（pivot）
        index = pivot + 1;
        for (int i = index; i <= right; i++){
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index-1;
    }*/

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


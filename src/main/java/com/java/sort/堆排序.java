package com.java.sort;

import java.util.Arrays;

public class 堆排序 {

    public static void main(String[] args) {
        int arr[] = new int[]{3,5,4,6,8,2,1,0,9};

        // 构造最顶堆：此时折半排序能保证前半部分序列是最顶堆结构（但是右半部分可能存在最大值/最小值）
        heapSort(arr);
        System.out.println("前半部分序列i"+ (arr.length/2) +"：" + Arrays.toString(arr));
        // 调整堆元素：将堆顶元素与最末元素交换，将最大元素沉降到数组末尾 -- 这一步能理解，就是实现有点奇怪！
        for (int i = arr.length - 1; i > 0 ; i--) {
            sweep(arr,0, i);    //将堆顶元素与末尾元素进行交换
            heapify(arr,0);         //重新对堆进行调整
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int arr[]) {
        int mid = arr.length/2;
        for (int i = mid; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private static void heapify(int arr[], int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int large = i;
        if (left < arr.length && arr[left] > arr[i]) {
            large = left;
        }

        if (right < arr.length && arr[right] > arr[i]) {
            large = right;
        }

        if (large != i) {
            sweep(arr, large, i);
            heapify(arr, large);
        }
    }

    private static void sweep(int[] arr, int large, int i) {
        int tmp = arr[i];
        arr[i] = arr[large];
        arr[large] = tmp;
    }

}

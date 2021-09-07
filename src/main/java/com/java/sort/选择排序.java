package com.java.sort;

/**
 * 选择排序：有一个数组arr[n]
 *  取arr[0]，然后从[1, n-1]获取最小的，与arr[0]比较，更小的放arr[0]
 *  取arr[1]，然后从[2, n-1]获取最小的，与arr[1]比较，更小的放arr[1]
 *  取arr[2]，然后从[3, n-1]获取最小的，与arr[2]比较，更小的放arr[2]
 *
 *  取arr[n-2]，然后从[n-1, n-1]获取最小的，与arr[n-2]比较，更小的放arr[n-2]
 *
 */
public class 选择排序 {

    public static void main(String[] args) {
        int arr[] = new int[]{3,5,4,6,8,2,1,0,9};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void selectSort(int arr[]) {
        int n = arr.length;
        int minK = 0;
        while (minK != (n - 1)) {
            for (int i = minK + 1; i < n; i++) {
                if (arr[minK] > arr[i]) {
                    int t = arr[i];
                    arr[i] = arr[minK];
                    arr[minK] = t;
                }
            }
            minK++;
        }
    }
}

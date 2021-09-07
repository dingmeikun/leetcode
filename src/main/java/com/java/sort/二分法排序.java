package com.java.sort;

public class 二分法排序 {

    public static void main(String[] args) {
        int arr[] = new int[]{0,1,2,3,4,5,6,8,9};
        int pos = twoSplitSort(arr, 2);
        System.out.println(pos);
    }

    private static int twoSplitSort(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (target > arr[mid]) {
                left = mid + 1;
            }
            else if (target < arr[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}

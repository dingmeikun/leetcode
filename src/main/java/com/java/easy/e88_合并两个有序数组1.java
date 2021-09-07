package com.java.easy;

import java.util.Arrays;

public class e88_合并两个有序数组1 {

    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge1(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = new int[]{4,5,6,0,0,0};
        int[] nums4 = new int[]{1,2,3};
        merge1(nums3, 3, nums4, 3);
        System.out.println(Arrays.toString(nums3));
    }

    /**
     * 双指针，一个指针指向第一个数组的遍历位置、另一个指针执行第二个数组的遍历位置
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,curr=0;
        int[] ret = new int[m+n];
        while (i<m || j < n) {
            if (i==m) {
                curr = nums2[j++];
            }else if (j == n) {
                curr = nums1[i++];
            }else if (nums1[i] > nums2[j]) {
                curr = nums2[j++];
            }else if (nums1[i] <= nums2[j]) {
                curr = nums1[i++];
            }

            ret[i+j-1] = curr;
        }
        for (int k = 0; k < m+n; k++) {
            nums1[k] = ret[k];
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m+n; i++) {
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}

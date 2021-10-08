package com.java.easy;

import java.util.Arrays;

public class e283_移动零 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        int[] nums1 = new int[]{1,0,2,0,5};
        //moveZeroes(nums);
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 移动数组中的零到数组末尾，并且不能额外拷贝数组
     *
     * 双指针：left=当前0位置，right=最后一个不为0的位置
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                move(nums, left, right);
                left ++;
            }
            right ++;
        }
    }

    public static void move(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

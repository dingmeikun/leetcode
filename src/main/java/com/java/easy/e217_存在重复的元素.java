package com.java.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class e217_存在重复的元素 {

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果存在一值在数组中出现至少两次，函数返回 <code>true</code> 。如果数组中每个元素都不相同，则返回 <code>false</code>
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println(containsDuplicate1(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate1(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate1(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    /**
     * 判断数组中是否重复元素，这里可以借助HashSet、排序等方法解决
     *
     *      HashSet
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() != nums.length;
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}

package com.java.medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
public class m16_最接近三数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int closest = threeSumClosest(nums, 1);
        System.out.println(closest);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int best = 1000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int b = i + 1, c = nums.length - 1;
            while (b < c) {

                int sum = nums[i] + nums[b] + nums[c];
                if (sum == target) {
                    return target;
                }

                if (Math.abs(target - best) > Math.abs(target - sum)) {
                    best = sum;
                }
                if (sum > target) {
                    c--;
                }else {
                    b++;
                }
            }
        }
        return best;
    }
}

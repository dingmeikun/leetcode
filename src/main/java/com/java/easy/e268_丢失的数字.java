package com.java.easy;

import java.util.Arrays;

public class e268_丢失的数字 {

    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     *
     * 输入：nums = [3,0,1]
     * 输出：2
     * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     *
     * 输入：nums = [0,1]
     * 输出：2
     * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 104
     * 0 <= nums[i] <= n
     * nums 中的所有数字都 独一无二
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[n-1] != n) {
            return n;
        }
        for (int i = 0; i <= n-2; i++) {
            if (nums[i+1] - nums[i] != 1) {
                return i+1;
            }
        }
        return -1;
    }
}

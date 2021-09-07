package com.java.easy;

public class e53_最大子序和 {

    /**
     * 求最长的子序列和
     *
     * @param args
     */
    public static void main(String[] args) {
        int maxSubArray = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(maxSubArray);
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0, ans = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}

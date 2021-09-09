package com.java.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class e169_多数元素 {

    public static void main(String[] args) {
        System.out.println(majorityElement1(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement1(new int[]{3,2,3}));
        System.out.println(majorityElement1(new int[]{3,3,4}));

        System.out.println();
        //System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        //System.out.println(majorityElement(new int[]{3,2,3}));
        //System.out.println(majorityElement(new int[]{3,3,4}));
        System.out.println(majorityElement(new int[]{-1,1,1,1,2,1}));
    }

    /**
     * 使用哈希法
     *
     * 找出数组n中，个数大于n/2的元素
     *
     * <strong>输入：</strong>[3,2,3]
     * <strong>输出：</strong>3
     *
     * <strong>输入：</strong>[2,2,1,1,1,2,2]
     * <strong>输出：</strong>2
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int cnt = map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1;
            if (cnt > m) {
                return nums[i];
            }
            map.put(nums[i], cnt);
        }
        return 0;
    }

    /**
     * 使用排序法
     *
     * <strong>输入：</strong>[2,2,1,1,1,2,2]
     * <strong>输出：</strong>2
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        int m = nums.length / 2, count = 0, min = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i: nums) {
            if (i != min) {
                min = i;
                count=1;
            }
            if (count++ > m) {
                break;
            }
        }
        return min;
    }
}

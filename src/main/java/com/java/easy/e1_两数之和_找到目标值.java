package com.java.easy;

import java.util.HashMap;
import java.util.Map;

public class e1_两数之和_找到目标值 {

    public static void main(String[] args) {
        int nums[] = new int[]{2,7,11,15};
        int target = 9;
        int[] sum = twoSum(nums, target);

        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++) {
            int current = target - nums[i];
            if(map.containsKey(current) && i != map.get(current)){
                return new int[]{i, map.get(current)};
            }
        }

        throw new IllegalArgumentException("no solution!");
    }
}

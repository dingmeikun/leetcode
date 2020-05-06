package com.dingmk.simple;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

	public static void main(String[] args) {
		int nums[] = {2, 7, 11, 15};
		int target = 9;
		int[] ret = twoSum(nums, target);
		System.out.println(ret);
	}
	
	 public static int[] twoSum(int[] nums, int target) {
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for (int i=0; i< nums.length; i++) {
			 map.put(nums[i], i);
		 }
		 
		 for (int i=0; i< nums.length; i++) {
			 int current = target - nums[i];
			 if (map.containsKey(current) && i != map.get(current)) {
				 return new int[]{i, map.get(current)};
			 }
		 }
		 
		 return new int[]{};
	 }
}

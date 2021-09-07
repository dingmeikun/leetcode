package com.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class m18_四数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        //int[] nums = new int[]{2,2,2,2};
        List<List<Integer>> list = fourSum(nums, 0);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if (null == nums || n < 4) {
            return list;
        }

        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }

                int three = j + 1;
                int four = n - 1;
                while (three < four) {
                    int sum = nums[i] + nums[j] + nums[three] + nums[four];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[three], nums[four]));
                        while (three < four && nums[three] == nums[three + 1]) {
                            three ++ ;
                        }
                        three ++;
                        while (three < four && nums[four] == nums[four - 1]) {
                            four -- ;
                        }
                        four --;
                    } else if (three < four && sum > target) {
                        four --;
                    }else if (three < four && sum < target) {
                        three ++;
                    }
                }
            }
        }
        return list;
    }
}

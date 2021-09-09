package com.java.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class e167_两数之和II_输入有序数组 {

    /**
     * 哈希法 - 保存部分常量，然后通过比对与target的值计算两数
     *
     * <strong>输入：</strong>numbers = [2,7,11,15], target = 9
     * <strong>输出：</strong>[1,2]
     * <strong>解释：</strong>2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *
     * <strong>输入：</strong>numbers = [2,3,4], target = 6
     * <strong>输出：</strong>[1,3]
     *
     * <strong>输入：</strong>numbers = [-1,0], target = -1
     * <strong>输出：</strong>[1,2]
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if (map.containsKey(tmp) && map.get(tmp) != i) {
                return new int[]{i+1, map.get(tmp) + 1};
            }
        }
        return null;
    }

    /**
     * 双指针 - 左右指针，一直向内移动
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int tmp = numbers[i] + numbers[j];
            if (tmp == target) {
                return new int[]{i+1, j+1};
            }
            if (tmp > target) {
                j--;
            }
            if (tmp < target) {
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2,7,11,15}, 9);
        int[] ints1 = twoSum(new int[]{2,3,4}, 6);
        int[] ints2 = twoSum(new int[]{-1,0}, -1);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));

        System.out.println();
        int[] ints12 = twoSum1(new int[]{2,7,11,15}, 9);
        int[] ints11 = twoSum1(new int[]{2,3,4}, 6);
        int[] ints21 = twoSum1(new int[]{-1,0}, -1);
        System.out.println(Arrays.toString(ints12));
        System.out.println(Arrays.toString(ints11));
        System.out.println(Arrays.toString(ints21));
    }
}

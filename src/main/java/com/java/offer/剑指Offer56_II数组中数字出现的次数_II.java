package com.java.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 剑指Offer56_II数组中数字出现的次数_II {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     * 输入：nums = [3,4,3,3]
     * 输出：4
     *
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3,4,3,3}));
        System.out.println(singleNumber(new int[]{9,1,7,9,7,9,7}));

        System.out.println(singleNumber2(new int[]{3,4,3,3}));
        System.out.println(singleNumber2(new int[]{9,1,7,9,7,9,7}));
    }

    /**
     * 哈希法，保存：Map(数字,次数) 的一个键值对，然后再对次数进行比对，或者删除次数=3的，剩下的就是次数=1的
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x, 1);
            } else {
                map.put(x, count + 1);
            }
            if (map.get(x) == 3) {
                map.remove(x);
            }
        }
        return (int) map.keySet().toArray()[0];
    }

    /**
     * 采用数组装载，如：{1,1,1,2,3,3,3,4,4,4}， 数组为：{0,3,1,3,3}
     *                                          下标：0 1 2 3 4
     * 此法问题挺大，因为题目约束是：
     *      1 <= nums.length <= 10000
     *      1 <= nums[i] < 2^31
     *
     * 取值为[1, 2^31]，所以数组下标会非常大，也即是说数组会很大，不适合！！！
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int[] ints = new int[Integer.MAX_VALUE]; // 超出内存限制！！
        for (int x : nums) {
            ints[x]++; // 数组越界，除非数组容量设置为最大：Integer.MAX_VALUE  超出内存限制！！
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 采用排序法：先将数组排序，然后再挨个遍历数组，看是否有一个重复元素的。
     *
     * @param nums 1,1,1,2,3,3,3,4,4,4
     * @return
     */
    public static int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i=i+3) {
            if (i == nums.length - 1 || nums[i] != nums[i+2]) {
                return nums[i];
            }
        }
        return -1;
    }
}

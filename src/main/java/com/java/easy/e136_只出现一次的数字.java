package com.java.easy;

public class e136_只出现一次的数字 {

    /**
     * e136_只出现一次的数字
     *
     *      我们知道，在计算机中，有位运算：& | ~ ^ 在针对二进制计算时，可以给与我们很大的便利。举个栗子：
     *
     *      1.判断奇偶数：3 => 0011 & 0001 = 0001 => 1
     *                  4 => 0100 & 0001 = 0000 => 0    所以：随机整数n & 1 == 1 ? "奇数" : "偶数";
     *
     *      2.异或的用法：不同为1，相同为0
     *                  3 ^ 3 => 0011 ^ 0011 = 0000 => 0
     *                  0 ^ 3 => 0000 ^ 0011 = 0011 => 3
     *
     *      所以：如果有数字重复出现，我们可以把数组挨个进行异或！(仅当出现2次，则异或后为0)
     *           （扩展：如果出现偶数次：则数字消失，如果出现奇数次：则只保留一个）
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}

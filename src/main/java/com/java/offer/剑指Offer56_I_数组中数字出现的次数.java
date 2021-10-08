package com.java.offer;

import java.util.Arrays;

public class 剑指Offer56_I_数组中数字出现的次数 {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumbers(new int[]{4,1,4,6})));
        System.out.println(Arrays.toString(singleNumbers(new int[]{1,2,10,4,1,4,3,3})));
    }

    /**
     * 注意：本题是：数组存在A、B数字只出现一次，其他数字都出现两次
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }

        // 此时ret=A^B， 因为C^C=0,D^D=0
        // 找到ret中，低位中出现的第一位1，我们知道，这位1，是A，B中的刚好不同的位，
        int m = 1;
        while((ret & m) == 0) {
            m <<= 1;
        }

        // 拿着这个位1，去nums中做&运算，则肯定能把A，B区分开来：假设：A:0110 B:0001 则：ret:0111，取第一位1：ret&m==0 算得：m：0001(使得&运算不为0)
        // 然后，在拿着m去和nums数组做&运算，区分两类：m&num == 0,和，m&num ！= 0，则刚好可以区分A，B，此时再由异或的交换律：
        // A ^ B ^ A = B
        // A ^ B ^ B = A   由此的A,B
        int x = 0, y = 0;
        for(int i : nums) {
            //这里我们是通过if...else将nums分为了两组，一边遍历一遍异或。
            //跟我们创建俩数组nums1和nums2原理是一样的。
            if((i & m) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        return new int[]{x, y};
    }
}

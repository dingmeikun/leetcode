package com.java.easy;

import java.util.Arrays;

public class e338_比特位计数 {

    /**
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     *
     * 输入：n = 2
     * 输出：[0,1,1]
     * 解释：
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }

    /**
     * 计算[0, n]中每个元素二进制1的个数
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = getCount(i);
        }
        return ans;
    }

    public static int getCount(int x) { // 3 011
        int count = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                count++;
            }
            x = x >> 1;
        }
        return count;
    }
}

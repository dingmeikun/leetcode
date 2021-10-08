package com.java.easy;

public class e342_4的幂 {

    /**
     * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
     *
     * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
     *
     * 输入：n = 16
     * 输出：true
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(256));
        System.out.println(isPowerOfFour(255));
    }

    /**
     * 本题，同326
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }
}

package com.java.easy;

public class e326_3的幂 {

    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     *
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     *
     * 输入：n = 27
     * 输出：true
     *
     * 输入：n = 9
     * 输出：true
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(45));
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}

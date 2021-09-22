package com.java.easy;

public class e231_2的幂 {

    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     *
     * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     * 示例：
     *
     *  输入：n = 1
     *  输出：true
     *  解释：20 = 1
     *
     *  输入：n = 16
     *  输出：true
     *  解释：24 = 16
     *
     *  要求：你能够不使用循环/递归解决此问题吗？
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(256));
    }

    /**
     * 很明显，这是一个类似于进制转换的问题，我们可以这样类思考：
     *
     *  2^0 = 1  1向左移动0位 >  1 = 1 << 0
     *  2^1 = 2  1向左移动1位 >  2 = 1 << 1
     *  2^2 = 4  1向左移动2位 >  4 = 1 << 2
     *  2^3 = 8  1向左移动3位 >  8 = 1 << 3
     *  ...
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if (n == (1 << i)) {
                return true;
            }
        }
        return false;
    }
}

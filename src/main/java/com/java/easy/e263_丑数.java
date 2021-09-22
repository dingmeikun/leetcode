package com.java.easy;

public class e263_丑数 {

    /**
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     *
     * 丑数 就是只包含质因数 2、3、5 的正整数
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isUgly(0));
        System.out.println(isUgly(1));
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
    }

    /**
     * 丑数就是能被：2、3、5整除，最后结果为1。  注意：是整除，不能留下余数！所以可以先判断是否能够整除，再去整除
     *
     * @param n
     * @return
     */
    public static boolean isUgly(int n) {
        while (true) {
            if (n <= 0) {
                return false;
            }
            if (n % 2 == 0) {
                n /= 2;
            }
            else if (n % 3 == 0) {
                n /= 3;
            }
            else if (n % 5 == 0) {
                n /= 5;
            } else {
                break;
            }
        }
        return n == 1;
    }
}

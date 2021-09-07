package com.java.easy;

public class e69_X的平方根 {

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(10));
        System.out.println(mySqrt(15));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(17));
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(2147483647));
    }

    /**
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     *
     * 注意：给的数据是Integer.MAX_VALUE时，前面几次计算的值将会溢出
     *      当使用二分法计算时，int的最大值的一半相乘，值肯定是会大于Integer的最大范围值，将变成一个负数，这时应该拿long类型相乘，且用long接收结果
     *
     *      int mid = l + (r - l)/2;
     *      int ret = mid * mid; // 当mid值很大时将数值溢出
     *
     *      long ret = (long)mid * mid;
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int i = 0, j = x;
        while (i <= j) {
            int mid = i + (j - i)/2;
            long tmp = (long)mid*mid;
            if (tmp == x) {
                return mid;
            } else if (tmp < x) {
                i = mid + 1;
            } else if (tmp > x) {
                j = mid - 1;
            }
        }
        return j;
    }

    public static int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

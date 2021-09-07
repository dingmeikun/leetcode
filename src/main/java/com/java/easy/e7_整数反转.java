package com.java.easy;

/**
 * e7_整数反转：有两种方式：1.使用字符串 2.使用数学
 *
 *  数字本身的反转，可以使用以下三步完美实现。
 *      int tmp = digit%10;
 *      res = res*10 + tmp;
 *      digit /= 10;
 *
 *  但是，本题有要求：反转后的数字不能超出Integer的存储范围，否则溢出！
 *  我们知道，Integer的存储范围是：[-2^31 ~ 2^31 - 1]，对于两个边界值：Integer.MAX_VALUE, Integer.MIN_VALUE，也就是[-2147483648, 2147483647]
 *
 *  所以这里有个结论：所得结果，不能超出[-2^31 ~ 2^31 - 1]的范围，否则溢出。
 *  也就是：res < Integer.MAX_VALUE  &&  res > Integer.MIN_VALUE 为了精确，还得考虑边界：res == Integer.MAX_VALUE
 *
 */
public class e7_整数反转 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        //System.out.println(reverse1(1534236469));
        System.out.println(reverse1(123));
    }

    public static int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int tmp = x % 10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && tmp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && tmp < -8)) {
                return 0;
            }

            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    public static int reverse1(int x) {
        int flag = x < 0 ? -1 : 1;
        x = Math.abs(x);
        long ans = 0;
        while (x != 0) {
            int i = x % 10;
            x = x / 10;
            ans = ans*10 + i;
            if (ans > ((1 << 31) - 1) || ans < (-(1 << 31))) {
                return 0;
            }
        }
        return (int)ans * flag;
    }
}

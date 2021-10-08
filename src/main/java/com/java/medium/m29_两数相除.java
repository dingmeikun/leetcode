package com.java.medium;

public class m29_两数相除 {

    /**
     * 解答失败: 测试用例:-2147483648 -1 测试结果:-2147483648 期望结果:2147483647 stdout:
     * @param args
     */
    public static void main(String[] args) {
        /*int divide = divide(-2147483648, -1);
        System.out.println(divide);*/

        System.out.println(1 << 31);
    }

    /*public static int divide(int dividend, int divisor)
    {
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;

        long aa = Math.abs((long)dividend);
        long bb = Math.abs((long)divisor);

        int time_bit_cnt = 0;
        while (aa >= bb)
        {
            time_bit_cnt ++;
            bb <<= 1;
        }

        long time = 0;
        while (time_bit_cnt > 0)
        {
            time_bit_cnt --;
            bb >>= 1;
            if (aa >= bb)
            {
                aa -= bb;
                time += (1L << time_bit_cnt);
            }
        }
        if (sign < 0)
            time = 0 - time;
        return -(1L << 31) <= time && time <= (1L << 31) - 1 ? (int)time : (int)((1L << 31) - 1);

    }*/

    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }

        boolean up = true;
        if ((dividend > 0 && divisor < 0) || dividend < 0 && divisor > 0) {
            up = false;
        }
        if (divisor == -1 && !up) {
            return -dividend;
        }
        if (divisor == -1 && up) {
            if (dividend == -(1l << 31)) {
                dividend = -(dividend + 1);
            } else {
                dividend = -dividend;
            }
            return dividend;
        }

        int divide = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend == divisor) {
            if (!up) {
                return -1;
            }
            return 1;
        }

        while(dividend - divisor >= 0){
            dividend-=divisor;
            ++divide;
        }

        divide = !up ? -divide : divide;
        if (divide < -(1l << 31)) return (int)-(1l << 31);
        if (divide > (1l << 31) - 1) return (int)(1l << 31) - 1;
        return divide;
    }
}

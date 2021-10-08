package com.java.easy;

public class e_258各位相加 {

    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 示例:
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     *
     * 进阶:
     * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits1(38));
    }

    /**
     * 题解上的答案
     *
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 计算num的相加值
     *
     * 38/10 = 3
     * 38%10 = 8
     *
     * @param num
     * @return
     */
    public static int addDigits1(int num) {
        int ans = 0;
        while(num != 0) {
            ans+= num%10;
            num/=10;
            if (num == 0 && ans/10 > 0) {
                num = ans;
                ans = 0;
            }
        }
        return ans;
    }
}

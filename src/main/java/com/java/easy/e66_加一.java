package com.java.easy;

import java.util.Arrays;

public class e66_加一 {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        //System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        //System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1,9,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }

    public static int[] plusOne(int[] digits) {
        int up=0, ans;
        int n = digits.length - 1;
        digits[n] = digits[n] + 1;
        while (n >=0) {
            int curr = digits[n] + up;
            up = curr/10;
            ans = curr%10;

            digits[n] = ans;
            n--;
        }

        if (up != 0) {
            int length = digits.length;
            int[] ret = new int[length+1];
            ret[0] = up;
            int i = 0;
            while (++i < length) {
                ret[i+1] = digits[i];
            }
            return ret;
        }
        return digits;
    }
}

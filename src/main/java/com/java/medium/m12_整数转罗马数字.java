package com.java.medium;

import java.util.HashMap;
import java.util.Map;

public class m12_整数转罗马数字 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("I", 1);
            put("IV",4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};

        System.out.println(intToRoman(3)); // III
        System.out.println(intToRoman(4)); // IV
        System.out.println(intToRoman(9)); // IX
        System.out.println(intToRoman(58)); // LVIII
        System.out.println(intToRoman(3998)); // MMMCNXCVIII
    }

    /**
     * 58 -> 50 + 5 + 3
     * LVIII
     *
     * 3998 -> 1000 + 1000 + 1000 + 900 + 90 + 5 + 3
     *  MMMCNXCVIII
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        int[] sign = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] value = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String ans = "";
        for (int j = 0; j < sign.length; j++) {
            while (num >= sign[j]) {
                num -= sign[j];
                ans += value[j];
            }
        }
        return ans;
    }
}


package com.java.easy;

import java.util.HashMap;
import java.util.Map;

public class e13_罗马数字转整数 {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);put('V', 5);put('X', 10);put('L', 50);put('C', 100);put('D', 500);put('M', 1000);
    }};

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }


    /**
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * 1000 + 900 + 90 + 4
     *
     * 解释："MCMXCIV" 遍历数组CharArray：
     * for i
     *  if i<i+1  then -i
     *  if i>=i+1 then +i
     *
     *  就会有：
     *  +M -C +M -X +C -I +V
     *     1000 - 100 + 1000 - 10 + 100 - 1 + 5 = 1990 - 1 + 5 = 1994
     */
    public static int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (map.get(chars[i]) < map.get(chars[i+1])) {
                res -= map.get(chars[i]);
            }
            if (map.get(chars[i]) >= map.get(chars[i+1])) {
                res += map.get(chars[i]);
            }
        }

        res += map.get(chars[chars.length - 1]);
        return res;
    }
}

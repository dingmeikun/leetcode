package com.java.easy;

import java.util.HashMap;
import java.util.Map;

public class e168_Excel表列名称 {

    /**
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     *
     * <strong>输入：</strong>columnNumber = 1
     * <strong>输出：</strong>"A"                  = 26^0*A
     *
     * <strong>输入：</strong>columnNumber = 28    : 28 >= 26^1
     * <strong>输出：</strong>"AB"                 = 26^1*A + 26^0*B = 26+2
     *
     * <strong>输入：</strong>columnNumber = 701   : 701 >= 26^2
     * <strong>输出：</strong>"ZY"                 = 26^1*26 + 26^0*Y = 26*26+25
     *
     * <strong>输入：</strong>columnNumber = 1800  :
     * <strong>输出：</strong>"BQF"                 = 26^2*2 + 26^1*17 + 26^0*6
     *
     * <strong>输入：</strong>columnNumber = 2147483647
     * <strong>输出：</strong>"FXSHRXW"            = W + X + R + H + S + X + F
     *                                            = 23 + 26*
     *
     * Map<Character, Integer> map = new HashMap<Character, Integer>(){{
     *             put('A', 1);put('B', 2);put('C', 3);put('D', 4);put('E', 5);put('F', 6);put('G', 7);
     *             put('H', 8);put('I', 9);put('J', 10);put('K', 11);put('L', 12);put('M', 13);put('N', 14);
     *             put('O', 15);put('P', 16);put('Q', 17);put('R', 18);put('S', 19);put('T', 20);put('U', 21);
     *             put('V', 22);put('W', 23);put('X', 24);put('Y', 25);put('Z', 26);
     *         }};
     *
     * 取值：[A-Z]     1 - 26
     *      [AA-ZZ]     27(26) - 702(26*26+26)
     *      [AAA-ZZZ]
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(convertToTitle(26)); // Z
        System.out.println(convertToTitle(676));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(29));
        System.out.println(convertToTitle(1800));
    }

    /**
     * 相当于进制转换：10进制 转 26进制
     *
     *  输入：1800 转26进制
     *
     *     1800%26 = 6 +'A' = F
     *     1800/26 = 69
     *
     *     69%26 = 17 + 'A' = Q
     *     69/26 = 2
     *
     *     2%26 = 2 + 'A' = B
     *
     *
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            columnNumber--;             // 这个是必须的，因为在边界值：26的整数倍时，会导致除尽值而进位
            int a = columnNumber % 26;
            sb.append((char)(a + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}

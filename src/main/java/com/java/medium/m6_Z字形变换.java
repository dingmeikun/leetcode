package com.java.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 题意：将字符串按照Z的形状，先从上到下、再从左到右 的方式排列字符串。
 * 输入：ABCDEFGHIJKLMN  层数：3层
 * 排列：3层                4层                  5层
 *      A   E   I   M       A     G     N       A     I
 *      B D F H J L N       B   F H   M         B   H J
 *      C   G   K           C E   I L           C  G  K
 *                          D     K             D F   L N
 *                                              E     M
 *  输出：AEIM BDFHJLN CBK 这样串起来的字符串：AEIMBDFHJLNCGK
 */
public class m6_Z字形变换 {

    public static void main(String[] args) {
        String convert2 = convert("A", 3); // "A"
        String convert = convert("PAYPALISHIRING", 3); // "PAHNAPLSIIGYIR"
        String convert1 = convert("ABCDEFGHIJKLMN", 3); // "AEIMBDFHJLNCGK"
        System.out.println(convert2);
        System.out.println(convert);
        System.out.println(convert1);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // 先构造numRows个String数组，用以装载numRows行数据
        int min = Math.min(numRows, s.length());
        StringBuffer[] list = new StringBuffer[min];
        for (int i = 0; i < min; i++) { // 避免s的长度小于numRows
            list[i] = new StringBuffer();
        }

        // 拆分并遍历s串，将其存放到先前构造的String数组中
        // 注意：需要设置/获取当前数组，得知现在需要将c字符放到哪个数组中了
        //      设置/获取当期数组，可以通过临建值[0, list.size-1]两个端点，让一个flag:int flag = 1/-1，来对当前数组位置+1,-1
        int curr = 0;
        boolean pos = false; // true为正向，false为反向
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (curr == 0 || curr == list.length-1) {
                pos = !pos;
            }
            list[curr].append(chars[i]);
            curr += pos ? 1 : -1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
        }
        return sb.toString();
    }
}

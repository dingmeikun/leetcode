package com.java.easy;

public class e171_Excel表列序号 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("FQB"));
        System.out.println(titleToNumber("FXSHRXW"));
    }

    /**
     * 将Excel表格列序号，转化为数字，题型与168类似
     *
     * 题解：
     *      A = 26^0*A = 1
     *      AB = 26^0*B + 26^1*A = 1*2 + 26*1 = 28
     *      ZY = 26^0*Y + 26^1*Z = 1*25 + 26*26 = 701
     *
     * @param columnTitle
     * @return
     */
    public static int titleToNumber(String columnTitle) {
        int ans = 0, muti = 1;
        for (int i = columnTitle.length()-1; i >= 0 ; i--) {
            char c = columnTitle.charAt(i);
            ans += (muti * (c - 'A' + 1));
            muti *= 26;
        }
        return ans;
    }
}

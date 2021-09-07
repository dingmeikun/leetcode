package com.dingmk.leetcode.easy;

public class e67_二进制求和 {

    /**
     * e67_二进制求和
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) {
            return "0";
        } else if (!a.equals("0") && b.equals("0")) {
            return a;
        } else if(a.equals("0") && !b.equals("0")) {
            return b;
        }

        String ret = "";
        int up = 0, ans;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || up != 0) {
            int sum = 0;
            if (i >= 0) {
                sum+=a.charAt(i)-48; // sum+=a.charAt(i)-'0'; char字符类型转整型需要减去'0'[48]的值
                i--;
            }
            if (j >= 0) {
                sum+=b.charAt(j)-48; // sum+=b.charAt(j)-'0';
                j--;
            }

            sum+= up;
            up = sum/2;
            ans = sum%2;

            ret = ans + ret;
        }
        return ret;
    }
}

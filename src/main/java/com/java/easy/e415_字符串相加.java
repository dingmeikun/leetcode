package com.java.easy;

/**
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 */
public class e415_字符串相加 {

    public static void main(String[] args) {
        System.out.println(addStrings("123", "456"));
        System.out.println(addStrings("99", "1"));
        System.out.println(addStrings("99", "99"));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1, up = 0, curr;
        String ans = "";
        while(i>=0 || j>=0 || up != 0) {
            int sum = 0;
            if (i>=0) {
                sum += num1.charAt(i) - '0';
                i --;
            }
            if (j>=0) {
                sum += num2.charAt(j) - '0';
                j --;
            }

            sum += up;
            up = sum / 10;
            curr = sum % 10;
            ans = curr + ans;
        }
        return ans;
    }
}

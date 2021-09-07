package com.java.medium;

public class m8_字符串转换整数 {

    public static void main(String[] args) {
        String a = "-42"; // 42
        String b = "words and 987"; // 987
        String c = "4193 with words"; // 4193
        String d = "   -42"; // -42
        String s = "-91283472332"; // -91283472332
        /*System.out.println(myAtoi(a));
        System.out.println(myAtoi(b));
        System.out.println(myAtoi(c));
        System.out.println(myAtoi(d));*/
        System.out.println(myAtoi(s));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("21474836460"));
        System.out.println(Integer.MAX_VALUE);
    }

    public static int myAtoi(String s) {
        if (null == s || s.trim().length() == 0) {
            return 0;
        }

        // 先去前导空格，并记录当前位置
        int i = 0;
        int k = 1;
        int length = s.length();
        while (s.charAt(i) == ' ') {
            i++;
        }

        // 此时处理边界值：当为空格符，或者：不为+、不为-、不为数字 时，需要直接返回0
        char cs = s.charAt(i);
        if (i == length || (cs != '+' && cs != '-' && (cs > '9' || cs < '0'))) {
            return 0;
        }

        // 记录当前符合：开头 要么为+/-，要么为数字，如果是+/-，则获得标志位：-1 +1，作为最后与结果相乘，得到正数、负数
        if (cs == '+' || cs == '-') {
            if (cs == '-') {
                k = -1;
            }
            i++;
        }

        // 计算剩下的字符串：采取：curr = curr*10 + (s.charAt(i) - '0');累加数值
        // 注意：1、Char代表的值，也会是整数，但是不是真实的数值，需要扣减 - '0'
        //      2、在新增的过程当中，需要判断当前值是否大于Integer最大值，是否小于Integer最小值，需要约定边界 ps：test case存在:"2000000000000000000"这种！
        Long ans = 0L;
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c > '9' || c < '0') {
                break;
            }

            ans = ans*10 + (c - '0');
            if (ans*k > ((1l << 31) - 1)) {
                return (int)((1l << 31) - 1);
            }
            if (ans*k < -(1l << 31)) {
                return (int)-(1l << 31);
            }
        }
        return ans.intValue()*k;
    }
}

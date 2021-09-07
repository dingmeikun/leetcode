package com.java.easy;

public class e14_最长公共前缀 {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "fly", "flush"};
        System.out.println(longestCommonPrefix(strs));
    }

    // 暴力求解法:消耗空间时间
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0 || strs[0].length() == 0) {
            return "";
        }

        int succ = 0;
        int len = strs[0].length();
        while(true) {
            String prefix = strs[0].substring(0, len);
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    len --;
                    break;
                } else {
                    succ ++;
                }
            }

            if (len == 0 || succ == strs.length) {
                break;
            }

            succ = 0;
        }

        if (len != 0) {
            return strs[0].substring(0, len);
        } else {
            return "";
        }
    }
}

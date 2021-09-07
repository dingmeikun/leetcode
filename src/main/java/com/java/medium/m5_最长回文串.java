package com.java.medium;

public class m5_最长回文串 {

    public static void main(String[] args) {
        //String s = "babad";
        String s = "aacddct";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }

        int n = s.length();
        int maxLength = 1;
        int start = 0;
        int end = 0;

        boolean[][] dp = new boolean[n][n]; // 表示从l -> r 是否为回文串
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (r - l + 1> maxLength) {
                        maxLength = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}

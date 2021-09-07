package com.java.easy;

public class e28_实现strStr {

    public static void main(String[] args) {
        System.out.println(strStr1("haystack", "needle"));
        System.out.println(strStr1("haystack", ""));
        System.out.println(strStr1("haystack", "sta"));
        System.out.println(strStr1("haystack", "a"));
    }

    /**
     * 暴力解法 - 双层for循环遍历，主要遍历needle串的每个字符，是否在haystack某个位置的子串一模一样
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (null == needle || needle.trim().length() == 0) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();
        for(int i = 0; i <= n - m ; i++) {
            boolean exist = false;
            for(int j = 0;j < m; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    exist = true;
                }
            }
            if (!exist) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 暴力解法二：实质也是暴力解法，去除了第二层for循环
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr1(String haystack, String needle) {
        if (null == needle || needle.trim().length() == 0) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();
        for(int i = 0; i <= n - m ; i++) {
            int j = i, a = 0;
            while(a < m && haystack.charAt(j) == needle.charAt(a)) {
                j++;
                a++;
            }

            if (a == m) {
                return i;
            }
        }

        return -1;
    }
}

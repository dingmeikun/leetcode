package com.java.easy;

public class e409_最长回文串409 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("abcycidd"));
    }

    /**
     * 注意：这不是求最长回文子串，而是求：给定的字符串可以组成的最长回文子串
     *
     * 解答：1、当某个字符出现了n次时，那么我们构造的回文子串就可以有长度为n的子串
     *      2、如果多个字符出现x次，那么要分情况，如果都是偶数次数，那没问题啊，直接全加起来就是最长回文子串了
     *      3、但是如果某个字符出现x次，而x为奇数，那么我们是不能全加起来的，因为回文中心只能没有，或者只有一个：abba、abbba
     *
     * 题解：1、先计算每个字符出现的次数，使用数组构造每个字符出现的次数。
     *      2、在计算每个字符能组成的最长回文串：如果是偶数则取：ans += its[i]/2 * 2;
     *                                     如果是奇数则取：ans += its[i]/2 * 2;
     *                                      同时继续判断：1、是否没有除尽？ 2、现有结果是否为偶数？[保证如果有多个奇数次数，只能有一个回文中心]
     *                                          if (its[i] % 2 == 1 && ans % 2 == 0)
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        int[] its = new int[128];
        for (int i = 0; i < s.length(); i++) {
            its[s.charAt(i)]++;
        }

        int ans = 0;
        for (int i = 0; i < its.length; i++) {
            ans += its[i] / 2 * 2;
            if (its[i] % 2 == 1 && ans % 2 == 0) {
                ans ++;
            }
        }
        return ans;
    }
}

package com.java.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串s ，请你找出其中不含有重复字符的 "最长子串" 的长度。</p>
 */
public class m3_无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        /*int length = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start=0, end=0; end < length; end ++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;*/
        int ret = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = map.get(c);
            }
            ret = Math.max(ret, end - start + 1);
            map.put(c, end + 1);
        }
        return ret;
    }

    // 滑动窗口
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}

package com.java.offer;

import java.util.*;

public class 剑指Offer_50第一个只出现一次的字符 {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * 示例 1:
     *
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 示例 2:
     *
     * 输入：s = ""
     * 输出：' '
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar(""));
        System.out.println(firstUniqChar("aadadaad"));
    }

    public static char firstUniqChar(String s) {
        if (s.trim().length() == 0) {
            return ' ';
        }

        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>(chars.length);
        List<String> repeat = new ArrayList<>(chars.length);
        for (char c : chars) {
            String cs = String.valueOf(c);
            if (!list.contains(cs)) {
                if (!repeat.contains(cs)) {
                    list.add(cs);
                }
                continue;
            }
            list.remove(cs);
            repeat.add(cs);
        }

        return list.isEmpty() ? ' ' : list.get(0).charAt(0);
    }



















}

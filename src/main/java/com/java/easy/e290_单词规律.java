package com.java.easy;

import java.util.HashMap;
import java.util.Map;

public class e290_单词规律 {

    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 示例1:
     *
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     *
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }

    /**
     * 判断s是否是pattern格式的数据，此题题解同：205 （其他题解可以看leetcode题解）
     *
     *  1.拆解pattern或者s为相同结构，这里考虑到s中包含的单词，将他们组装为String[]
     *  2.然后使用哈希法，将String[]中的元素挨个遍历，并且将出现频率转换为通用的1221的形式
     *  3.比对两个String[]的结果
     *
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");

        char[] chars = pattern.toCharArray();
        String[] s2 = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            s2[i] = String.valueOf(chars[i]);
        }

        return getSyntex(s1).equals(getSyntex(s2));
    }

    public static String getSyntex(String[] s) {
        StringBuffer ans = new StringBuffer();

        Map<String, Integer> map = new HashMap<>();
        int i = 0, j = 1, n = s.length;
        while (i < n) {
            Integer count = map.get(s[i]);
            if (count == null) {
                map.put(s[i], j);
                j++;
            }
            ans.append(map.get(s[i]));
            i++;
        }
        return ans.toString();
    }


    /**
     * 判断字符串是否为pattern格式的数据
     *
     *  题意理解错误，这里只判断了s字符串的首字母的格式，是否符合pattern
     *
     *
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern1(String pattern, String s) {
        StringBuffer ss = new StringBuffer();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            ss.append(split[i].charAt(0));
        }

        return getSyntex1(pattern).equals(getSyntex1(ss.toString()));
    }

    public static String getSyntex1(String s) {
        StringBuffer ans = new StringBuffer();

        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 1, n = s.length();
        while (i < n) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), j);
                j++;
            }
            ans.append(map.get(s.charAt(i)));
            i++;
        }
        return ans.toString();
    }
}

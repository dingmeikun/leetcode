package com.java.easy;

public class e58_最后一个单词的长度 {

    /**
     * 求字符串最后一个单词的长度
     * 注意：字符串最后可能有很多空格，需要先取出空格。同时注意边界值，null "" " "
     *
     * @param args
     */
    public static void main(String[] args) {
        /*System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord("hello world "));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord(" "));*/
        System.out.println(lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord("aa"));
    }

    public static int lengthOfLastWord(String s) {
        if (null == s || s.trim().length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int idx = chars.length-1;
        while (chars[idx] == ' ') {
            idx--;
        }

        int ans = 0;
        while (idx >= 0 && chars[idx] != ' ') {
            ans ++;
            idx --;
        }
        /*for (int i = idx; i >= 0; i--) {
            chars
        }*/

        return ans;
    }
}

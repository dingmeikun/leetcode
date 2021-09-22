package com.java.easy;

public class e205_同构字符串 {

    public static void main(String[] args) {
        //System.out.println(isIsomorphic("egg", "add"));
        //System.out.println(isIsomorphic("foo", "bar"));
        //System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        return getPhic(s).equals(getPhic(t));
    }

    public static String getPhic(String s) {
        int count = 1;
        int[] so = new int[128];
        StringBuffer ss = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (so[c] == 0) {
                so[c] = count;
                count++;
            }
            ss.append(so[c]);
        }

        return ss.toString();
    }

    public static boolean isIsomorphic1(String s, String t) {
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    private static String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }
}

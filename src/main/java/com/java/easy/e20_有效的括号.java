package com.java.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class e20_有效的括号 {

    private static Map<Character, Character> cPair = new HashMap<Character, Character>(){{
        put('[', ']'); put('(', ')'); put('{', '}');
    }};

    public static void main(String[] args) {
        String s = "[";
        String s1 = "[]";
        String s2 = "[]}";
        String s3 = "{[]}";
        String s4 = "{{[]}}";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }

    public static boolean isValid(String s) {
        if (s.length() < 0 || !cPair.containsKey(s.charAt(0))) {
            return false;
        }

        LinkedList<Character> list = new LinkedList<Character>(){{add('?');}};
        for(Character c : s.toCharArray()) {
            if (cPair.containsKey(c)) {
                list.addLast(c);
            }else if (!c.equals(cPair.get(list.removeLast()))) {
                return false;
            }
        }

        return list.size() == 1;
    }
}

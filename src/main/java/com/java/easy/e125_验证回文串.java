package com.java.easy;

public class e125_验证回文串 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char a = s.charAt(left);
            char b = s.charAt(right);
            if (isValid(a) && isValid(b) && a != b) {
                return false;
            }

            if (!isValid(a)) {
               left ++;
               continue;
            }

            if (!isValid(b)) {
                right --;
                continue;
            }

            left ++;
            right --;
        }
        return true;
    }

    public static boolean isValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}

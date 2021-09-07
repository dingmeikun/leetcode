package com.java.easy;

public class e9_数字回文数 {

    public static void main(String[] args) {
        int x = 344;
        int y = 3443;
        int z = 3456543;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(y));
        System.out.println(isPalindrome(z));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int ori = x;
        int exp = 0;
        while (x != 0) {
            int tmp = x%10;

            x /= 10;
            exp = exp*10 + tmp;
        }

        if (ori == exp) {
            return true;
        }

        return false;
    }
}

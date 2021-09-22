package com.java.easy;

public class e204计算质数 {

    public static void main(String[] args) {
        /*System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(4));
        System.out.println(countPrimes(5));
        System.out.println(countPrimes(10));*/
        System.out.println(countPrimes(5000000));
    }

    public static int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                ans++;
            }
        }
        return ans;
    }

    public static boolean isPrimes(int x) {
        int max = (int)Math.sqrt(x);
        for (int i = 2; i <= max; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

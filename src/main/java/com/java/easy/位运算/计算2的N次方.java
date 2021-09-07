package com.java.easy.位运算;

public class 计算2的N次方 {

    public static void main(String[] args) {
        System.out.println(pow(6));
    }

    // 6    0110
    static int pow(int n){
        int ret = 1;
        int tmp = 2;
        while (n != 0) {
            if ((n & 1) == 1) {
                ret *= tmp;
            }
            ret *= tmp;
            n = n >> 1;
        }
        return ret;
    }

    static int pow1(int n){
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= 2;
        }
        return ans;
    }
}

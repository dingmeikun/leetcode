package com.java.easy.位运算;

/**
 * 输入两个数，计算器二进制有几个不同
 * 1 0001
 * 4 0100
 *   0101
 *
 */
public class 计算两个数二进制有多少位不同 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
        System.out.println(Integer.bitCount(1^4));
    }

    public static int hammingDistance(int x, int y) {
        int res = 0;
        int ins = x ^ y;
        while (ins != 0) {
            if ((ins & 1) == 1) {
                res ++ ;
            }
            ins = ins >> 1;
        }
        return res;
    }
}

package com.java.easy;

/**
 * 青蛙每次只能跳1阶、2阶
 *  比如   a b    a表示1，b表示2
 *      2：11 2
 *      3：111 12 21
 *      4：1111 121 112 211 22
 *
 *  1 1 2 3 5 8 13 21
 *  1 1 2 3 4 5 6  7
 *
 * 所以最终的结果是：f(n) = f(n-1) + f(n-2)
 *
 */
public class 剑指Offer10_II_青蛙跳1或2到n级台阶 {

    public static void main(String[] args) {
        System.out.println(getSteps(46));
    }

    public static int getStep(int n){
        if(n<2) return 1;
        int a=1;
        int b=1;
        for(int i=2;i<=n;i++){
            a=a+b;
            b=a-b;
            a=a>=1000000007?(a-1000000007):a;
        }
        return a;
    }

    public static int getSteps(int n) {
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            a = a + b;
            b = a - b;
            a=a%1000000007;
        }

        return a;
    }
}

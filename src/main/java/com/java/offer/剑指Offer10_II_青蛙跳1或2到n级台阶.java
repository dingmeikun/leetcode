package com.java.offer;

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

    /**
     * 跳N阶台阶
     *
     *      一般思路：递归、滚动数组
     *      递归：台阶n不大是，很适合使用递归跳n阶台阶，但是n过大时，递归过深将导致栈溢出
     *      滚动数组：当台阶n比较大时，可以使用滚动数组，也就是通过两个变量一直记录之前两次的值，不同滚动到n（也是一种阶乘思想）
     *
     * @param n
     * @return
     */
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

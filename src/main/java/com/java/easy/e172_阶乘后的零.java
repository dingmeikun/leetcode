package com.java.easy;

public class e172_阶乘后的零 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
    }

    /**
     * 计算阶乘：n!  其中结果尾部带了几个0
     *
     *      例：5！=120 返回：1
     *         10！=3628800 返回：2
     *
     *      分析：1*2*3*4*5*6*7*8*9*10 = 3628800
     *          我们可以知道：10是由:2*5得来的，而如果阶乘中有·*5·则可以肯定一定会有0，因为2*x < 5*x
     *
     *      结论：只需要算的n中有多少个`5`即可
     *
     *      论证：5! 1个5 1
     *          10！2个5 2
     *          15！3个5 3
     *          20！4个5 4
     *          25！5个5 5 ? 发现并非如此：当25时，是6个0，所以当n为25整数倍时，需要+1
     *
     *      同理：当n为25*5=125时需要+1 +1，这就有：n/5 + n/25 + n/125这种规律，也就是当是5的次方时，没遇到一个都+1
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            count += n/5;
            n = n/5;
        }
        return count;
    }
}

package com.java.easy;

public class e202_快乐数 {

    /**
     * 编写一个算法来判断一个数 <code>n</code> 是不是快乐数。</p>
     * <p>「快乐数」定义为：</p>
     *
     * <ul>
     * 	<li>对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。</li>
     * 	<li>然后重复这个过程直到这个数变为 1，也可能是 <strong>无限循环</strong> 但始终变不到 1。</li>
     * 	<li>如果 <strong>可以变为</strong>  1，那么这个数就是快乐数。</li>
     * </ul>
     *
     * <p>如果 <code>n</code> 是快乐数就返回 <code>true</code> ；不是，则返回 <code>false</code> 。</p>
     *
     * <strong>输入：</strong>19
     * <strong>输出：</strong>true
     * <strong>解释：
     * 1<sup>2</sup> + 9<sup>2</sup> = 82
     * 8<sup>2</sup> + 2<sup>2</sup> = 68
     * 6<sup>2</sup> + 8<sup>2</sup> = 100
     * 1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    /**
     * 判断这类的是否是：1 循环的、 2 终点是否一致(且可循环)   均可以考虑快慢数组实现！
     *
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int fast = getHappySum(n), slow = n;
        while (fast != slow) {
            fast = getHappySum(getHappySum(fast));
            slow = getHappySum(slow);
        }
        return slow == 1;
    }

    public static int getHappySum(int m) {
        int sum=0;
        while (m != 0) {
            int tmp = m%10;
            sum+= tmp*tmp;
            m /= 10;
        }
        return sum;
    }
}

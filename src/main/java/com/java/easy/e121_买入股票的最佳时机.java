package com.java.easy;
import static java.lang.System.out; // 静态导包：导入静态方法
/**
 * e121_买入股票的最佳时机
 *
 *  7,1,5,3,6,4
 *  最大收益时卖出：5
 *
 *  7,5,3,4,6,1,6
 *  最大收益时卖出：5
 *
 */
public class e121_买入股票的最佳时机 {

    public static void main(String[] args) {
        int prices[] = new int[]{7,1,5,3,6,4};
        int prices1[] = new int[]{7,5,3,4,6,1,6};
        //System.out.println(maxProfit1(prices));
        out.println(maxProfit1(prices1));
    }

    public static int maxProfit(int[] prices) {
        int minPrices = prices[0];
        int maxPrices = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            }

            if (maxPrices < prices[i] - minPrices) {
                maxPrices = prices[i] - minPrices;
            }
        }
        return maxPrices;
    }

    public static int maxProfit1(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (max < prices[i] - min) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}

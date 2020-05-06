package com.dingmk.simple;

/**
 * 输入: [7,1,5,3,6,4]
        输出: 5
 * @author LUMI
 *
 */
public class 买股票的最佳时机 {
	
	public static void main(String[] args) {
//		int prices[] = {7,1,5,3,6,4};
//		int prices[] = {7,6,5,4,3,2};
		int prices[] = {2,5,1,3};
		
		int max = maxProfit(prices);
		System.out.println(max);
	}

	/**
	 *  方法一 暴力求解
	 *  
	 *  思路：1.一个一维数组，求内部数值某两个数值相差为最大，可使用两个for循环遍历相减，直接求得最大值。（暴力求解）
	 *  
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int max = 0;
		for(int i=0;i<prices.length;i++) {
			for(int j=i+1;j<prices.length;j++) {
				int temp = prices[j] - prices[i];
				if(temp>max) {
					max = temp;
				}
			}
		}
		
		return max;
    }
	
	/**
	 *  方法二 一次遍历
	 *  
	 *  思路：1.求得数值内部相差最大，可以换一个思路：获得里面的最小值，同时保存，再去遍历相减
	 *  
	 * @param prices
	 * @return
	 */
	public static int maxProfit1(int[] prices) {
		int minprices = Integer.MAX_VALUE;
		int maxprofit = 0;
		
		for (int i=0;i<prices.length;i++) {
			if (prices[i] < minprices) {
				minprices = prices[i];
			}
			
			else if (prices[i] - minprices > maxprofit) {
				maxprofit = prices[i] - minprices;
			}
		}
		
		return maxprofit;
	}
}

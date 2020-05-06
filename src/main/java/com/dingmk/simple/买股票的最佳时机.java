package com.dingmk.simple;

/**
 * ����: [7,1,5,3,6,4]
        ���: 5
 * @author LUMI
 *
 */
public class ���Ʊ�����ʱ�� {
	
	public static void main(String[] args) {
//		int prices[] = {7,1,5,3,6,4};
//		int prices[] = {7,6,5,4,3,2};
		int prices[] = {2,5,1,3};
		
		int max = maxProfit(prices);
		System.out.println(max);
	}

	/**
	 *  ����һ �������
	 *  
	 *  ˼·��1.һ��һά���飬���ڲ���ֵĳ������ֵ���Ϊ��󣬿�ʹ������forѭ�����������ֱ��������ֵ����������⣩
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
	 *  ������ һ�α���
	 *  
	 *  ˼·��1.�����ֵ�ڲ������󣬿��Ի�һ��˼·������������Сֵ��ͬʱ���棬��ȥ�������
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

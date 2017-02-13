package vSourabh.dataStructures.array;

/**
 * @author Sourabh
 *
 */
public class BestTimeToBuySellStock {

	/**
	 * LeetCode
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction (ie, buy one and sell 
	 * one share of the stock), design an algorithm to find the maximum profit.
	 * 
	 * Example:
	 * Input: [7, 1, 5, 3, 6, 4] Output: 5
	 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
	 * 
	 * Input: [7, 6, 4, 3, 1] Output: 0
	 * In this case, no transaction is done, i.e. max profit = 0.
	 */
	public int maxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
	}
	
	/**
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete as many transactions
	 * as you like (ie, buy one and sell one share of the stock multiple times). 
	 * However, you may not engage in multiple transactions at the same time 
	 * (ie, you must sell the stock before you buy again).
	 */
	public int maxMultiStockProfit(int[] prices) {
	    int total = 0;
	    for (int i=0; i< prices.length-1; i++) {
	        if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
	    }
	    return total;
	}
	
	
 	public static void main(String[] args) {
 		BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
 		
 		System.out.println("Max Single Stock Profit is " +obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
 		System.out.println("Max Single Stock Profit is " +obj.maxProfit(new int[]{7, 6, 4, 3, 1}));

 		System.out.println("Max Multi-Stock Profit is " +obj.maxMultiStockProfit(new int[]{7, 1, 5, 3, 6, 4}));

	}

}

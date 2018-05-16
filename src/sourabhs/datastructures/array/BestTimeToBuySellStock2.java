package sourabhs.datastructures.array;

public class BestTimeToBuySellStock2 {

	public static int maxProfit(int[] prices) {
		int total = 0;
		for(int i = 0; i < prices.length - 1; i++){
			if(prices[i+1] > prices[i]) total += prices[i+1] - prices[i];
		}
		return total;
	}

	public static void main(String[] args) {
		int[] prices = {7, 1, 6, 3, 4, 5};
		int res = maxProfit(prices);
		System.out.println(res);
	}
}

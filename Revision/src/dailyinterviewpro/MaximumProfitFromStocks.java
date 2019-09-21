package dailyinterviewpro;

/**
 * You are given an array. Each element represents the price of a stock on that
 * particular day. Calculate and return the maximum profit you can make from
 * buying and selling that stock only once.
 * 
 * For example: [9, 11, 8, 5, 7, 10]
 * 
 * Here, the optimal trade is to buy when the price is 5, and sell when it is
 * 10, so the return value should be 5 (profit = 10 - 5 = 5).
 * 
 * @author Sushil
 *
 */
public class MaximumProfitFromStocks {

	public static void main(String[] args) {

		System.out.println(buyAndSell(new int[] {9, 11, 8, 5, 7, 10}));
	}

	private static int buyAndSell(int[] prices) {
		
		int maxProfit=0;
		int minPrice=Integer.MAX_VALUE;
		
		for(int price : prices) {
			
			maxProfit=Math.max(maxProfit, price-minPrice);
			minPrice=Math.min(minPrice, price);
		}
		
		return maxProfit;
	}
}

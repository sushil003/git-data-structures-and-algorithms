package interviewcake;
import java.util.ArrayList;
import java.util.List;

public class AppleStock {

	public static void main(String[] args) {

		int maxProfit=getMaxProfit(new int[]{10, 7, 5, 8, 11, 9});
		System.out.println(maxProfit);
		System.out.println(computeMaxProfit(new int[]{10, 7, 5, 8, 11, 9}));
		
		int[] input = {12,11,13,9,12,8,14,13,15};
		
		System.out.println(buyAndSellStockTwice(input));
		//System.out.println(buyAndSellStockTwice1(input));
		
	}
	public static int getMaxProfit(int[] stockPrices) {
		
	
		if(stockPrices.length < 2) {
			throw new IllegalArgumentException("we need minimum 2 process");
		}
		
		//Initialize min price to first value in array.
		int minPrice=stockPrices[0];
		
		//initial max profit. 
		int maxProfit= stockPrices[1]-minPrice;
		 
		for(int i=1;i<stockPrices.length-1;i++) {
			
			int currentPrice=stockPrices[i];
			int potentialProfit=currentPrice-minPrice;
			maxProfit=Math.max(maxProfit, potentialProfit);
			minPrice =Math.min(minPrice, currentPrice);
		}
		
		return maxProfit;
	}
	
	public static int computeMaxProfit(int[] prices){
		int minPrice = Integer.MAX_VALUE , maxProfit = 0;
		for (int price : prices) {
		maxProfit = Math.max(maxProfit , price - minPrice);
		minPrice = Math.min(minPrice , price);
		}
		return maxProfit;
		}
	
	public static int buyAndSellStockTwice(int[] prices) {
 
		int maxProfitTotal = 0;
		
		int minPrice = Integer.MAX_VALUE;

		List<Integer> profitValues = new ArrayList<>();
		
		for(int i=0; i< prices.length ; ++i) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfitTotal = Math.max(maxProfitTotal, prices[i]-minPrice);
			profitValues.add(maxProfitTotal);
		}
		
		int maxPrice = Integer.MIN_VALUE;
		
		for(int i= prices.length -1; i > 0 ; --i ) {
			maxPrice = Math.max(maxPrice, prices[i]);
			maxProfitTotal=Math.max(maxProfitTotal, maxPrice-prices[i] + profitValues.get(i-1));
		}
		return maxProfitTotal;
	}
	

/*	public static int buyAndSellStockTwice(int[] prices) {
		int maxTotalProfit = 0;
		List<Integer> firstBuySellProfits = new ArrayList<>();
		int minPriceSoFar = Integer.MAX_VALUE ;
		// Forward phase. For each day, we record maximum profit if we
		// sell on that day.
		for (int i = 0; i < prices.length; ++i) {
		minPriceSoFar = Math.min(minPriceSoFar , prices[i]);
		maxTotalProfit = Math.max(maxTotalProfit , prices[i] - minPriceSoFar);
		firstBuySellProfits.add(maxTotalProfit);
		}
		// Backward phase. For each day, find the maximum profit if we make
		// the second buy on that day.
		int maxPriceSoFar = Integer.MIN_VALUE ;
		for (int i = prices.length - 1; i > 0; --i) {
			maxPriceSoFar = Math.max(maxPriceSoFar , prices[i]);
			maxTotalProfit =Math.max(maxTotalProfit , maxPriceSoFar - prices[i]+ firstBuySellProfits.get(i - 1));
			
			}
			return maxTotalProfit ;
	}*/
	
}

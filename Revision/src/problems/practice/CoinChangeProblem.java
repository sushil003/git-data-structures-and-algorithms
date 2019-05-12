package problems.practice;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=jgiZlGzXMBw
 * https://leetcode.com/problems/coin-change/solution/
 * https://www.interviewcake.com/question/java/coin?course=fc1&section=dynamic-programming-recursion
 * 
 * @author sushi
 *
 */

public class CoinChangeProblem {

	public static void main(String[] args) {

		int[] coins = { 1, 2, 5 };
		int amount = 11;
		System.out.println(coinChangeTopDown(coins, amount));
		System.out.println(coinChangeBottomUp(coins, amount));
	}

	/**
	 * Iterative approach
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChangeBottomUp(int[] coins, int amount) {

		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	/**
	 * Recursive approach.
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChangeTopDown(int[] coins, int amount) {

		if (amount < 1)
			return 0;
		return coinChangeTopDown(coins, amount, new int[amount]);
	}

	private static int coinChangeTopDown(int[] coins, int rem, int[] count) {

		if (rem < 0)
			return -1;
		if (rem == 0)
			return 0;
		if (count[rem - 1] != 0)
			return count[rem - 1];
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {

			int result = coinChangeTopDown(coins, rem - coin, count);
			if (result >= 0 && result < min) {
				min = 1 + result;
			}
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}
}

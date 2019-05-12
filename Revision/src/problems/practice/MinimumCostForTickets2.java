package problems.practice;

/**
 * 
 * @author sushi
 *
 */
public class MinimumCostForTickets2 {

	public static void main(String[] args) {

		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };
		System.out.println(mincostTickets(days, costs));
	}

	public static int mincostTickets(int[] days, int[] costs) {

		int[] dp = new int[days.length];

		dp[days.length - 1] = Math.min(costs[0], Math.min(costs[1], costs[2]));

		for (int i = days.length - 2; i >= 0; --i) {

			dp[i] = dp[i + 1] + costs[0];

			int min7 = costs[1];

			for (int j = i + 1; j < days.length; ++j) {

				if (days[i] + 7 - 1 < days[j]) {
					min7 += dp[j];
					break;
				}
			}

			dp[i] = Math.min(dp[i], min7);

			int min30 = costs[2];

			for (int j = i + 1; j < days.length; ++j) {

				if (days[i] + 30 - 1 < days[j]) {
					min30 += dp[j];
					break;
				}
			}

			dp[i] = Math.min(dp[i], min30);

		}

		return dp[0];
	}
}

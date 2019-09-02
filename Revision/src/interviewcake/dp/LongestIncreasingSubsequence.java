package interviewcake.dp;

/**
 * Input : arr[] = {3, 10, 2, 1, 20} Output : Length of LIS = 3 The longest
 * increasing subsequence is 3, 10, 20
 * 
 * Input : arr[] = {3, 2} Output : Length of LIS = 1 The longest increasing
 * subsequences are {3} and {2}
 * 
 * Input : arr[] = {50, 3, 10, 7, 40, 80} Output : Length of LIS = 4 The longest
 * increasing subsequence is {3, 7, 40, 80}
 * 
 * @author Sushil
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int arr[] = {3, 10, 2, 1, 20};
		System.out.println(lengthOfLIS(arr));
	}

	 public static int lengthOfLIS(int[] nums) {
	        if (nums.length == 0) {
	            return 0;
	        }
	        int[] dp = new int[nums.length];
	        dp[0] = 1;
	        int maxans = 1;
	        for (int i = 1; i < dp.length; i++) {
	            int maxval = 0;
	            for (int j = 0; j < i; j++) {
	                if (nums[i] > nums[j]) {
	                    maxval = Math.max(maxval, dp[j]);
	                }
	            }
	            dp[i] = maxval + 1;
	            maxans = Math.max(maxans, dp[i]);
	        }
	        return maxans;
	    }
}

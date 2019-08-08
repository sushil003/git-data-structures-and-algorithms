package problems.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You
 * may assume that the maximum length of s is 1000.
 * 
 * Example 1: Input:
 * 
 * "bbbab" Output: 4 One possible longest palindromic subsequence is "bbbb".
 * Example 2: Input:
 * 
 * "cbbd" Output: 2
 * 
 * @author Sushil
 *
 */
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {

		System.out.println(longestPalindromeSubseqRecursion("bbbab"));
		System.out.println(longestPalindromeSubseq("bbbab"));
	}
	
	 public static int longestPalindromeSubseq(String str) {
	        int[][] dp = new int[str.length()][str.length()];
	        for (int i = str.length() - 1; i >= 0; i--) {
	            dp[i][i] = 1;
	            for (int j = i + 1; j < str.length(); j++) {
	                if (str.charAt(i) == str.charAt(j)) {
	                    dp[i][j] = 2 + dp[i + 1][j - 1];
	                } else {
	                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
	                }
	            }
	        }
	        return dp[0][str.length() - 1];
	    }

	public static int longestPalindromeSubseqRecursion(String s) {

		return LPS(s, 0, s.length() - 1, new HashMap<String, Integer>());
	}

	private static int LPS(String s, int left, int right, Map<String, Integer> cache) {

		int result;

		String key = left + " " + right;

		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		if (left > right) {
			result = 0;
		} else

		if (left == right) {
			result = 1;
		} else

		if (s.charAt(left) == s.charAt(right)) {
			result = 2 + LPS(s, left + 1, right - 1, cache);
		} else {
			result = Math.max(LPS(s, left + 1, right, cache), LPS(s, left, right - 1, cache));
		}
		cache.put(key, result);
		return result;

	}
}

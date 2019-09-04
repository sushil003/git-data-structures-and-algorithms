package problems.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s , find the length of the longest substring t that contains
 * at most 2 distinct characters.
 * 
 * Example 1:
 * 
 * Input: "eceba" Output: 3 Explanation: t is "ece" which its length is 3.
 * Example 2:
 * 
 * Input: "ccaabbb" Output: 5 Explanation: t is "aabbb" which its length is 5.
 * 
 * @author Sushil
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {

		int n = s.length();

		if (n < 3) {
			return n;
		}
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int right = 0;

		int max = 2;

		while (right < n) {

			if (map.size() < 3) {
				map.put(s.charAt(right), right++);
			}

			if (map.size() == 3) {
				int left_id = Collections.min(map.values());
				map.remove(s.charAt(left_id));
				left = left_id + 1;
			}

			max = Math.max(max, right - left);

		}

		return max;
	}
}

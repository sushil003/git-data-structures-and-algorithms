package problems.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EPI
 * 
 * @author Sushil
 *
 */
public class LongestSubarrayWithDistinctValues {

	public static void main(String[] args) {

		System.out.println(longestSubarrayWithDistinctEntries(List.of(1, 2, 1, 3, 1, 2, 1)));
	}

	public static int longestSubarrayWithDistinctEntries(List<Integer> A) {

		Map<Integer, Integer> mostRecentValuesMap = new HashMap<Integer, Integer>();

		int longestSubArrayStartIndex = 0;
		int result = 0;

		for (int i = 0; i < A.size(); ++i) {

			Integer dupIdx = mostRecentValuesMap.put(A.get(i), i);

			if (dupIdx != null) {

				if (dupIdx >= longestSubArrayStartIndex) {
					result = Math.max(result, i - longestSubArrayStartIndex);
					longestSubArrayStartIndex = dupIdx + 1;
				}
			}
		}

		return Math.max(result, A.size() - longestSubArrayStartIndex);
	}

}

package problems.pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Merging 2 Packages Given a package with a weight limit limit and an array arr
 * of item weights, implement a function getIndicesOfItemWeights that finds two
 * items whose sum of weights equals the weight limit limit. Your function
 * should return a pair [i, j] of the indices of the item weights, ordered such
 * that i > j. If such a pair doesn’t exist, return an empty array.
 * 
 * Analyze the time and space complexities of your solution.
 * 
 * Example:
 * 
 * input: arr = [4, 6, 10, 15, 16], lim = 21
 * 
 * output: [3, 1] # since these are the indices of the # weights 6 and 15 whose
 * sum equals to 21 Constraints:
 * 
 * [time limit] 5000ms
 * 
 * [input] array.integer arr
 * 
 * 0 ≤ arr.length ≤ 100 [input] integer limit
 * 
 * [output] array.integer
 * 
 * 
 * @author sushi
 *
 */
public class Merging2Packages {

	static int[] getIndicesOfItemWeights(int[] arr, int limit) {
		// your code goes here

		if (arr == null || arr.length == 0) {
			int[] result = new int[0];

			return result;
		}

		Map<Integer, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			indexMap.put(limit - arr[i], i);
		}

		for (int i = 0; i < arr.length; i++) {

			if (indexMap.containsKey(arr[i])) {

				int[] result = new int[2];
				if (arr[i] > arr[indexMap.get(arr[i])]) {
					result[0] = i;
					result[1] = indexMap.get(arr[i]);
				} else {
					result[0] = indexMap.get(arr[i]);
					result[1] = i;
				}

				return result;

			}
		}
		return new int[0];
	}

	public static void main(String[] args) {

		/**
		 * Test Case #1 Input: [9], 9,Expected: [],Actual: [] Test Case #2 Input: [4,4],
		 * 8,Expected: [1,0],Actual: [1, 0] Test Case #3 Input: [4,4,1], 5,Expected:
		 * [2,1],Actual: [0, 2] Test Case #4 Input: [4,6,10,15,16], 21,Expected:
		 * [3,1],Actual: [3, 1] Test Case #5 Input: [4,6,10,15,16], 20,Expected:
		 * [4,0],Actual: [4, 0]
		 */
	}
}

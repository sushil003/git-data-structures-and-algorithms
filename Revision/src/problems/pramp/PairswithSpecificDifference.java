package problems.pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Pairs with Specific Difference Given an array arr of distinct integers and a
 * nonnegative integer k, write a function findPairsWithGivenDifference that
 * returns an array of all pairs [x,y] in arr, such that x - y = k. If no such
 * pairs exist, return an empty array.
 * 
 * Note: the order of the pairs in the output array should maintain the order of
 * the y element in the original array.
 * 
 * Examples:
 * 
 * input: arr = [0, -1, -2, 2, 1], k = 1 output: [[1, 0], [0, -1], [-1, -2], [2,
 * 1]]
 * 
 * input: arr = [1, 7, 5, 3, 32, 17, 12], k = 17 output: [] Constraints:
 * 
 * [time limit] 5000ms
 * 
 * [input] array.integer arr
 * 
 * 0 ≤ arr.length ≤ 100 [input]integer k
 * 
 * k ≥ 0 [output] array.array.integer
 * 
 * @author sushi
 *
 */
class PairswithSpecificDifference {

	static int[][] findPairsWithGivenDifference(int[] arr, int k) {

		Map<Integer, Integer> numMap = new HashMap<>();
		for (int temp : arr) {
			// x x-k
			numMap.put(temp - k, temp);
		}
		int j = 0;
		for (int i = 0; i < arr.length; i++) {

			if (numMap.containsKey(arr[i])) {
				j++;
			}
		}

		int[][] resultArr = new int[j][2];
		j = 0;
		for (int i = 0; i < arr.length; i++) {

			if (numMap.containsKey(arr[i])) {
				resultArr[j][0] = numMap.get(arr[i]);
				resultArr[j][1] = arr[i];
				j++;
				System.out.println(numMap.get(arr[i]) + "," + arr[i]);
			}
		}
		return resultArr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 11, 7 };
		int[][] res = findPairsWithGivenDifference(arr, 4);

	}

}

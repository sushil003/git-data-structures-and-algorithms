package problems.pramp;

import java.util.Arrays;

/**
 * 
 * Array Quadruplet Given an unsorted array of integers arr and a number s,
 * write a function findArrayQuadruplet that finds four numbers (quadruplet) in
 * arr that sum up to s. Your function should return an array of these numbers
 * in an ascending order. If such a quadruplet doesn’t exist, return an empty
 * array.
 * 
 * Note that there may be more than one quadruplet in arr whose sum is s. You’re
 * asked to return the first one you encounter (considering the results are
 * sorted).
 * 
 * Explain and code the most efficient solution possible, and analyze its time
 * and space complexities.
 * 
 * Example:
 * 
 * input: arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20
 * 
 * output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9) # whose sum is
 * 20. Notice that there # are two other quadruplets whose sum is 20: # (7, 9,
 * 1, 3) and (2, 4, 9, 5), but again you’re # asked to return the just one
 * quadruplet (in an # ascending order) Constraints:
 * 
 * [time limit] 5000ms
 * 
 * [input] array.integer arr
 * 
 * 1 ≤ arr.length ≤ 100 [input] integer s
 * 
 * [output] array.integer
 * 
 * 
 * @author sushi
 *
 */
public class ArrayQuadruplet {

	public static void main(String[] args) {

		/**
		 * Test Case #1 Input:[], 12 Expected: [] Actual: [] Test Case #2 Input:
		 * [4,4,4], 12,Expected: [],Actual: [] Test Case #3 Input: [4,4,4,2],
		 * 16,Expected: [],Actual: [] Test Case #4 Input: [4,4,4,4],16,Expected:
		 * [4,4,4,4],Actual: [4, 4, 4, 4] Test Case #5 Input:[2,7,4,0,9,5,1,3],
		 * 20,Expected: [0,4,7,9],Actual: [0, 4, 7, 9] Test Case #6 Input:
		 * [2,7,4,0,9,5,1,3], 120,Expected: [],Actual: [] Test Case #7
		 * Input:[1,2,3,4,5,9,19,12,12,19], 40,Expected: [4,5,12,19],Actual: [4, 5, 12,
		 * 19]
		 */

	}

	public static int[] findArrayQuadruplet(int[] arr, int s) {

		int[] emptyArray = {};
		int n = arr.length;
		if (arr == null || n < 4) {
			return emptyArray;
		}

		Arrays.sort(arr);

		for (int i = 0; i <= n - 4; i++) {
			for (int j = i + 1; j <= n - 3; j++) {
				int r = s - (arr[i] + arr[j]);
				int low = j + 1;
				int high = n - 1;
				while (low < high) {
					if (arr[low] + arr[high] < r) {
						low++;
					} else if (arr[low] + arr[high] > r) {
						high--;
					} else {
						int[] finalArr = new int[] { arr[i], arr[j], arr[low], arr[high] };
						return finalArr;
					}
				}
			}

		}
		return emptyArray;
	}

}

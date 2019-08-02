package interviewcamp.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, both -ve and +ve, find a contiguous subarray that
 * sums to 0. For example: [2,4,-2,1,-3,5,-3] --> [4,-2,1,-3]
 * 
 * @author Sushil
 *
 */
public class ContiguousSubarrayThatSumsToZero {

	public static void main(String[] args) {

		//System.out.println(Arrays.toString(zeroSumSubarray(new int[] { 2, 4, -2, 1, -3, 5, -3 })));
		
		System.out.println(Arrays.toString(xSumSubarray(new int[] { 2, 4, -2, 1, -3, 5, -3 },4)));
	}

	public static int[] zeroSumSubarray(int[] arr) {

		if (arr == null || arr.length == 0) {
			return new int[] { -1, -1 };
		}
		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sum == 0) {
				return new int[] { 0, i };
			} else if (sumMap.containsKey(sum)) {
				return new int[] { sumMap.get(sum) + 1, i };
			}

			sumMap.put(sum, i);
		}

		return new int[] { -1, -1 };
	}

	public static int[] xSumSubarray(int[] arr,int x) {

		if (arr == null || arr.length == 0) {
			return new int[] { -1, -1 };
		}
		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sum == x) {
				return new int[] { 0, i };
			} else if (sumMap.containsKey(x)) {
				return new int[] { sumMap.get(sum) + 1, i };
			}

			sumMap.put(sum, i);
		}

		return new int[] { -1, -1 };
	}
}

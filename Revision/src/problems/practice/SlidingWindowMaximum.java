package problems.practice;
/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
 * @author Sushil
 *
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		int n = nums.length;

		if (n * k == 0) {
			return new int[0];
		}

		if (k == 1) {
			return nums;
		}

		int[] left = new int[n];
		left[0] = nums[0];
		int[] right = new int[n];
		right[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {

			if (i % k == 0) {
				left[i] = nums[i];
			} else {
				left[i] = Math.max(left[i - 1], nums[i]);
			}

			int j = n - i - 1;
			if ((j + 1) % k == 0) {
				right[j] = nums[j];
			} else {
				right[j] = Math.max(right[j + 1], nums[j]);
			}
		}

		int[] output = new int[n - k + 1];
		for (int i = 0; i < n - k + 1; i++) {
			output[i] = Math.max(left[i + k - 1], right[i]);
		}

		return output;
	}
}

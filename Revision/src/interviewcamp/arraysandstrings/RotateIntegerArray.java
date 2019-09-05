package interviewcamp.arraysandstrings;

/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4] Explanation: rotate
 * 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4] Example 2:
 * 
 * Input: [-1,-100,3,99] and k = 2 Output: [3,99,-1,-100] Explanation: rotate 1
 * steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
 * [3,99,-1,-100]
 * 
 * @author Sushil
 *
 */
public class RotateIntegerArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Use the same trick used while reversing the words in sentence. Let n=7n=7 and
	 * k=3k=3.
	 * 
	 * Original List : 1 2 3 4 5 6 7 
	 * After reversing all numbers : 7 6 5 4 3 2 1
	 * After reversing first k numbers : 5 6 7 4 3 2 1 
	 * After revering last n-k
	 * numbers : 5 6 7 1 2 3 4 --> Result
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {

		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}

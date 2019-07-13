package problems.practice;

/**
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * Input: [1,2,3,4] Output: [24,12,8,6] Note: Please solve it without division
 * and in O(n).
 * 
 * Follow up: Could you solve it with constant space complexity? (The output
 * array does not count as extra space for the purpose of space complexity
 * analysis.)
 * 
 * @author Sushil
 *
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] productExceptSelf(int[] nums) {

		int[] ans = new int[nums.length];
		ans[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			ans[i] = nums[i - 1] * ans[i - 1];
		}

		int R = 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			ans[i] = ans[i] * R;
			R *= nums[i];
		}

		return ans;
	}
}

package problems.practice;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] Output: 3 Example 2:
 * 
 * Input: [2,2,1,1,1,2,2] Output: 2
 * 
 * @author Sushil
 *
 */
public class MajorityElement {

	public static void main(String[] args) {

		System.out.println(majorityElement(new int[] {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7 ,7, 7, 7, 7}));
		//                                            1  2  1  2  1  0  1  0  1  2  1  0  1  2  3  4
	}

	public static int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
			System.out.println(count);
		}

		return candidate;
	}
}

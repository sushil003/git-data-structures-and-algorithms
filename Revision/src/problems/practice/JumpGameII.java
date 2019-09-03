package problems.practice;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to
 * reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the
 * last index. Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 * @author Sushil
 *
 */
public class JumpGameII {

	public static void main(String[] args) {

		System.out.println(jump(new int[] {2,3,1,1,4}));
	}
	
	public static int jump(int[] nums) {
		int current = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (current == i) {
                count++;
                current = max;
            }
        }
        return count;
	}

	/*public static int jump(int[] A) {
		int currLong = 0, nextLong = 0, level = 0;
		for (int i = 0; i < A.length; i++) {
			if (i - 1 == currLong) {
				level++;
				currLong = nextLong;
			}
			nextLong = Math.max(nextLong, A[i] + i);
		}
		return level;
	} */
}

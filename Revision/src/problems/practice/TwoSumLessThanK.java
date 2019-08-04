package problems.practice;

import java.util.Arrays;

/**
 * Given an array A of integers and integer K, return the maximum S such that
 * there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist
 * satisfying this equation, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [34,23,1,24,75,33,54,8], K = 60 Output: 58 Explanation: We can use
 * 34 and 24 to sum 58 which is less than 60. Example 2:
 * 
 * Input: A = [10,20,30], K = 15 Output: -1 Explanation: In this case it's not
 * possible to get a pair sum less that 15.
 * 
 * @author Sushil
 *
 */
public class TwoSumLessThanK {

	public static void main(String[] args) {

		System.out.println(twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8},60));
	}

	public static int twoSumLessThanK(int[] A, int K) {

		int left = 0;
		int right = A.length - 1;
		int closeToK = -1;
		Arrays.sort(A);
		while (left < right) {
			int sum = A[left] + A[right];
			if (sum < K) {
				closeToK = Math.max(closeToK, sum);
				left++;
			} else {
				right--;
			}
		}
		return closeToK;
	}
}

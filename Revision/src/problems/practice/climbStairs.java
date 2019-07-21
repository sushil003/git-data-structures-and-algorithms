package problems.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1
 * step + 1 step 2. 2 steps Example 2:
 * 
 * Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1.
 * 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 * @author Sushil
 *
 */
public class climbStairs {

	private static Map<Integer, Integer> memo = new HashMap<>();

	public static void main(String[] args) {

		System.out.println(climbStairsIterative(2));

		System.out.println(climbStairsRecursive(2));
	}

	public static int climbStairsIterative(int n) {
		if (n == 1) {
			return 1;
		}
		int first = 0;
		int second = 1;
		int third=0;
		for (int i = 1; i <= n; i++) {
		    third = first + second;
			first = second;
			second = third;
		}
		return third;
	}

	public static int climbStairsRecursive(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		int result = climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
		memo.put(n, result);
		return result;

	}

}

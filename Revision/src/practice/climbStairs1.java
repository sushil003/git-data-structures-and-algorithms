package practice;

import java.util.HashMap;
import java.util.Map;

public class climbStairs1 {

	private static Map<Integer, Integer> memo = new HashMap<>();

	public static void main(String[] args) {

		System.out.println(climbStairsIterative(4));

		System.out.println(climbStairsRecursive(4));
	}

	public static int climbStairsIterative(int n) {
		if (n == 1) {
			return 1;
		}
		int first = 1;
		int second = 1;
		int third=2;
		int fourth=0;
		for (int i = 3; i <= n; i++) {
			fourth = first + second +third;
			first = second;
			second = third;
			third=fourth;
		}
		return fourth;
	}

	public static int climbStairsRecursive(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else if(n==2) {
			return 2;
		}else 
		if (memo.containsKey(n)) {
			return memo.get(n);
		} else {
		int result = climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2)+ climbStairsRecursive(n - 3);
		memo.put(n, result);
		return result;
		}

	}

}

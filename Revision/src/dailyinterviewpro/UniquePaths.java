package dailyinterviewpro;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there
 * are a total of 3 ways to reach the bottom-right corner: 1. Right -> Right ->
 * Down 2. Right -> Down -> Right 3. Down -> Right -> Right Example 2:
 * 
 * Input: m = 7, n = 3 Output: 28
 * 
 * @author Sushil
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * We can solve this problem mathematically using the "Combinations" formula:
	 * 
	 * Let x = number of moves to go from left side of grid to right side of grid
	 * Let y = number of moves to go from top of grid to bottom of grid (assuming no
	 * obstacles) (x + y)! -------- (x!)(y!) There are (x+y) moves total. Choose x
	 * of them to go right, (and the remaining y moves will pick themselves)
	 * Example: For a 3x3 maze, we get x = 2, y = 2. Our formula gives
	 * (2+2)!((2!)(2!)) = 6.
	 * 
	 * Efficient calculation Instead of calculating the above formula directly, we
	 * can cancel factors before calculating the product. For example:
	 * 
	 * (5 + 3)! 8*7*6*5*4*3*2*1 8*7*6 -------- = ------------------ = ----- (5!)(3!)
	 * (5*4*3*2*1)(3*2*1) 3*2*1
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {

		int smaller = m > n ? n - 1 : m - 1;
		int totalSteps = m + n - 2;
		long result = 1;

		for (int counter = 1; counter <= smaller; counter++) {

			result *= totalSteps--;
			result /= counter;
		}

		return (int) result;
	}
}

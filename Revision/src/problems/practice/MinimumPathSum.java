package problems.practice;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * @author sushi
 *
 */

public class MinimumPathSum {

	public static void main(String[] args) {

		int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		// Ans : 7
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {

		int m = grid.length - 1;
		int n = grid[0].length - 1;

		int[][] temp = new int[grid.length][grid[0].length];

		int sum = 0;
		for (int i = 0; i <= n; i++) {
			temp[0][i] = sum + grid[0][i];
			sum = temp[0][i];
		}

		sum = 0;
		for (int i = 0; i <= m; i++) {
			temp[i][0] = sum + grid[i][0];
			sum = temp[i][0];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				temp[i][j] = grid[i][j] + Math.min(temp[i - 1][j], temp[i][j - 1]);
			}
		}
		return temp[m][n];

	}
}

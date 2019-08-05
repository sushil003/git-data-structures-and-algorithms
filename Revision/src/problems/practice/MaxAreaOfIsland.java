package problems.practice;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * Example 1:
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0], [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0], [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0], [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0], [0,0,0,0,0,0,0,1,1,0,0,0,0]] Given the above
 * grid, return 6. Note the answer is not 11, because the island must be
 * connected 4-directionally. Example 2:
 * 
 * [[0,0,0,0,0,0,0,0]] Given the above grid, return 0. Note: The length of each
 * dimension in the given grid does not exceed 50.
 * 
 * @author Sushil
 *
 */
public class MaxAreaOfIsland {

	static int count = 0;

	public static void main(String[] args) {

		int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };

		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int maxArea = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (grid[i][j] == 0) {
					continue;
				}
				count = 0;
				dfs(i, j, grid);
				maxArea = Math.max(maxArea, count);
			}
		}
		return maxArea;
	}

	public static void dfs(int row, int col, int[][] grid) {

		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
			return;
		}
		count++;
		grid[row][col] = 0;

		dfs(row + 1, col, grid);

		dfs(row - 1, col, grid);

		dfs(row, col + 1, grid);

		dfs(row, col - 1, grid);

	}
}

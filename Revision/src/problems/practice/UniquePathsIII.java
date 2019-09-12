package problems.practice;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 * 
 * 1 represents the starting square. There is exactly one starting square. 2
 * represents the ending square. There is exactly one ending square. 0
 * represents empty squares we can walk over. -1 represents obstacles that we
 * cannot walk over. Return the number of 4-directional walks from the starting
 * square to the ending square, that walk over every non-obstacle square exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]] Output: 2 Explanation: We have the
 * following two paths: 1.
 * (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2) 2.
 * (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) Example 2:
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]] Output: 4 Explanation: We have the
 * following four paths: 1.
 * (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3) 2.
 * (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3) 3.
 * (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3) 4.
 * (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 * 
 * Input: [[0,1],[2,0]] Output: 0 Explanation: There is no path that walks over
 * every empty square exactly once. Note that the starting and ending square can
 * be anywhere in the grid.
 * 
 * @author Sushil
 *
 */
public class UniquePathsIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int res;

	private int[][] dirs = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

	public int uniquePathsIII(int[][] grid) {

		int totalSteps = 0;
		int sr = 0;
		int sc = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 0) {
					totalSteps++;
				}

				if (grid[i][j] == 1) {
					sr = i;
					sc = j;
				}
			}
		}

		int step = 0;

		dfs(grid, sr, sc, step, totalSteps);

		return res;

	}

	private void dfs(int[][] grid, int i, int j, int step, int totalSteps) {

		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];

			if (isValid(grid, x, y)) {
				int tmp = grid[x][y];
				if (tmp == 2 && step == totalSteps) {
					res++;
					return;
				}
				if (tmp == 0) {
					int val = grid[i][j];
					grid[i][j] = -1;
					dfs(grid, x, y, step + 1, totalSteps);
					grid[i][j] = val;
				}
			}
		}
	}

	private boolean isValid(int[][] grid, int i, int j) {
		return (i >= 0 && i < grid.length) && (j >= 0 && j < grid[0].length) && (grid[i][j] == 0 || grid[i][j] == 2);
	}
}

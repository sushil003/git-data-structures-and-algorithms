package problems.practice;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 * 
 * the value 0 representing an empty cell; the value 1 representing a fresh
 * orange; the value 2 representing a rotten orange. Every minute, any fresh
 * orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1 instead.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: [[2,1,1],[1,1,0],[0,1,1]] Output: 4 Example 2:
 * 
 * Input: [[2,1,1],[0,1,1],[1,0,1]] Output: -1 Explanation: The orange in the
 * bottom left corner (row 2, column 0) is never rotten, because rotting only
 * happens 4-directionally. Example 3:
 * 
 * Input: [[0,2]] Output: 0 Explanation: Since there are already no fresh
 * oranges at minute 0, the answer is just 0.
 * 
 * 
 * Note:
 * 
 * 1 <= grid.length <= 10 1 <= grid[0].length <= 10 grid[i][j] is only 0, 1, or
 * 2.
 * 
 * @author Sushil
 *
 */
public class RottingOranges {

	public static void main(String[] args) {

		int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
		
		System.out.println(orangesRotting(grid));
	}

	public static int orangesRotting(int[][] grid) {

		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		int R = grid.length;
		int C = grid[0].length;

		Queue<Integer> queue = new ArrayDeque<>();
		Map<Integer, Integer> depth = new HashMap<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 2) {
					int code = i * C + j;
					queue.add(code);
					depth.put(code, 0);
				}
			}
		}

		int ans = 0;

		while (!queue.isEmpty()) {

			int code = queue.remove();
			int r = code / C;
			int c = code % C;

			for (int[] dir : dirs) {

				int nr = r + dir[0];
				int nc = c + dir[1];

				if (nr >= 0 && nc >= 0 && nr < R && nc < C && grid[nr][nc] == 1) {
					grid[nr][nc] = 2;
					int ncode = nr * C + nc;
					queue.add(ncode);
					depth.put(ncode, depth.get(code) + 1);
					ans = depth.get(ncode);
				}

			}

		}

		for (int[] row : grid)
			for (int v : row)
				if (v == 1)
					return -1;

		return ans;

	}
}

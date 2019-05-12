package problems.pramp;

/**
 * https://leetcode.com/problems/number-of-islands/solution/
 * 
 * Island Count Given a 2D array binaryMatrix of 0s and 1s, implement a function
 * getNumberOfIslands that returns the number of islands of 1s in binaryMatrix.
 * 
 * An island is defined as a group of adjacent values that are all 1s. A cell in
 * binaryMatrix is considered adjacent to another cell if they are next to each
 * either on the same row or column. Note that two values of 1 are not part of
 * the same island if they’re sharing only a mutual “corner” (i.e. they are
 * diagonally neighbors).
 * 
 * Explain and code the most efficient solution possible and analyze its time
 * and space complexities.
 * 
 * Example:
 * 
 * input: binaryMatrix = [ [0, 1, 0, 1, 0], [0, 0, 1, 1, 1], [1, 0, 0, 1, 0],
 * [0, 1, 1, 0, 0], [1, 0, 1, 0, 1] ]
 * 
 * output: 6 # since this is the number of islands in binaryMatrix. # See all 6
 * islands color-coded below. alt
 * 
 * Constraints:
 * 
 * [time limit] 5000ms
 * 
 * [input] array.array.int binaryMatrix
 * 
 * 1 ≤ binaryMatrix.length ≤ 100 1 ≤ binaryMatrix[i].length ≤ 100 [output]
 * integer
 * 
 * @author sushi
 *
 */
public class IslandCount {

	public static void main(String[] args) {
		int[][] binaryMatrix = { { 1, 0, 1, 0 }, { 0, 1, 1, 1 }, { 0, 0, 1, 0 } };
		System.out.println(getNumberOfIslandsUsingDFS(binaryMatrix));
	}

	public static int getNumberOfIslandsUsingDFS(int[][] binaryMatrix) {
		if (binaryMatrix == null || binaryMatrix.length == 0) {
			return 0;
		}

		int islandCount = 0;
		int rowlength = binaryMatrix.length;
		int colLength = binaryMatrix[0].length;
		for (int i = 0; i < rowlength; ++i) {
			for (int j = 0; j < colLength; ++j) {
				if (binaryMatrix[i][j] == 1) {
					++islandCount;
					dfs(binaryMatrix, i, j);
				}
			}
		}
		return islandCount;
	}

	public static void dfs(int[][] binaryMatrix, int i, int j) {

		int row = binaryMatrix.length;
		int col = binaryMatrix[0].length;
		if (i < 0 || j < 0 || i >= row || j >= col || binaryMatrix[i][j] == 0) {
			return;
		}
		binaryMatrix[i][j] = 0;
		dfs(binaryMatrix, i - 1, j);
		dfs(binaryMatrix, i + 1, j);
		dfs(binaryMatrix, i, j - 1);
		dfs(binaryMatrix, i, j + 1);

	}
}

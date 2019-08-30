package interviewcamp.recursionandbacktracking;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 2D array that represents a maze. 
 * It can have 2 values - 0 and 1. 
 * 1 represents awall in the maze and 0 represents a path. 
 * The objective of the maze is to reach the bottom rightcorner, 
 * or A[A.length-1][A.length-1]. 
 * You start from A[0][0] and can only go right or down. 
 * Find if a path exists to the bottom right of the maze from A[0][0].
 * For e.g, 2 paths exist in the following maze:0 1 1 10 0 0 11 0 0 01 1 1 
 * 
 * 
 * boolean pathExists(a, i, j)     
 * if i,j is out of bounds or wall         
 * return false     
 * if i,j is end of maze         
 * return true     
 * check right, r
 * eturn true 
 * if path exists     
 * check down, return true if path exists
 * 
 * @author Sushil
 *
 */
public class MazeProblemWithRightAndDownMoveAllowed {

	public static void main(String[] args) {

		Map<Integer[], Boolean> map = new HashMap<>();
		
		int[][] a ={ {0,0,0,0,0},
			        {0,1,1,1,1},
			        {0,0,0,0,0},
			        {0,1,1,1,1},
			        {0,0,0,0,0}};
		
		System.out.println(pathExistsWithMemo(a,0,0,map));
		
	}
	
	public static boolean pathExistsWithMemo(int[][] a, int i, int j,Map<Integer[], Boolean> map) {

		if (boundCheck(a, i, j) || a[i][j] == 1) {
			return false;
		}

		if (i == a.length - 1 && j == a[0].length - 1) {
			return true;
		}

		Integer[] ij= {i,j};
		
		if(map.containsKey(ij)) {
			return map.get(ij);
		}
		
		if (pathExistsWithMemo(a, i + 1, j,map) || pathExistsWithMemo(a, i, j + 1,map)) {
			
			map.put(ij, true);

			return true;
		}
		
		map.put(ij, false);


		return false;
	}

	public static boolean pathExists(int[][] a, int i, int j) {

		if (boundCheck(a, i, j) || a[i][j] == 1) {
			return false;
		}

		if (i == a.length - 1 && j == a[0].length - 1) {
			return true;
		}

		if (pathExists(a, i + 1, j) || pathExists(a, i, j + 1)) {
			return true;
		}

		return false;
	}

	private static boolean boundCheck(int[][] a, int i, int j) {
		return i < 0 || i > a.length - 1 || j < 0 || j > a[0].length - 1;
	}

}

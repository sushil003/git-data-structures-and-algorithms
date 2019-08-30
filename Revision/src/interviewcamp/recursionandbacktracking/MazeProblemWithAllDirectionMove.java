package interviewcamp.recursionandbacktracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Sushil
 *
 */
public class MazeProblemWithAllDirectionMove {

	public static void main(String[] args) {

		Map<Integer[], Boolean> map = new HashMap<>();
		Set<Integer[]> pathSofar = new HashSet<>();
		
		int[][] a ={ {0,0,0,0,0},
			         {0,1,1,1,1},
			         {0,0,0,0,0},
			         {0,1,1,1,1},
			         {0,0,0,0,0}};
		
	//	System.out.println(pathExistsWithMemo(a,0,0,map,pathSofar));
		int[] start = {0,0};
		int[] destination = {a.length-1,a[0].length-1};
		System.out.println(pathExistsWithMemoBFS(a,start,destination));
		
	}
	
	public static boolean pathExistsWithMemoBFS(int[][] a,int[] start,int[] destination) {
		 boolean[][] visited = new boolean[a.length][a[0].length];
	        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	        Queue < int[] > queue = new LinkedList < > ();
	        queue.add(start);
	        visited[start[0]][start[1]] = true;
	        while (!queue.isEmpty()) {
	            int[] s = queue.remove();
	            if (s[0] == destination[0] && s[1] == destination[1]) {
	            	return true;
	            }
	            for (int[] dir: dirs) {
	                int x = s[0] + dir[0];
	                int y = s[1] + dir[1];
	                while (x >= 0 && y >= 0 && x < a.length && y < a[0].length && a[x][y] == 0) {
	                    x += dir[0];
	                    y += dir[1];
	                }
	                if (!visited[x - dir[0]][y - dir[1]]) {
	                    queue.add(new int[] {x - dir[0], y - dir[1]});
	                    visited[x - dir[0]][y - dir[1]] = true;
	                }
	            }
	        }
	        return false;
	}

	
	public static boolean pathExistsWithMemo(int[][] a, int i, int j,Map<Integer[], Boolean> map,Set<Integer[]> pathSofar) {

		Integer[] ij= {i,j};
		
		if (boundCheck(a, i, j) || a[i][j] == 1 || pathSofar.contains(ij)) {
			return false;
		}

		if (i == a.length - 1 && j == a[0].length - 1) {
			System.out.println(Arrays.toString(ij));
			return true;
		}

		
		if(map.containsKey(ij)) {
			return map.get(ij);
		}
		
		if (pathExistsWithMemo(a, i + 1, j, map, pathSofar) || pathExistsWithMemo(a, i, j + 1, map, pathSofar)
				|| pathExistsWithMemo(a, i, j - 1, map, pathSofar) || pathExistsWithMemo(a, i - 1, j, map, pathSofar)) {

			map.put(ij, true);
			System.out.println(Arrays.toString(ij));
			return true;
		}
		
		map.put(ij, false);
		pathSofar.remove(ij);

		return false;
	}

	private static boolean boundCheck(int[][] a, int i, int j) {
		return i < 0 || i >= a.length || j < 0 || j >= a[0].length;
	}

}

package problems.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a 2D array where all rows are sorted, write a program to sort the array.

Example 1:

Input:
[[ 5, 12, 17, 21, 23],
 [ 1,  2,  4,  6,  8],
 [12, 14, 18, 19, 27],
 [ 3,  7,  9, 15, 25]]

Output:
[[ 1,  2,  3,  4,  5],
 [ 6,  7,  8,  9, 12],
 [12, 14, 15, 17, 18],
 [19, 21, 23, 25, 27]]
 
Follow-up: Can you do it in-place?

 * @author Sushil
 *
 */
public class SortA2DArray {

	public static void main(String[] args) {
		
		SortA2DArray a2dArray=new SortA2DArray();

		int[][] grid1 = { { 5, 12, 17, 21, 23 }, { 1, 2, 4, 6, 8 }, { 12, 14, 18, 19, 27 }, { 3, 7, 9, 15, 25 } };
		a2dArray.sort(grid1);
		for (int[] row : grid1)
			System.out.println(Arrays.toString(row));
		System.out.println("------------------------------");
		int[][] grid2 = { { 1, 2, 3, 21, 23 }, { 4, 5, 6, 8, 12, }, { 12, 14, 18, 19, 27 }, { 7, 9, 15, 17, 25 } };
		a2dArray.sort(grid2);
		for (int[] row : grid2)
			System.out.println(Arrays.toString(row));

	}

	 private  void sort(int[][] mat){
	        PriorityQueue<ValueAndPos> pq = new PriorityQueue<ValueAndPos>((x, y) -> x.v.compareTo(y.v));
	        Map<Integer, Integer> map = new HashMap<>(); // map to track till which col we have have put values into heap, for a row.
	        for (int i = 0; i < mat.length; i++) {
	            pq.offer(new ValueAndPos(mat[i][0], i, 0));
	            map.put(i, 0);
	        }
	        for (int i = 0; i < mat.length; i++) {
	            for (int j = 0; j < mat[i].length; j++) {
	                ValueAndPos vpos = pq.poll();
	                if (map.get(i) < j){
	                    //before writing to mat matrix, we need to ensure that the value at mat[i,j] is put in pq
	                    pq.offer(new ValueAndPos(mat[i][j], i, j));
	                    map.put(i, j);
	                }
	                mat[i][j] = vpos.v;
	                if (vpos.c < mat[vpos.r].length-1 && map.get(vpos.r) < vpos.c+1){
	                    pq.offer(new ValueAndPos(mat[vpos.r][vpos.c+1], vpos.r, vpos.c+1));
	                    map.put(vpos.r, vpos.c+1);
	                }
	            }
	        }
	    }

	    private class ValueAndPos {
	        Integer v;
	        Integer r;
	        Integer c;

	        public ValueAndPos(int value, int row, int col) {
	            this.v = value;
	            this.r = row;
	            this.c = col;
	        }
	    }
}

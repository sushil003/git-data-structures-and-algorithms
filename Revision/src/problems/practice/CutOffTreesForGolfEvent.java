package problems.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are asked to cut off trees in a forest for a golf event. The forest is
 * represented as a non-negative 2D map, in this map:
 * 
 * 0 represents the obstacle can't be reached. 1 represents the ground can be
 * walked through. The place with number bigger than 1 represents a tree can be
 * walked through, and this positive number represents the tree's height.
 * 
 * 
 * You are asked to cut off all the trees in this forest in the order of tree's
 * height - always cut off the tree with lowest height first. And after cutting,
 * the original place has the tree will become a grass (value 1).
 * 
 * You will start from the point (0, 0) and you should output the minimum steps
 * you need to walk to cut off all the trees. If you can't cut off all the
 * trees, output -1 in that situation.
 * 
 * You are guaranteed that no two trees have the same height and there is at
 * least one tree needs to be cut off.
 * 
 * Example 1:
 * 
 * Input: [ [1,2,3], [0,0,4], [7,6,5] ] Output: 6
 * 
 * 
 * Example 2:
 * 
 * Input: [ [1,2,3], [0,0,0], [7,6,5] ] Output: -1
 * 
 * 
 * Example 3:
 * 
 * Input: [ [2,3,4], [0,0,5], [8,7,6] ] Output: 6 Explanation: You started from
 * the point (0,0) and you can cut off the tree in (0,0) directly without
 * walking.
 * 
 * @author Sushil
 *
 */
public class CutOffTreesForGolfEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	    
	    public int cutOffTree(List<List<Integer>> forest) {
	        
	        if(forest == null || forest.size()==0){
	            return 0;
	        }
	        
	        int m = forest.size();
	        int n = forest.get(0).size();
	        
	        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(a[2]-b[2]));
	        
	        for(int i=0; i<m;i++){
	            for(int j=0; j<n;j++){
	               if(forest.get(i).get(j) > 1){
	                    queue.add(new int[]{i,j,forest.get(i).get(j)});
	               }
	            }
	        }
	        
	        int[] start = new int[2];
	        int sum=0;
	        while(!queue.isEmpty()){
	            
	            int[] tree = queue.poll();
	            
	            int step = minStep(forest,start,tree,m,n);
	            
	            if(step < 0){
	                return -1;
	            }
	            
	            sum+=step;
	            
	            start[0]=tree[0];
	            start[1] = tree[1];
	            
	        }
	        
	        return sum;
	        
	    }
	    
	    private int minStep(List<List<Integer>> forest,int[] start,int[] tree,int m,int n){
	        
	        int step=0;
	        Queue<int[]> queue = new LinkedList<>();
	        boolean[][] visited = new boolean[m][n];
	        
	        queue.add(start);
	        visited[start[0]][start[1]] = true;
	        
	        while(!queue.isEmpty()){
	            
	            int size = queue.size();
	            
	            for(int i=0; i< size;i++){
	                
	                int[] curr = queue.poll();
	                
	                if(curr[0]==tree[0] && curr[1]==tree[1]){
	                    return step;
	                }
	                
	                for(int[] dir : dirs){
	                    
	                    int x = curr[0]+dir[0];
	                    int y = curr[1]+dir[1];
	                    
	                    if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || forest.get(x).get(y) ==0 ){
	                        continue;
	                    }
	                    
	                    queue.add(new int[]{x,y});
	                    visited[x][y] =true;
	                }
	                
	            }
	            
	            step++;
	            
	        }
	        
	        return -1;
	    }
}

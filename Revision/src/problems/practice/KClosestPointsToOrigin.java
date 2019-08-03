package problems.practice;

import java.util.PriorityQueue;

/**
 * We have a list of points on the plane. Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]] Explanation: The
 * distance between (1, 3) and the origin is sqrt(10). The distance between (-2,
 * 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to
 * the origin. We only want the closest K = 1 points from the origin, so the
 * answer is just [[-2,2]]. Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2 Output: [[3,3],[-2,4]] (The
 * answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * @author Sushil
 *
 */
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 private static class Item{
	        int x;
	        int y;
	        int dist;
	      public Item(int x, int y){
	            this.x=x;
	            this.y=y;
	            this.dist=x*x+y*y;
	        }            
	    }
	    
	    public int[][] kClosest(int[][] points, int K) {
	    	
	    PriorityQueue<Item> queue = new PriorityQueue<>((i1,i2)-> i1.dist < i2.dist ? 1 : i1.dist > i2.dist ? -1 : 0);
	    
	    int noOfPoint = points.length;
	    
	    for(int i=0; i< noOfPoint ; i++) {
	    	queue.add(new Item(points[i][0], points[i][1]));
	    	if(queue.size() >K) {
	    		queue.poll();
	    	}
	    }
	        
	      int[][] kClosest = new int[K][2];
	      int t=0;
	      while(!queue.isEmpty()) {
	    	  Item kItem = queue.poll();
	    	  kClosest[t][0] =  kItem.x;
	    	  kClosest[t][1] =  kItem.y;
           t++;
	      }
	      
	      return kClosest;
	    }
}

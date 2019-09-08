package problems.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * Input: [[0, 30],[5, 10],[15, 20]] Output: 2 Example 2:
 * 
 * Input: [[7,10],[2,4]] Output: 1 NOTE: input types have been changed on April
 * 15, 2019. Please reset to default code definition to get new method
 * signature.
 * 
 * @author Sushil
 *
 */
public class MeetingRoomsII {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static void main(String[] args) {

	}

	 public int minMeetingRooms(int[][] intervals) {
	        
	        if(intervals.length==0){
	            return 0;
	        }
	        
	        Interval[] int1 = new Interval[intervals.length];
	        
	        for(int i=0; i<intervals.length;i++){
	           int1[i] = new Interval(intervals[i][0],intervals[i][1]);
	        }
	        
	        PriorityQueue<Integer> queue = new  PriorityQueue<>();
	        
	        Arrays.sort(int1,(o1,o2)->o1.start-o2.start);
	        
	        queue.offer(int1[0].end);
	        
	        for(int i=1; i<int1.length;i++){
	            
	            if(int1[i].start >= queue.peek()){
	                queue.poll();
	            }
	            
	            queue.add(int1[i].end);
	        }
	        
	        return queue.size();
	    }
}

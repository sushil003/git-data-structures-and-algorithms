package dailyinterviewpro;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given an array of tuples (start, end) representing time intervals for lectures. The intervals may be overlapping. Return the number of rooms that are required.

For example. [(30, 75), (0, 50), (60, 150)] should return 2.
 * @author Sushil
 *
 */
public class RoomScheduling {

	public static void main(String[] args) {

		RoomScheduling roomScheduling = new RoomScheduling();
		
		System.out.println(roomScheduling.minMeetingRooms(new int[][] {{30, 75}, {0, 50}, {60, 150}}));
		
	}
	
class Interval {
        
        int start;
        int end;
        Interval(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals== null || intervals.length==0){
            
            return 0;
        }
        
        Interval[] int1 = new Interval[intervals.length];
        
        for(int i=0; i<intervals.length ; i++){
            
            int1[i] = new Interval(intervals[i][0],intervals[i][1]);
        }
        
        Arrays.sort(int1,(o1,o2) -> o1.start - o2.start);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        queue.add(int1[0].end);
        
        for(int i=1 ; i<int1.length ; i++){
            if(int1[i].start >=queue.peek()){
                queue.poll();
            }
             queue.add(int1[i].end);
        }
        
        return  queue.size();
        
    }

}

package dailyinterviewpro;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 * @author Sushil
 *
 */
public class RunningMedian {

	static PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> large = new PriorityQueue<>();
	static boolean even = true;

	public static void main(String[] args) {

		System.out.println(Arrays.toString(calculateRunningMedian(new int[] {2, 1, 4, 7, 2, 0, 5})));
	}
	
	public static double[] calculateRunningMedian(int[] a ) {
		
		double[] result = new double[a.length];
		
		for(int i=0; i<a.length;i++) {
			addNum(a[i]);
			result[i]=findMedian();
		}
		
		return result;
	}

	public static double findMedian() {

		if (even) {
			return (small.peek() + large.peek()) / 2.0;
		} else {
			return small.peek();
		}
	}

	public static void addNum(int num) {

		if (even) {
			large.offer(num);
			small.offer(large.poll());
		} else {
			small.offer(num);
			large.offer(small.poll());
		}
		even = !even;
	}

}

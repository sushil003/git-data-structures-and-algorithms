package problems.practice;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 * @author Sushil
 *
 */
public class FindMedianFromDataStream {
	
	// private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> small = new PriorityQueue<>((o1,o2)->o2-o1);
	private PriorityQueue<Integer> large = new PriorityQueue<>();
	private boolean even = true;

	public static void main(String[] args) {

		FindMedianFromDataStream dataStream = new FindMedianFromDataStream();
		dataStream.addNum(1);
		dataStream.addNum(2);
		System.out.println(dataStream.findMedian());
		dataStream.addNum(3);
		System.out.println(dataStream.findMedian());
	}
	public double findMedian() {
	    if (even)
	        return (small.peek() + large.peek()) / 2.0;
	    else
	        return small.peek();
	}

	public void addNum(int num) {
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

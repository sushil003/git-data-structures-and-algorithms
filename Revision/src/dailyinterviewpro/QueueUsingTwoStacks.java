package dailyinterviewpro;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Implement a queue class using two stacks. A queue is a data structure that
 * supports the FIFO protocol (First in = first out). Your class should support
 * the enqueue and dequeue methods like a standard queue.
 * 
 * @author Sushil
 *
 */
public class QueueUsingTwoStacks {
	
	Deque<Integer> enqueueDeque = new ArrayDeque<>();
	
	Deque<Integer> dequeueDeque = new ArrayDeque<>();

	public static void main(String[] args) {

		
	}
	
	public void enqueue(Integer x) {
		
		enqueueDeque.addFirst(x);
	}
	
	public Integer dequeue() {
		
		if(dequeueDeque.isEmpty()) {
			
			while(!enqueueDeque.isEmpty()) {
				dequeueDeque.addFirst(enqueueDeque.removeFirst());
			}
		}
		
		if(!dequeueDeque.isEmpty()) {
			return dequeueDeque.removeFirst();
		}
		
		 throw new NoSuchElementException("Cannot pop empty queue");
	}

}

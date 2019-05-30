package problems.practice;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Queue with Max API
 * 
 * @author sushi
 *
 */
public class QueueWithMaxIntro {

	private Deque<Integer> data = new LinkedList<>();

	public void enqueue(Integer item) {
		data.add(item);
	}

	public Integer dequeue() {
		return data.removeFirst();
	}

	public Integer max() {

		if (data != null) {
			return Collections.max(data);
		}

		throw new IllegalStateException("Cannot perform max() on empty queue.");
	}
}

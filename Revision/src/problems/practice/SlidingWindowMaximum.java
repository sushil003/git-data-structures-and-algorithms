package problems.practice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
 * @author Sushil
 *
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {

		
	}
	
	  // Monotonically Decreasing Queue O(n), O(n)
    public int[] maxSlidingWindowUsingMonotonicallyDecreasingQueue(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        
        MonoDecreasingQueue monoDecreasingQueue = new MonoDecreasingQueue();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            monoDecreasingQueue.offer(nums[i]);
            if (i >= k - 1) {
                result[resultIndex++] = monoDecreasingQueue.peek();
                if (monoDecreasingQueue.peek() == nums[i - k + 1]) {
                    monoDecreasingQueue.poll();
                }
            }
        }
        
        return result;
    }

    class MonoDecreasingQueue {
    
    private Deque<Integer> queue;
    
    public MonoDecreasingQueue() {
        queue = new ArrayDeque<>();
    }
        
    public void offer(int data) {
        while (!queue.isEmpty() && queue.peekLast() < data) {
            queue.pollLast();
        }
        queue.offerLast(data);
    }
    
    public void poll() {
        queue.pollFirst();
    }
    
    public Integer peek() {
        return queue.peekFirst();
    } 
} 

	public int[] maxSlidingWindow(int[] nums, int k) {

		int n = nums.length;

		if (n * k == 0) {
			return new int[0];
		}

		if (k == 1) {
			return nums;
		}

		int[] left = new int[n];
		left[0] = nums[0];
		int[] right = new int[n];
		right[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {

			if (i % k == 0) {
				left[i] = nums[i];
			} else {
				left[i] = Math.max(left[i - 1], nums[i]);
			}

			int j = n - i - 1;
			if ((j + 1) % k == 0) {
				right[j] = nums[j];
			} else {
				right[j] = Math.max(right[j + 1], nums[j]);
			}
		}

		int[] output = new int[n - k + 1];
		for (int i = 0; i < n - k + 1; i++) {
			output[i] = Math.max(left[i + k - 1], right[i]);
		}

		return output;
	}
}

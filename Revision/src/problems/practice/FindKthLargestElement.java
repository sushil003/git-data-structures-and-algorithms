package problems.practice;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2 Output: 5 Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
 * 
 * @author Sushil
 *
 */
public class FindKthLargestElement {
	
	int[] nums;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findKthLargestUsingHeap(int[] nums, int k) {
	       
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int temp : nums){
            queue.add(temp);
            if(queue.size() > k){
                queue.remove();
            }
        }
        
        return   queue.remove();
    }
	
	public int findKthLargest(int[] nums, int k) {
		this.nums = nums;
		int size = nums.length;
		// kth largest is (N - k)th smallest
		return quickSelect(0, size - 1, size - k);

	}

	public int quickSelect(int left, int right, int k_smallest) {

		if (left == right) {
			return this.nums[left];
		}

		Random random_num = new Random();
		int pivot_index = left + random_num.nextInt(right - left);
		pivot_index = partition(left, right, pivot_index);

		if (k_smallest == pivot_index) {
			return this.nums[k_smallest];
		} else if (k_smallest < pivot_index) {
			return quickSelect(left, pivot_index - 1, k_smallest);
		}
		return quickSelect(pivot_index + 1, right, k_smallest);
	}

	public int partition(int left, int right, int pivot_index) {

		int pivot = this.nums[pivot_index];
		swap(pivot_index, right);
		int store_index = left;

		for (int i = left; i < right; i++) {
			if (this.nums[i] < pivot) {
				swap(store_index, i);
				store_index++;
			}
		}

		swap(store_index, right);

		return store_index;
	}

	public void swap(int a, int b) {
		int temp = this.nums[a];
		this.nums[a] = this.nums[b];
		this.nums[b] = temp;
	}
}

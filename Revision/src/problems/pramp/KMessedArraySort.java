package problems.pramp;

import java.util.PriorityQueue;

/**
 * K-Messed Array Sort Given an array of integers arr where each element is at
 * most k places away from its sorted position, code an efficient function
 * sortKMessedArray that sorts arr. For instance, for an input array of size 10
 * and k = 2, an element belonging to index 6 in the sorted array will be
 * located at either index 4, 5, 6, 7 or 8 in the input array.
 * 
 * Analyze the time and space complexities of your solution.
 * 
 * Example:
 * 
 * input: arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
 * 
 * output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] Constraints:
 * 
 * [time limit] 5000ms
 * 
 * [input] array.integer arr
 * 
 * 1 ≤ arr.length ≤ 100 [input] integer k
 * 
 * 1 ≤ k ≤ 20 [output] array.integer
 * 
 * @author sushi
 *
 */
public class KMessedArraySort {

	// Insertion Sort O(N * K)
	public static int[] insertionSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}

		for (int i = 1; i < arr.length; i++) {
			int x = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > x) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = x;
		}

		return arr;
	}

	// Min Heap: O(N * log(K))
	public static int[] sortKMessedArray(int[] arr, int k) {
		int n = arr.length;

		// create an empty min-heap
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		// build the min-heap from the first k+1 elements of arr
		for (int i = 0; i <= k; i++) {
			priorityQueue.add(arr[i]); // insert an element into priority queue is O(logK)
		}

		// extract the top element from the min-heap and assign it to the next available
		// array index, push the next array element into the min-heap
		for (int i = k + 1; i < arr.length; i++) {
			arr[i - (k + 1)] = priorityQueue.poll(); // remove an element from priority queue is O(logK)
			priorityQueue.add(arr[i]);
		}

		// extract all remaining elements from the min-heap and assign them to the next
		// available array index
		for (int i = 0; i <= k; i++) {
			arr[n - k - 1 + i] = priorityQueue.poll();
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9 };
		int k = 2;

		// insertion sort
		int[] arr_new1 = insertionSort(arr);

		for (int a : arr_new1) {
			System.out.println(a);
		}

		// min heap
		int[] arr_new2 = sortKMessedArray(arr, k);

		for (int a : arr_new2) {
			System.out.println(a);
		}
	}

}

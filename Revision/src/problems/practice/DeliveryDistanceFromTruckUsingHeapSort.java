package problems.practice;

import java.util.Arrays;

/**
 * 
 * @author sushi
 *
 */
public class DeliveryDistanceFromTruckUsingHeapSort {

	public static void main(String[] args) {

		int[][] alllocations = { { 1, 2 }, { 3, 4 }, { 1, -1 } };
		int numDeliveries = 2;
		sortArrayAsPerDistance(alllocations, numDeliveries);
		for (int i = 0; i < numDeliveries; i++) {
			System.out.println(Arrays.toString(alllocations[i]));
		}
	}

	public static void sortArrayAsPerDistance(int[][] alllocations, int numDeliveries) {

		int n = alllocations.length;

		// Build heap.
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(alllocations, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			int[] swap = alllocations[0];
			alllocations[0] = alllocations[i];
			alllocations[i] = swap;
			heapify(alllocations, i, 0);

		}
	}

	private static void heapify(int[][] alllocations, int n, int i) {

		int largest = i;

		int left = 2 * i + 1;
		int right = 2 * i + 2;

		Double distanceAtI = Math.sqrt((Math.pow(alllocations[i][0], 2)) + (Math.pow(alllocations[i][1], 2)));
		Double largestDistance = distanceAtI;

		Double leftDistance = Math.sqrt((Math.pow(alllocations[left][0], 2)) + (Math.pow(alllocations[left][1], 2)));
		Double rightDistance = Math.sqrt((Math.pow(alllocations[right][0], 2)) + (Math.pow(alllocations[right][1], 2)));

		if (left < n && leftDistance < largestDistance) {
			largestDistance = leftDistance;
		}
		if (right < n && rightDistance < largestDistance) {
			largestDistance = rightDistance;
		}

		if (largestDistance != distanceAtI) {

			int[] swap = alllocations[i];
			alllocations[i] = alllocations[largest];
			alllocations[largest] = swap;
			heapify(alllocations, n, largest);
		}
	}

}

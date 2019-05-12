package problems.practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author sushi
 *
 */
public class DeliveryDistanceFromTruckUsingComparator {

	public static void main(String[] args) {

		int[][] alllocations = { { 1, 2 }, { 3, 4 }, { 1, -1 } };
		int numDeliveries = 2;
		Arrays.sort(alllocations, new Comparator<int[]>() {
			@Override
			public int compare(int[] firstLocation, int[] secondLocation) {
				Double firstLocationDistance = Math
						.sqrt((Math.pow(firstLocation[0], 2)) + (Math.pow(firstLocation[1], 2)));
				Double secondLocationDistance = Math
						.sqrt((Math.pow(secondLocation[0], 2)) + (Math.pow(secondLocation[1], 2)));
				return Double.compare(firstLocationDistance, secondLocationDistance);
			}
		});
		for (int i = 0; i < numDeliveries; i++) {
			System.out.println(Arrays.toString(alllocations[i]));
		}
	}
}

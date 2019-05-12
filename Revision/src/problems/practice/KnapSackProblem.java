package problems.practice;

/**
 * 
 * @author sushi
 *
 */
public class KnapSackProblem {

	public static void main(String[] args) {

		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(KnapSackRecursive(W, wt, val, n));
		System.out.println(KnapSackBottomUp(W, wt, val, n));
	}

	public static int KnapSackRecursive(int weightCapacity, int[] weights, int[] values, int noOfItems) {

		if (weightCapacity == 0 || noOfItems == 0) {
			return 0;
		}

		if (weights[noOfItems - 1] > weightCapacity) {
			return KnapSackRecursive(weightCapacity, weights, values, noOfItems - 1);
		} else {

			return Math.max(values[noOfItems - 1]
					+ KnapSackRecursive(weightCapacity - weights[noOfItems - 1], weights, values, noOfItems - 1),
					KnapSackRecursive(weightCapacity, weights, values, noOfItems - 1));

		}
	}

	public static int KnapSackBottomUp(int weightCapacity, int weights[], int values[], int noOfItems) {

		int K[][] = new int[noOfItems + 1][weightCapacity + 1];

		for (int row = 0; row <= noOfItems; row++) {
			for (int col = 0; col <= weightCapacity; col++) {
				if (row == 0 || col == 0)
					K[row][col] = 0;
				else if (weights[row - 1] <= col)
					K[row][col] = Math.max(values[row - 1] + K[row - 1][col - weights[row - 1]], K[row - 1][col]);
				else
					K[row][col] = K[row - 1][col];
			}
		}

		return K[noOfItems][weightCapacity];
	}
}
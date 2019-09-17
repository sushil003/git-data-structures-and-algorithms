package problems.practice;

/**
 * There are n people lined up, and each have a height represented as an
 * integer. A murder has happened right in front of them, and only people who
 * are taller than everyone in front of them are able to see what has happened.
 * How many witnesses are there?
 * 
 * Example: Input: [3, 6, 3, 4, 1] Output: 3
 * 
 * @author Sushil
 *
 */
public class WitnessOfTheTallPeople {

	public static void main(String[] args) {

		System.out.println(witnesses(new int[] { 3, 6, 3, 7, 1 }));
	}

	private static int witnesses(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}

		int noOfwitnesses = 1;

		int maxSofar = heights[heights.length - 1];

		for (int i = heights.length - 2; i >= 0; i--) {

			if (heights[i] > maxSofar) {
				noOfwitnesses++;
				maxSofar = heights[i];
			}

		}

		return noOfwitnesses;
	}
}

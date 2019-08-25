package interviewcamp.recursionandbacktracking;

import java.util.Arrays;

/**
 * Given an array A, print all permutations of size X.For example,Input:A =
 * [1,2,3]X = 2 Output:[1, 2][1, 3][2, 1][2, 3][3, 1][3, 2]
 * 
 * @author Sushil
 *
 */
public class PrintAllPermutationsOfSizeX {

	public static void main(String[] args) {

		printPerms(new int[] { 1, 2, 3 }, 2);
	}

	public static void printPerms(int[] a, int x) {

		if (a == null || a.length == 0 || x > a.length) {
			return;
		}

		int[] buffer = new int[x];
		boolean[] isInBuffer = new boolean[a.length];

		printPermsHelper(a, buffer, 0, isInBuffer);

	}

	private static void printPermsHelper(int[] a, int[] buffer, int bufferIndex, boolean[] isInBuffer) {

		if (bufferIndex == buffer.length) {
			System.out.println(Arrays.toString(buffer));
			return;
		}

		for (int i = 0; i < a.length; i++) {
			if (!isInBuffer[i]) {
				buffer[bufferIndex] = a[i];
				isInBuffer[i] = true;
				printPermsHelper(a, buffer, bufferIndex + 1, isInBuffer);
				isInBuffer[i] = false;

			}
		}

	}
}

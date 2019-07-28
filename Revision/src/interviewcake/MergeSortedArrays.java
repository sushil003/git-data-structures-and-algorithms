package interviewcake;

/**
 * 
 * @author Sushil
 *
 */
public class MergeSortedArrays {

	public static void main(String[] args) {

		int[] myArray = new int[] { 3, 4, 6, 10, 11, 15 };
		int[] alicesArray = new int[] { 1, 5, 8, 12, 14, 19 };
		int[] mergeArray = mergeArrays(myArray, alicesArray);
		for (int temp : mergeArray) {
			System.out.println(temp + "\t");
		}
	}

	public static int[] mergeArrays(int[] myArray, int[] alicesArray) {
		int[] mergedArray = new int[myArray.length + alicesArray.length];

		int currentMineIndex = 0;
		int currentAliceIndex = 0;
		int currentMergedIndex = 0;

		while (currentMergedIndex < mergedArray.length) {

			boolean isMyArrayExausted = currentMineIndex >= myArray.length;
			boolean isAliceArrayExuasted = currentAliceIndex >= alicesArray.length;

			if (!isMyArrayExausted
					&& (isAliceArrayExuasted || myArray[currentMineIndex] < alicesArray[currentAliceIndex])) {
				mergedArray[currentMergedIndex] = myArray[currentMineIndex];
				currentMineIndex++;
			} else {
				mergedArray[currentMergedIndex] = alicesArray[currentAliceIndex];
				currentAliceIndex++;
			}
			currentMergedIndex++;
		}

		return mergedArray;

	}

}

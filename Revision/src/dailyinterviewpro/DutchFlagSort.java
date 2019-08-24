package dailyinterviewpro;

import java.util.Arrays;

public class DutchFlagSort {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(dutchFlag(new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1})));
	}

	public static int[] dutchFlag(int[] arr) {

		int low = 0;
		int mid = 0;
		int high = arr.length - 1;

		while (mid <= high) {

			if (arr[mid]==0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				swap(arr, mid, high);
				high--;
			}
		}

		return arr;
	}

	public static void swap(int[] a, int b, int c) {

		int temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}
}

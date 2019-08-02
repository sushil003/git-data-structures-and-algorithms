package interviewcamp.arraysandstrings;

import java.util.Arrays;

/**
 * 
 * @author Sushil
 *
 */
public class DutchNationalFlag {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(dutchFlag(new int[] {3,5,2,6,8,4,4,6,4,4,3},5)));
		//[3, 2, 3, 4, 4, 4, 5, 4, 6, 8, 6]
	}

	public static int[] dutchFlag(int[] arr, int pivot) {

		int low =0;
		int mid = 0;
		int high= arr.length-1;
		
		int middle = pivot;
		
		while(mid < high) {
			
			if(arr[mid] < middle) {
				swap(arr, low, mid);
				low++;
				mid++;
			}else if(arr[mid]==middle) {
				mid++;
			}else if(arr[mid] > middle) {
				swap(arr, mid, high);
				high--;
			}
		}
		

		return arr;
	}

	public static void swap(int[] a, int b, int c) {
		
		int temp = a[b];
		a[b]=a[c];
		a[c]= temp;
	}
}

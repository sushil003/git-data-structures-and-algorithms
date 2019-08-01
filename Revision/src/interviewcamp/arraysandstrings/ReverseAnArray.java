package interviewcamp.arraysandstrings;

import java.util.Arrays;

/**
 * 
 * @author Sushil
 *
 */
public class ReverseAnArray {

	public static void main(String[] args) {

		int[] a = {4,1,0,3,2};
		System.out.println(Arrays.toString(a));
		reverseArray(a);
		System.out.println(Arrays.toString(a));
		
	}

	public static void reverseArray(int[] a) {
		
		int start=0;
		int end=a.length-1;
		
		while(start < end) {
			SWAP(a,start,end);
			start++;
			end--;
		}
	}

	private static void SWAP(int[] a, int start, int end) {
		int temp = a[start];
		a[start] = a[end];
		a[end] =temp;
	}
}

package interviewcamp.arraysandstrings;

import java.util.Arrays;

/**
 * Given an array of integers, find the shortest subarray, that if sorted,
 * results in theentire array being sorted.[1,2,4,5,3,5,6,7,9] --> [4,5,3] - If
 * you sort from indices 2 to 4, the entire array is sorted.[1,3,5,2,6,4,7,8,9]
 * --> [3,5,2,6,4] - indices 1 to 5
 * 
 * @author Sushil
 *
 */
public class ShortestUnsortedSubarrayInArray {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(shortestUnsortedSubarray(new int[] {1,2,4,5,3,5,6,7,9})));
	}

	public static int[] shortestUnsortedSubarray(int[] a) {
		int i=0, j=0;
		
		for(i=0; i<a.length; i++) {
			if(a[i+1] < a[i]) {
				break;
			}
		}
		
		for(j=a.length-1; j>0;j--) {
			
			if(a[j-1] > a[j]) {
				break;
			}
		}
		
		if(i>=a.length-1 || j<=0) {
			return null;
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int k=i; k<=j; k++) {
			if(a[k] > max) {
				max= a[k];
			}else if(a[k] < min) {
				min= a[k];
			}
		}
		
		while(i>0 && a[i-1] > min) {
			i--;
		}
		
		while(j < (a.length-1) && a[j+1] < max) {
			j++;
		}
		
		return new int[] {i,j};
	}

}

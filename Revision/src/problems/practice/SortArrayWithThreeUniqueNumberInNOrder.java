package problems.practice;

import java.util.Arrays;

/**
 * Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list
 * in O(n) time.
 * 
 * Example 1: Input: [3, 3, 2, 1, 3, 2, 1] Output: [1, 1, 2, 2, 3, 3, 3]
 * 
 * @author Sushil
 *
 */
public class SortArrayWithThreeUniqueNumberInNOrder {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(sortNums(new int[] {3, 3, 2, 1, 3, 2, 1})));
	}

	public static int[]  sortNums(int[] arr) {
		int low =0;
		int high=arr.length-1;
		int i=0;
		while(i<=high) {
			
			if(arr[i]==1) {
				swap(arr, i, low);
				i++;
				low++;
			}else if(arr[i]==2) {
				i++;
			}else if(arr[i]==3) {
				swap(arr, i, high);
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

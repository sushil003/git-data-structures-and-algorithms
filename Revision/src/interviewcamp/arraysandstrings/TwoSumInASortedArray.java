package interviewcamp.arraysandstrings;

import java.util.Arrays;

/**
 * 
 * @author Sushil
 *
 */
public class TwoSumInASortedArray {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(twoSum(new int[] {1,2,4,5,6}, 9)));
	}

	public static int[] twoSum(int[] a , int x) {
		
		int start =0;
		int end = a.length-1;
		
		while(start < end) {
			int sum = a[start] + a[end];
			
			if(sum < x) {
				start++;
			}else if(sum >x) {
				end--;
			}else {
				return new int[] {a[start],a[end]};
			}
		}
		
		return null;
	}
}

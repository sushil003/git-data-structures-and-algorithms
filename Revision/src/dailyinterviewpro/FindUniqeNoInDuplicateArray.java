package dailyinterviewpro;

import java.util.Arrays;

/**
 * Given a list of numbers, where every number shows up twice except for one
 * number, find that one number.
 * 
 * Example: Input: [4, 3, 2, 4, 1, 3, 2] Output: 1
 * 
 * @author Sushil
 *
 */
public class FindUniqeNoInDuplicateArray {

	public static void main(String[] args) {

		System.out.println(findUnique(new int[] {4, 3, 2, 4, 1,1, 3,}));
	}

	public static int findUnique(int[] a) {
		
		Arrays.sort(a);
		
		for(int i=0; i<a.length;i++) {
			if(a[i]!=a[i+1]) {
				return a[i];
			}
			i++;
		}
		
		return -1;
	}
}

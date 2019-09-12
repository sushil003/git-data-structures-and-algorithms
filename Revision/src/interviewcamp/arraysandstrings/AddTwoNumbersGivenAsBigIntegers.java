package interviewcamp.arraysandstrings;

import java.util.Arrays;

/**
 * You are given two arrays that represent Big Integers. That means each element
 * is a single digit number and index 0 represents the lowest value. For
 * example: a = [3,4,6,1] (1643) b = [1,3,1] (131) Sum = [4,7,7,1] (1774)
 * 
 * @author Sushil
 *
 */
public class AddTwoNumbersGivenAsBigIntegers {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(add(new int[] {3,4,6,1}, new int[] {1,3,1})));
	}

	public static int[] add(int[] a, int[] b) {
		
		if(a==null || b==null) {
			throw new IllegalArgumentException();
		}
		
		int[] larger = a.length > b.length ? a : b;
		int[] smaller = larger == a ? b : a;
		
		int[] result = new int[larger.length+1];
		int carry=0;
		
		for(int i=0; i < larger.length ; i++) {
			int sum = larger[i] + (i < smaller.length ? smaller[i] : 0 ) +carry;
			carry = sum/10;
			result[i] = sum%10;
		}
		
		if(carry !=0) {
			result[larger.length]=carry;
		}
		
		
		return result;
	}
}

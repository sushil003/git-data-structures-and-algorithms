package interviewcamp.arraysandstrings;

import java.util.Arrays;

/**
 * You are given two arrays that represent Big Integers. That means each element
 * is a single digit number and index 0 represents the lowest value. For
 * example: a = [3,4,6,1] (1643) b = [1,3,1] (131) Product = [3,3,2,5,1,2]
 * (215233)
 * 
 * @author Sushil
 *
 */
public class MultiplyTwoNumbersGivenAsBigIntegers {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(multiply(new int[] {3,4,6,1}, new int[] {1,3,1})));
	}

	public static int[] multiply(int[] a, int[] b) {

		if (a == null || b == null) {
			throw new IllegalArgumentException();
		}
		int[] result = null;

		for (int i = 0; i < a.length; i++) {
          int j=0,carry = 0;
          int[] p = new int[i+b.length];
          
          while(j < b.length || carry!=0) {
        	  	int prod = a[i]*(j < b.length ? b[j] : 0) +carry;
        	  	carry=prod/10;
        	  	p[i+j]=prod%10;
        	  	j++;
          }
          
          result = result==null ? p : AddTwoNumbersGivenAsBigIntegers.add(result, p);
		}

		return result;
	}
}

package interviewcamp.arraysandstrings;

import java.util.Arrays;

/**
 * 
 * @author Sushil
 *
 */
public class CloneEvenNumbersInArray {

	public static void main(String[] args) {

		int[] a = {1,2,5,6,8,-1,-1,-1};
		
		System.out.println(Arrays.toString(a));
		
		cloneEvenNumbers(a);
		
		System.out.println(Arrays.toString(a));
		
	}

	public static void cloneEvenNumbers(int[] a) {
		
		int end = a.length;
		int i= getLastElement(a);
		
		while(i>=0) {
			
			if(a[i]%2==0) {
				a[--end] = a[i];
				a[--end] = a[i];
			}else {
				a[--end] = a[i];
			}
			i--;
		}
		
	}

	private static int getLastElement(int[] a) {

		int index = a.length-1;
		
		while(index >=0 && a[index] ==-1)
		{
			index--;
		}
		
		return index;
	}
}

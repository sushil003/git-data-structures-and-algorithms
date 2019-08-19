package interviewcamp.recursionandbacktracking;

import java.util.Arrays;

/**
 * 
 * @author Sushil
 *
 */
public class PrintAllCombinationsArrayOfGivenLength {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7};
		printCombinations(a,2);
	}

	public static void printCombinations(int[] arr, int num) {
		
		int[] buffer = new int[num];
		printCombos(arr,buffer,0,0);
	}
	
	private static void printCombos(int[] a, int[] buffer, int startIndex, int bufferIndex) {
		
		if(bufferIndex==buffer.length) {
			System.out.println(Arrays.toString(buffer));
			return;
		}
		
		if(startIndex==a.length) {
			return;
		}
		
		for(int i=startIndex; i<a.length; i++) {
			buffer[bufferIndex]=a[i];
			printCombos(a,buffer,i+1,bufferIndex+1);
		}
	}
}

package interviewcamp.recursionandbacktracking;

import java.util.Arrays;

/**
 * 
 * @author Sushil
 *
 */
public class PrintAllSubSetOfAArray {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7};
		printCombinations(a);
	}

	public static void printCombinations(int[] arr) {
		
		if (arr == null || arr.length == 0)       
			return;
		int[] buffer = new int[arr.length];
		printCombos(arr,buffer,0,0);
	}
	
	private static void printCombos(int[] a, int[] buffer, int startIndex, int bufferIndex) {
		
	//	System.out.println(Arrays.toString(buffer));
		
		printArray(buffer,bufferIndex);
		
		if(bufferIndex==buffer.length) {
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

	private static void printArray(int[] buffer, int bufferIndex) {

		StringBuilder builder=new StringBuilder();
		builder.append("[");
		for(int i=0;i<bufferIndex;i++) {
			builder.append(buffer[i]+" ");
		}
		builder.append("]");
		
		System.out.println(builder.toString());
	}
}

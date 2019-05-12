package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] actual = { 5, 1, 6, 2, 3, 4,7};
		mergeSort(actual);

		System.out.println(Arrays.toString(actual));
	}
	
  private static void mergeSort(int [] array) {
	  
	  mergeSort(array, new int[array.length],0,array.length-1);
  }

	private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		
		if(leftStart >= rightEnd) {
			return;
		}

		int middle = ( leftStart + rightEnd )/2;
		
		mergeSort(array, temp, leftStart, middle);
		mergeSort(array, temp, middle+1, rightEnd);
		merge(array,temp,leftStart,rightEnd);
	}

	private static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
		

		int leftEnd =( leftStart + rightEnd )/2;
		int rightStart = leftEnd +1;
		int size = rightEnd -leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			}else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		
		System.arraycopy(array, left, temp, index, leftEnd-left+1);
		System.arraycopy(array, right, temp, index, rightEnd-right+1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}

}

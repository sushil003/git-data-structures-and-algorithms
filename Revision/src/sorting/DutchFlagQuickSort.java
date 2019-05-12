package sorting;

import java.util.Arrays;

public class DutchFlagQuickSort {

	public static void main(String[] args) {

		int[] actual = { 5, 1, 6, 2, 3, 4,7};
		//sort(actual,0,actual.length-1);
		dutchFlagPartition(actual,2);
		System.out.println(Arrays.toString(actual));
	}
	
	public static void sort(int[] arr) {
	
		
		
	}

	public static int dutchFlagPartition(int[] arr, int pivot) {

	int smaller=0;
	int equal =0;
	int larger =arr.length;
	while(equal < larger) {
		
		if(arr[smaller] < pivot) {
			swap(arr, smaller++, equal++);
		} else if((arr[smaller] == pivot)) {
			++equal;
		}else {
			swap(arr, smaller, --larger);
		}
	}
	return smaller;
	}
	
	
public static void swap(int[] arr, int smaller,int larger) {
		
		int temp = arr[smaller];
		arr[smaller] = arr[larger];
		arr[larger] = temp;
	}

}

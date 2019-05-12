package sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int[] actual = { 5, 1, 6, 2, 3, 4,7};
		sort(actual,0,actual.length-1);
		System.out.println(Arrays.toString(actual));
	}
	
	public static void sort(int[] arr, int left, int right) {

		if(left >= right) {
			return;
		}
		
		int pivot = arr[(left+right)/2];
		int index =partition(arr,left,right,pivot);
		sort(arr,left,index-1);
		sort(arr,index,right);

	}

	public static int partition(int[] arr, int left, int right, int pivot) {
		
		while(left <= right) {
			while(arr[left] < pivot) {
				left++;
			}
			while(arr[right] > pivot) {
				right--;
			}
			if(left <= right) {
				swap(arr,left,right);
				left++;
				right--;
			}
		}
		
		return left;
	}
	
	public static void swap(int[] arr, int left,int right) {
		
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}

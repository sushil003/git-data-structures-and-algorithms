package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int arr[] = { 64, 34, 25, 12, 22, 11, 90 }; 
        bubbleSort1(arr); 
        System.out.println("Sorted array: "); 

        System.out.println(Arrays.toString(arr));
	}
	
	
   private  static void bubbleSort1(int arr[]) 
    { 
	   boolean isSorted = false;
	   int lastSorted = arr.length-1 ;
        while(!isSorted) {
        	isSorted =true;
        	for(int i=0; i <lastSorted ; i++) {
        		if(arr[i] > arr[i+1]) {
        			swapped(arr, i, i+1);
        			isSorted =false;
        		}
        	}
        	lastSorted--;
        }
        	
    } 
    
    private static void swapped(int[] arr, int i, int j) {
    	
    	int temp = arr[i];
    	arr[i]=arr[j];
    	arr[j] =temp;
    }

}

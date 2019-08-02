package interviewcamp.arraysandstrings;

import java.util.Arrays;

/**
 * Given an array of positive integers, find a subarray that sums to a given number X.
 * @author Sushil
 *
 */
public class SubArraySumsToX {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(xSumSubarray(new int[] {2,1,4,5,3,5,1,2,4},12)));
	}

  public static int[] xSumSubarray(int[] arr,int x) {
	  
	  if(arr==null && arr.length==0) {
		  return new int[] {-1,-1}; 
	  }
	  
	  int start=0;
	  int end =0;
	  
	  int sum =arr[0];
	  
	  while(start< arr.length) {
		  if(start > end) {
			  end= start;
			  sum = arr[start];
		  } else if(sum > x) {
			 sum-=arr[start++];
		  } else if(sum < x) {
			  end++;
			  if(end < arr.length) {
				  sum+=arr[end];
			  } else {
				  break;
			  }
			  
		  }else {
			  return new int[] {start,end};
		  }
	  }
	  
	  return new int[] {-1,-1};
  }
}

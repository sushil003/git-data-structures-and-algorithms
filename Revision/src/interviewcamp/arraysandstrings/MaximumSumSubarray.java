package interviewcamp.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that can be both +ve and -ve, find the contiguous subarraywith the largest sum.
 * e.g, [1,2,-1,2,-3,2,-5]  -> the first 4 elements have the largest sum.
 * 
 * @author Sushil
 *
 */
public class MaximumSumSubarray {
	
	public static void main(String[] args) {

		int[] arr= {1,2,-1,2,-3,2,-5};
		
		System.out.println(maxSubArraySum(arr));
	}

	
	
	public static int maxSubArraySum(int[] arr) {
		int maxSum=0;
		int maxSumEndingHere=0;
		Map<Integer, Integer> map= new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length ; i++) {
			maxSumEndingHere= Math.max(0, maxSumEndingHere+arr[i]);
			map.put(maxSumEndingHere, i);
			maxSum=Math.max(maxSum, maxSumEndingHere);
		}
		
		return maxSum; 
	}

}

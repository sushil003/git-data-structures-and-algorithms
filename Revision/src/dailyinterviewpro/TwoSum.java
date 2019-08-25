package dailyinterviewpro;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a list of numbers, and a target number k. Return whether or not
 * there are two numbers in the list that add up to k.
 * 
 * Example: Given [4, 7, 1 , -3, 2] and k = 5, return true since 4 + 1 = 5.
 * 
 * @author Sushil
 *
 */
public class TwoSum {

	public static void main(String[] args) {

		System.out.println(findTwoSum(new int[] {4,7,1,-3,2},5));
	}

	public static boolean findTwoSum(int[] input,int sum) {
		
		Map<Integer, Integer> twoSumMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<input.length;i++) {
        
			int compliment = sum - input[i];
			if(twoSumMap.containsKey(compliment)) {
				return true;
			}
			
			twoSumMap.put(input[i], i);
	    }
		
		return false;
}
	}

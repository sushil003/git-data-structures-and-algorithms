package dailyinterviewpro;

/**
 * You are given an array of integers. Find the maximum sum of all possible
 * contiguous subarrays of the array.
 * 
 * Example:
 * 
 * [34, -50, 42, 14, -5, 86]
 * 
 * Given this input array, the output should be 137. The contiguous subarray
 * with the largest sum is [42, 14, -5, 86].
 * 
 * @author Sushil
 *
 */
public class ContiguousSubarrayWithMaximumSum {

	public static void main(String[] args) {

		System.out.println(maxSubArray(new int[] {34, -50, 42, 14, -5, 86}));
		System.out.println(maxSubArray1(new int[] {34, -50, 42, 14, -5, 86}));
	}

	
	 public static int maxSubArray(int[] nums) {
		    
	      
	      int maxSum =nums[0];
	        
	    for(int i=1; i< nums.length;i++){
	          if(nums[i-1] > 0){
	              nums[i]+=nums[i-1];
	          }
	        maxSum = Math.max(nums[i],maxSum);
	    }
	        
	        return maxSum;
	        
	    }
	
	public static int maxSubArray1(int[] nums) {

		int currSum = nums[0];
		int maxSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currSum = Math.max(nums[i], currSum + nums[i]);
			maxSum = Math.max(currSum, maxSum);
		}

		return maxSum;

	}
}

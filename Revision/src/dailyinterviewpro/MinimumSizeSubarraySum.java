package dailyinterviewpro;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example:
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray [4,3]
 * has the minimal length under the problem constraint. Follow up: If you have
 * figured out the O(n) solution, try coding another solution of which the time
 * complexity is O(n log n).
 * 
 * @author Sushil
 *
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {

		System.out.println(minSubArrayLen(7,new int[] {2,3,1,2,4,3}));
	}

	public static int minSubArrayLen(int s, int[] nums) {
	       
        int left=0;
        int right=0;
        int sum=0;
        int minLen = Integer.MAX_VALUE;
        
        while(right<nums.length){
            sum+=nums[right++];
            while(sum>=s){
                sum-=nums[left++];
                minLen=Math.min(minLen,right-left+1);                
            }
        }
        
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}


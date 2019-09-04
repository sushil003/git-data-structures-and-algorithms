package dailyinterviewpro;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a sequence of numbers, find the longest sequence that contains only 2
 * unique numbers.
 * 
 * Example: Input: [1, 3, 5, 3, 1, 3, 1, 5] Output: 4 The longest sequence that
 * contains just 2 unique numbers is [3, 1, 3, 1]
 * 
 * Similar to https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * @author Sushil
 *
 */
public class LongestSequenceWithTwoUniqueNumbers {

	public static void main(String[] args) {

		System.out.println(findSequence(new int[] {1, 3, 5, 3, 1, 3, 1, 5}));
		
	}

    public static int findSequence(int[] s) {
        
        int n=s.length;
        
        if(n<3){
            return n; 
        }
        Map<Integer,Integer> map = new HashMap<>();
        int left =0;
        int right=0;
        
        int max = 2;
        
        while(right < n){
          
            if(map.size() < 3){
                map.put(s[right],right++);
            }
            
            if(map.size()==3){
                int left_id=Collections.min(map.values());
                map.remove(s[left_id]);
                left=left_id+1;
            }
            
            max=Math.max(max,right-left);
            
        }
        
        return max;
    }
}

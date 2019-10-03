package dailyinterviewpro;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * Example 1:
 * 
 * Input: s = "eceba", k = 2 Output: 3 Explanation: T is "ece" which its length
 * is 3. Example 2:
 * 
 * Input: s = "aa", k = 1 Output: 2 Explanation: T is "aa" which its length is
 * 2.
 * 
 * @author Sushil
 *
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {

		
	}

	 public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        
	        int n = s.length();
	        
	        if(n*k==0){
	            return 0;
	        }
	        
	        int left=0;
	        int right=0;
	        int max_len=1;
	        
	        Map<Character,Integer> map = new HashMap<>();
	        
	        
	        while(right < n){
	            
	            map.put(s.charAt(right),right++);
	            
	            if(map.size()==k+1){
	                
	                int id_del = Collections.min(map.values());
	                
	                map.remove(s.charAt(id_del));
	                left = id_del+1;
	            }
	            
	            max_len=Math.max(max_len,right-left);
	        }
	        
	        return max_len;
	    }
	 
	 public int lengthOfLongestSubstringKDistinctUsingLinkedHashMap(String s, int k) {
	        
	        int n = s.length();
	        
	        if(n*k==0){
	            return 0;
	        }
	        
	        int left=0;
	        int right=0;
	        int max_len=1;
	        
	        Map<Character,Integer> map = new LinkedHashMap<>(k+1);
	        
	        
	        while(right < n){
	            
	            Character c = s.charAt(right);
	            
	            if(map.containsKey(c)){
	                map.remove(c);
	            }
	            
	            map.put(s.charAt(right),right++);
	            
	            if(map.size()==k+1){
	                
	             Map.Entry<Character,Integer> leftmost = map.entrySet().iterator().next();
	                
	                map.remove(leftmost.getKey());
	                left = leftmost.getValue()+1;
	            }
	            
	            max_len=Math.max(max_len,right-left);
	        }
	        
	        return max_len;
	    }
}

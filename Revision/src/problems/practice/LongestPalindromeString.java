package problems.practice;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" 
 * Output: "bab" Note: "aba" is also a valid answer. 
 * 
 * Example 2:
 * 
 * Input: "cbbd" 
 * Output: "bb"
 * 
 * @author sushi
 *
 */
public class LongestPalindromeString {

	 int lo,max;
	
	public static void main(String[] args) {

		LongestPalindromeString palindromeString=new LongestPalindromeString();
		System.out.println(palindromeString.longestPalindrome("cbbd"));
	}

	 public String longestPalindrome(String s) {
	      
	        if(s==null || s.length() < 2){
	            return s;
	        }
	        
	        int len = s.length();
	        for(int i=0; i<len ;i++){
	            extendsPalindrome(s,i,i);
	             extendsPalindrome(s,i,i+1);
	        }
	        
	        return s.substring(lo,lo+max);
	    }
	    
	    private void extendsPalindrome(String s,int j,int k){
	        
	        while(j>=0 && k<=s.length()-1 && s.charAt(j)==s.charAt(k)){
	            j--;
	            k++;
	        }
	        if(max< k-j-1){
	            lo=j+1;
	            max = k-j-1;
	        }
	    }
}

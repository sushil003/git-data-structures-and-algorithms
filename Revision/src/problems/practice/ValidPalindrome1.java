package problems.practice;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: true 
 * 
 * Example 2:
 * 
 * Input: "race a car" Output: false
 * 
 * @author Sushil
 *
 */
public class ValidPalindrome1 {

	public static void main(String[] args) {

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	 public static boolean isPalindrome(String s) {
	        
	        int len = s.length()-1;
	        
	        for(int i=0, j=len; i<j ; i++,j--){
	            
	            while(i<=len&&!Character.isLetterOrDigit(s.charAt(i)))
	                i++;
	            while(j>=0 &&  !Character.isLetterOrDigit(s.charAt(j)))
	                j--;
	            if(i>len || j<0)
	                break;
	            if(Character.toUpperCase(s.charAt(i))!=Character.toUpperCase(s.charAt(j))){
	                return false;
	            }
	        }
	        
	        return true;
	    }
}

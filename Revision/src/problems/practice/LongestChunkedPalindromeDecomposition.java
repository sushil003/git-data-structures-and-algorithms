package problems.practice;
/**
 * 	Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:

Each a_i is a non-empty string;
Their concatenation a_1 + a_2 + ... + a_k is equal to text;
For all 1 <= i <= k,  a_i = a_{k+1 - i}.
 

Example 1:

Input: text = "ghiabcdefhelloadamhelloabcdefghi"
Output: 7
Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".
Example 2:

Input: text = "merchant"
Output: 1
Explanation: We can split the string on "(merchant)".
Example 3:

Input: text = "antaprezatepzapreanta"
Output: 11
Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".
Example 4:

Input: text = "aaa"
Output: 3
Explanation: We can split the string on "(a)(a)(a)".
 

Constraints:

text consists only of lowercase English characters.
1 <= text.length <= 1000

 * @author Sushil
 *
 */
public class LongestChunkedPalindromeDecomposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestDecompositionIterative(String text) {

        int res = 0;
        int n= text.length();
        String l="";
        String r = "";
        for(int i=0; i<n ; i++){
            l=l+text.charAt(i);
            r=text.charAt(n-i-1)+r;
            if(l.equals(r)){
                res++;
                l="";
                r="";
            }
        }
        
        return res;
    }
	
	 int longestDecompositionRecursive(String text) {
		 
	        if(text.length()== 0){  return 0;}
	        int n =text.length();
	        for(int i = 1;i <= text.length()/2; ++i){
	           if(text.substring(0,i) == text.substring(n-i,i)){
	               return 2 + longestDecompositionRecursive(text.substring(i,n-2*i));
	           }
	        }
	        return 1;
	    }
}

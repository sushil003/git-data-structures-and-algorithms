package interviewcake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Sushil
 *
 */
public class StringPermutations {

	public static void main(String[] args) {

		 String str = "ABC"; 
	        int n = str.length(); 
	        StringPermutations permutation = new StringPermutations();
	        List<String> allPermutationList = new ArrayList<>();
	        permutation.permute(str, 0,allPermutationList); 
	        System.out.println(allPermutationList);

	}

	private void permute(String str, int l,List<String> allPermutationList) {

		if(l==str.length()-1) {
			allPermutationList.add(str);
		}
		
		for(int i=l; i<str.length();i++) {
			str= swap(str,l,i);
			permute(str,l+1,allPermutationList);
			str= swap(str,l,i);
		}
		
	}
	
	public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }

}

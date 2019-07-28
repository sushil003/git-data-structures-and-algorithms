package interviewcake;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Sushil
 *
 */
public class PalindromeString {

	public static void main(String[] args) {

		String input="civicd";
		System.out.println(hasPalindromePermutation(input));
	}
	
	public static boolean hasPalindromePermutation(String theString) {
		
		Set<Character> unpairedCharacters = new HashSet<>();
		for(char c: theString.toCharArray()){
		
			if(unpairedCharacters.contains(c)){
				unpairedCharacters.remove(c);
			}else {
				unpairedCharacters.add(c);
			}
			
		}
		
		if(unpairedCharacters.size()<=1){
			return true;
		}else {
			return false;
		}
	}
}

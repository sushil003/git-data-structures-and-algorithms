package interviewcamp.arraysandstrings;

/**
 * Find the longest palindrome in a string. For example"abbababaab" -> "babab"
 * 
 * @author Sushil
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
  
		String input = "abbababaab";
		int[] result = longestPalindrome(input);
		
		
		System.out.println(input.substring(result[0],result[1]));
	}

	public static int[] longestPalindrome(String a) {

		if (a == null || a.isEmpty()) {
			return null;
		}
		char[] ch = a.toCharArray();
		int longest = 1;
		int[] result = new int[2];

		//odd
		for (int i = 0; i < ch.length; i++) {
			int offset = 0;
			while (isValidIndex(ch, i - 1 - offset) && isValidIndex(ch, i + 1 + offset)
					&& ch[i - 1 - offset] == ch[i + 1 + offset]) {
				offset++;
			}
			int longestAtI = offset * 2 + 1;
			if (longestAtI > longest) {
				longest = longestAtI;
				result[0] = i - offset;
				result[1] = i + offset;
			}
		}

		//even
		for (int i = 0; i < ch.length; i++) {
			int offset = 0;
			while (isValidIndex(ch, i - offset) && isValidIndex(ch, i + 1 + offset)
					&& ch[i - offset] == ch[i + 1 + offset]) {
				offset++;
			}
			int longestAtI = offset * 2;
			if (longestAtI > longest) {
				longest = longestAtI;
				result[0] = i - offset;
				result[1] = i + offset;
			}
		}
		
		result[1]+=1;

		return result;
	}

	private static boolean isValidIndex(char[] a, int i) {
		if (a == null || i < 0 || i >= a.length)
			return false;
		return true;
	}
}

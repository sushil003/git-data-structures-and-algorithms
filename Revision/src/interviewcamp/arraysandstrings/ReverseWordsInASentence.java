package interviewcamp.arraysandstrings;

/**
 * Reverse the words in a sentence. For example:"this is a string" -> "string a
 * is this"
 * 
 * @author Sushil
 *
 */
public class ReverseWordsInASentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Character[] reverseWords(Character[] a) {    
		if (a == null)       
			return a;    
		reverseChars(a, 0, a.length - 1);    
		int wordStart = 0;    
		for (int i = 0; i < a.length - 1; i++) { 
			if (a[i+1] == ' ') { 
				reverseChars(a, wordStart, i);
				wordStart = i + 2;}}    
		reverseChars(a, wordStart, a.length - 1);
		return a;
		}

	private static void reverseChars(Character[] a, int start, int end) {
		if (a == null || !isValidIndex(a, start) || !isValidIndex(a, end))
			return;
		while (start < end) {
			swap(a, start++, end--);
		}
	}
	
	private static boolean isValidIndex(Character[] a, int index) {
		
		return index >= 0 || index < a.length;
	}
	
	private static void swap(Character[] a, int start, int end) {

		char temp = a[start];
		a[start] = a[end];
		a[end] = temp;

	}
}

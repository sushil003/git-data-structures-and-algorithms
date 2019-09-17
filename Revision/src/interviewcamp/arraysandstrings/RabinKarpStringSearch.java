package interviewcamp.arraysandstrings;

/**
 * String Search: Find the index where the larger string A contains a target
 * string T.
 * 
 * @author Sushil
 *
 */
public class RabinKarpStringSearch {

	public static void main(String[] args) {

		System.out.println(search("hello world","ello"));
	}

	public static int search(String str, String target) {
		
		if (str == null || target == null)
			throw new NullPointerException();
		if (target.isEmpty()) // empty string exists in every string
			return 0;
		if (target.length() > str.length())
			return -1;
		int x = 53; // a prime number
		// calculate hash for first target.length letters
		int hashT = 0;
		int hash = 0;
		for (int i = 0; i < target.length(); i++) {
			hashT = hashT * x + target.charAt(i);
			hash = hash * x + str.charAt(i);
		}
		// found match in first substring
		if (hashT == hash && target.equals(str.substring(0, target.length())))
			return 0;
		// calculate x^(t.length - 1) before hand. Notice we didn't use the inbuilt
		// Math.pow() function. This is because it does not wrap around integers if
		// they overflow. If an integer goes past ~2 billion, it goes back to 0 and
		// counts from there. This is the behavior we want. Math.pow() considers the
		// number to be infinity instead of counting from 0 again.
		int xPow = 1;
		for (int i = 0; i < target.length() - 1; i++) {
			xPow *= x;
		}
		for (int i = target.length(); i < str.length(); i++) {
			int toRemove = str.charAt(i - target.length());
			hash = ((hash - toRemove * xPow) * x + str.charAt(i));
			if (hash == hashT && target.equals(str.substring(i - target.length() + 1, i + 1))) {
				return i - target.length() + 1;
			}
		}
		return -1; // not found
	}

}

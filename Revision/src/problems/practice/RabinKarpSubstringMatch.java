package problems.practice;

/**
 * 
 * @author sushi
 *
 */
public class RabinKarpSubstringMatch {

	public static void main(String[] args) {

		System.out.println(rabinKarp("A", "A"));
	}

	public static int rabinKarpUsingStringCompare(String t, String s) {

		if (s.length() > t.length()) {
			return -1;
		}
		int count = 0;
		for (int i = 0; i < t.length(); i++) {
			if (i + s.length() <= t.length()) {
				if (s.equals(t.substring(i, i + s.length()))) {
					return count;
				}
			}
			count++;
		}

		return -1;
	}

	// Returns the index of the first character of the substring if found, -1
	// otherwise.
	public static int rabinKarp(String t, String s) {

		if (s.length() > t.length()) {
			return -1; // s is not a substring of t.
		}

		final int BASE = 26;
		int tHash = 0, sHash = 0; // Hash codes for the substring of t and s.
		int powerS = 1; // BASE^|s-1|.
		for (int i = 0; i < s.length(); i++) {
			powerS = i > 0 ? powerS * BASE : 1;
			tHash = tHash * BASE + t.charAt(i);
			sHash = sHash * BASE + s.charAt(i);
		}

		for (int i = s.length(); i < t.length(); i++) {
			// Checks the two substrings are actually equal or not, to protect
			// against hash collision.
			if (tHash == sHash && t.substring(i - s.length(), i).equals(s)) {
				return i - s.length(); // Found a match.
			}

			// Uses rolling hash to compute the new hash code.
			tHash -= t.charAt(i - s.length()) * powerS;
			tHash = tHash * BASE + t.charAt(i);
		}
		// Tries to match s and t.substring(t.length() - s.length()).
		if (tHash == sHash && t.substring(t.length() - s.length()).equals(s)) {
			return t.length() - s.length();
		}
		return -1; // s is not a substring of t.
	}
}

package problems.practice;

/**
 * 
 * @author sushi
 *
 */
public class PalindromString {

	public static void main(String[] args) {

		System.out.println(isPalindromicString("CIVIC"));
		System.out.println(isPalindromicString("NITIN"));
		System.out.println(isPalindromicString("SUSHIL"));

		System.out.println("--------------------");

		System.out.println(isPalindromicString("CIVIC"));
		System.out.println(isPalindromicString("NITIN"));
		System.out.println(isPalindromicString("SUSHIL"));
	}

	public static boolean isPalindromicString(String s) {

		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindromicUsingStringBuffer(String s) {

		StringBuffer stringBuffer = new StringBuffer(s);

		if (stringBuffer.reverse().toString().equals(s)) {
			return true;
		} else {
			return false;
		}

	}
}

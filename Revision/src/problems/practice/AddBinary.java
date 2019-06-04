package problems.practice;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1" Output: "100" Example 2:
 * 
 * Input: a = "1010", b = "1011" Output: "10101"
 * 
 * @author sushil
 *
 */
public class AddBinary {

	public static void main(String[] args) {

		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));

	}

	public static String addBinary(String a, String b) {

		if (a == null || b == null) {
			return a == null ? b : a;
		}

		int carry = 0;
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {

			int sum = 0;
			sum += (i >= 0) ? a.charAt(i) - '0' : 0;
			sum += (j >= 0) ? b.charAt(j) - '0' : 0;
			sum += carry;

			carry = sum / 2;
			sum %= 2;

			stringBuilder.append(sum);

		}
		return stringBuilder.reverse().toString();
	}
}

package problems.practice;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB ... Example 1:
 * 
 * Input: 1 Output: "A" Example 2:
 * 
 * Input: 28 Output: "AB" Example 3:
 * 
 * Input: 701 Output: "ZY"
 * 
 * @author Sushil
 *
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String convertToTitle(int n) {

		StringBuilder builder = new StringBuilder();
		char ch;

		while (n > 0) {

			ch = (char) ('A' + (--n % 26));
			builder.append(ch);
			n /= 26;
		}

		return builder.reverse().toString();
	}
}

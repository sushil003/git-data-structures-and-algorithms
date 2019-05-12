package problems.practice;

/**
 * 
 * @author sushi
 *
 */
public class ConvertStringToIntAndViceVersa {

	public static void main(String[] args) {

		// System.out.println(stringToInt("-123"));
		// System.out.println(stringToIntWthoutUsingLength("-123"));
		System.out.println(convertIntToString(-123));
	}

	public static int stringToInt(String str) {

		boolean isNegative = str.charAt(0) == '-' ? true : false;

		if (isNegative) {
			String strWithoutSign = str.substring(1);
			int result = convertToint(strWithoutSign);
			return -result;

		} else {

			return convertToint(str);
		}
	}

	private static int convertToint(String str) {
		char lastChar = str.charAt(str.length() - 1);
		int lastCharIntValue = lastChar - '0';

		int sum = ((str.charAt(str.length() - 2) - '0') * 10) + lastCharIntValue;
		int multiple = 10;
		for (int i = str.length() - 3; i >= 0; --i) {
			sum = (str.charAt(i) - '0') * multiple * 10 + sum;
			multiple = multiple * 10;
		}
		return sum;
	}

	public static int stringToIntWthoutUsingLength(String str) {
		int result = 0;
		for (int i = str.charAt(0) == '-' ? 1 : 0; i < str.length(); i++) {
			result = result * 10 + (str.charAt(i) - '0');
		}
		return str.charAt(0) == '-' ? -result : result;
	}

	public static String convertIntToString(int num) {

		boolean isNegative = false;

		if (num < 0) {
			isNegative = true;
		}

		StringBuilder s = new StringBuilder();
		do {
			s.append((char) ('0' + Math.abs(num % 10)));
			num /= 10;
		} while (num != 0);
		if (isNegative) {
			s.append('-');
		}
		s.reverse();
		return s.toString();
	}
}

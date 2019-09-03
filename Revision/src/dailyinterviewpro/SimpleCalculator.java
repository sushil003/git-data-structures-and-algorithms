package dailyinterviewpro;

import java.util.Stack;

/**
 * Given a mathematical expression with just single digits, plus signs, negative
 * signs, and brackets, evaluate the expression. Assume the expression is
 * properly formed.
 * 
 * Example: Input: - ( 3 + ( 2 - 1 ) ) Output: -4
 * 
 * @author Sushil
 *
 */
public class SimpleCalculator {

	public static void main(String[] args) {

		System.out.println(calculate("- ( 3 + ( 2 - 1 ) )"));
	}

	public static int calculate(String s) {

		int operand = 0;
		int sign = 1;
		int result = 0;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (Character.isDigit(ch)) {
				operand = 10 * operand + (int) (ch - '0');
			} else if (ch == '+') {
				result += sign * operand;
				sign = 1;
				operand = 0;
			} else if (ch == '-') {
				result += sign * operand;
				sign = -1;
				operand = 0;
			} else if (ch == '(') {
				stack.push(result);
				stack.push(sign);
				sign = 1;
				result = 0;
			} else if (ch == ')') {
				result += sign * operand;
				result = result * stack.pop();
				result += stack.pop();
				operand = 0;
			}
		}

		return result + (sign * operand);
	}
}

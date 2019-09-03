package interviewcake.stack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * 
 * Input: "3+2*2" Output: 7 Example 2:
 * 
 * Input: " 3/2 " Output: 1 Example 3:
 * 
 * Input: " 3+5 / 2 " Output: 5 Note:
 * 
 * You may assume that the given expression is always valid. Do not use the eval
 * built-in library function.
 * 
 * @author Sushil
 *
 */
public class BasicCalculatorII {

	public static void main(String[] args) {

		BasicCalculatorII basicCalculatorII= new BasicCalculatorII();
		
		System.out.println(basicCalculatorII.calculate("3+2*2"));
	}

	public  int calculate(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Character> operator = new Stack<>();
		Stack<Integer> operand = new Stack<>();

		char[] exp = s.toCharArray();
		
		int cNum=0;

		for (char c : exp) {

			if (isOperand(c)) {
				cNum = 10*cNum+Character.getNumericValue(c);
				operand.push(cNum);
			} else if (isOperator(c)) {

				while (!operator.isEmpty() && precedance(operator.peek()) >= precedance(c)) {
					process(operator, operand);
				}
				operator.push(c);
				cNum=0;
			}
		}

		while (!operator.isEmpty()) {
			process(operator, operand);
		}

		return operand.pop();
	}

	public void process(Stack<Character> operator, Stack<Integer> operand) {

		int num2 =operand.pop();
		int num1 = operand.pop();

		char op = operator.pop();

		int result = 0;

		switch (op) {
		case '/':
			 if(num2!=0)
			result = num1 / num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		}

		operand.push(result);
	}

	private int precedance(char ch) {

		switch (ch) {
		case '/':
		case '*':
			return 2;
		case '+':
		case '-':
			return 1;
		default:
			throw new IllegalArgumentException();
		}
	}

	private boolean isOperand(char ch) {
		return (ch >= '0') && (ch <= '9');
	}

	private boolean isOperator(char ch) {

		return ch == '/' || ch == '*' || ch == '+' || ch == '-';
	}
}

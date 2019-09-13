package problems.practice;

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
		// TODO Auto-generated method stub

	}

	public int calculate(String s) {
		 if (s == null || s.length() == 0) {
		     return 0;
		 }
		 
		 Stack<Integer> stack = new Stack<>();
		 int num = 0;
		 char sign = '+';
		 
		 int n = s.length();
		 
		 for (int i = 0; i < n; i++) {
		     char current = s.charAt(i);            
		     if (Character.isDigit(current)) {
		         num = 10 * num + (int)(current - '0');
		     }
		     
		     if (current == '+' || current == '-' || current == '*' || current == '/' || i == n - 1) {
		         switch (sign) {
		             case '+':
		                 stack.push(num);
		                 break;
		             case '-':
		                 stack.push(-num);
		                 break;
		             case '*':
		                 stack.push(stack.pop() * num);
		                 break;
		             case '/':
		                 stack.push(stack.pop() / num);
		                 break;
		         }
		 		num = 0;
		         sign = current;
		     }
		 }
		 
		 int result = 0;
		 while(!stack.isEmpty()) result += stack.pop();
		 
		 return result;
	}
}

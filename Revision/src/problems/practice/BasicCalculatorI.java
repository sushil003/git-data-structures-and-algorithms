package problems.practice;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * Example 1:
 * 
 * Input: "1 + 1" Output: 2 Example 2:
 * 
 * Input: " 2-1 + 2 " Output: 3 Example 3:
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)" Output: 23 Note: You may assume that the given
 * expression is always valid. Do not use the eval built-in library function.
 * 
 * @author Sushil
 *
 */
public class BasicCalculatorI {

	public static void main(String[] args) {

		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public static int calculate(String s) {

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
		     }else if (current == '(') {
		         int j = i + 1; int braces = 1;
		         for (; j < n; j++) {
		             if (s.charAt(j) == '(') ++braces;
		             if (s.charAt(j) == ')') --braces;
		             if (braces == 0) break;
		         }                
		         num = calculate(s.substring(i + 1, j));
		         i = j;
		     } 
		     
		     if (current == '+' || current == '-'  || i == n - 1) { // i == n-1, makes sure the last number is added to the stack. 
		         switch (sign) {
		             case '+':
		                 stack.push(num);
		                 break;
		             case '-':
		                 stack.push(-num);
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

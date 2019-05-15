package problems.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. An input string is valid if:
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * @author sushi
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {

		/**
		 * Example 1:
		 * 
		 * Input: "()" Output: true
		 * 
		 * Example 2:
		 * 
		 * Input: "()[]{}" Output: true
		 * 
		 * Example 3:
		 * 
		 * Input: "(]" Output: false
		 * 
		 * Example 4:
		 * 
		 * Input: "([)]" Output: false
		 * 
		 * Example 5:
		 * 
		 * Input: "{[]}" Output: true
		 */

	}

	public boolean isValid(String s) {

		Map<Character, Character> openerToCloser = new HashMap<>();
		openerToCloser.put('(', ')');
		openerToCloser.put('[', ']');
		openerToCloser.put('{', '}');
		Set<Character> openers = new HashSet<>(openerToCloser.keySet());
		Set<Character> closers = new HashSet<>(openerToCloser.values());
		Deque<Character> openerStack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {

			if (openers.contains(c)) {
				openerStack.push(c);
			} else if (closers.contains(c)) {
				if (openerStack.isEmpty()) {
					return false;
				} else {
					if (openerToCloser.get(openerStack.pop()) != c) {
						return false;
					}
				}
			}
		}

		return openerStack.isEmpty();
	}
}

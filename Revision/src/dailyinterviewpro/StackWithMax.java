package dailyinterviewpro;

import java.util.Stack;

/**
 * implement a class for a stack that supports all the regular functions (push,
 * pop) and an additional function of max() which returns the maximum element in
 * the stack (return None if the stack is empty). Each method should run in
 * constant time.
 * 
 * @author Sushil
 *
 */
public class StackWithMax {

	Stack<Integer> stack = new Stack<>();

	Stack<Integer> maxStack = new Stack<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void push(int item) {
		stack.push(item);
		
		if(maxStack.isEmpty() || item >= maxStack.peek()) {
			maxStack.push(item);
		}
	}
	

	public int pop() {
		
		int item = stack.pop();
		
		if(!maxStack.isEmpty() && item== maxStack.peek()) {
			maxStack.pop();
		}
		
		return item;
	}
	
	public int getMax() {
		
		return maxStack.peek();
	}
}

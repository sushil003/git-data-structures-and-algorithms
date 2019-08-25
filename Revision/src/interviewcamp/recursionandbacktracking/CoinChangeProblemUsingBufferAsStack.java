package interviewcamp.recursionandbacktracking;

import java.util.Stack;

/**
 * Coin Change Problem: Given a set of coin denominations, print out the
 * different waysyou can make a target amount. You can use as many coins of each
 * denomination as you like.
 * For example: 
 * If coins are [1,2,5] and the target is 5, 
 * output will be:[1,1,1,1,1][1,1,1,2][1,2,2][5]
 * 
 * @author Sushil
 *
 */
public class CoinChangeProblemUsingBufferAsStack {

	public static void main(String[] args) {

		printCoins(new int[] {1,2,5}, 5);
	}

	public static void printCoins(int[] coins,int target) {
		
		if(coins==null || coins.length==0 || target<=0) {
			return;
		}
		
		printCoinsHelper(coins,target,0,new Stack<Integer>(),0);
	}

	private static void printCoinsHelper(int[] coins, int target, int startIndex, Stack<Integer> stack, int sum) {

		if(sum> target) {
			return;
		}
		
		if(sum==target) {
			printBuffer((Stack<Integer>)stack.clone());
			return;
		}
		
		for(int i=startIndex;i<coins.length ; i++) {
			stack.push(coins[i]);
			printCoinsHelper(coins,target,i,stack,sum+coins[i]);
			stack.pop();
		}
		
	}

	private static void printBuffer(Stack<Integer> stack) {

		StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		
		while(!stack.isEmpty()) {
			builder.append(stack.pop()+" ");
		}
		
		builder.append("]");
		System.out.println(builder.toString());
	}
}

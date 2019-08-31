package dailyinterviewpro;

/**
 * You are given a positive integer N which represents the number of steps in a
 * staircase. You can either climb 1 or 2 steps at a time. Write a function that
 * returns the number of unique ways to climb the stairs.
 * 
 * @author Sushil
 *
 */
public class StaircaseProblem {

	public static void main(String[] args) {

		System.out.println(staircase(5));
	}

	public static int staircase(int n) {
		
		if(n<0) {
			return 0;
		}
		
		int first=1;
		int second=2;
		int current=0;
		
		for(int i=2;i<n;i++) {
			current= first+second;
			first=second;
			second=current;
		}
		
		return current;
	}
}

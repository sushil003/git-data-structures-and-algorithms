package interviewcake.dp;
/**
 * Let’s say you have to climb N steps. You can jump 1 step, 3 steps or 5 steps at a time. 
 * How many ways are there to get to the top of the steps.
 * @author Sushil
 *
 */
public class ClimbingStaircaseProblem {

	public static void main(String[] args) {

		System.out.println(wayToClimb(5));
		System.out.println(wayToClimbTopToDown(5));
	}

	//bottom up approach
	public static int wayToClimb(int n) {
		
		int[] a = new int[n+1];
		
		a[0]=1;
		
		for(int i=0; i<a.length;i++) {
			if(i+1<a.length) {
				a[i+1] += a[i];
			}
			
			if(i+3<a.length) {
				a[i+3] += a[i];
			}
			
			if(i+5<a.length) {
				a[i+5] += a[i];
			}
		}
		
		return a[n];
	}
	
	    //top down approach
		public static int wayToClimbTopToDown(int n) {
			
			int[] a = new int[n+1];
			
			a[0]=1;
			
			for(int i=1; i<a.length;i++) {
				int minus1 = i-1 < 0 ? 0 : a[i-1];
				int minus2 = i-3 < 0 ? 0 : a[i-3];
				int minus3 = i-5 < 0 ? 0 : a[i-5];
				a[i] = minus1 + minus2 + minus3;
			}
			
			return a[n];
		}
}

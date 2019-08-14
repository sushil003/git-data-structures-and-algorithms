package problems.practice;

public class CalculatePowers {

	public static void main(String[] args) {

		System.out.println(calculatePower(2,3));
	}

	public static int calculatePower(int x,int n) {
		
		if(x==0) {
			return 0;
		}
		
		if(n==0 && x!=0) {
			return 1;
		}
		
		int pow=1;
		
		for(int i=1; i<=n;i++) {
			pow*=x;
		}
		
		return pow;
	}
}

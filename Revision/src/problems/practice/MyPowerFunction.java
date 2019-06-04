package problems.practice;

/**
 * mplement pow(x, n), which calculates x raised to the power n (xn).
 * 
 * Example 1:
 * 
 * Input: 2.00000, 10 Output: 1024.00000 Example 2:
 * 
 * Input: 2.10000, 3 Output: 9.26100 Example 3:
 * 
 * Input: 2.00000, -2 Output: 0.25000 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * @author sushil
 *
 */
public class MyPowerFunction {

	public static void main(String[] args) {

		System.out.println(myPow(2.0, 2));
	}
	public static double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double res=1;
        for(int i=n;i!=0;i=i/2){
            if(i%2!=0){
                res*=x;
            }
            x*=x;
        }
        return n<0?1/res:res;
    }
}

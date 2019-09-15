package dailyinterviewpro;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example: Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * @author Sushil
 *
 */
public class MoveZeros {

	public MoveZeros() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        
		int[] a = new int[] {0,1,0,3,12};
		
		moveZeros(a);
		System.out.println(Arrays.toString(a));
	}

	public static  void moveZeros(int[] a) {
		
		int count=0;
		
		for(int i=0; i<a.length;i++) {
			if(a[i]!=0) {
				a[count++]=a[i];
			}
		}
		
		while(count < a.length) {
			a[count++]=0;
		}
	}
}

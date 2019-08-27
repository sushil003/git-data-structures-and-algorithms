package dailyinterviewpro;

/**
 * Example:
 * 
 * [13, 4, 7] should return true, since we can modify 13 to any value 4 or less,
 * to make it non-decreasing.
 * 
 * [13, 4, 1] however, should return false, since there is no way to modify just
 * one element to make the array non-decreasing.
 * 
 * Here is the function signature:
 * 
 * def check(lst): # Fill this in.
 * 
 * print check([13, 4, 7]) # True print check([5,1,3,2,5]) # False
 * 
 * Can you find a solution in O(n) time?
 * 
 * @author Sushil
 *
 */
public class NonDecreasingArrayWithSingleModification {

	public static void main(String[] args) {

		System.out.println(check(new int[] { 13, 4, 7 }));
		System.out.println(check(new int[] { 13, 4, 1 }));
		System.out.println(check(new int[] { 5, 1, 3, 2, 5 }));

	}

	public static boolean check(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] >= a[i + 1]) {
				if (++count > 1) {
					return false;
				}
			}
		}
		return count <= 1;
	}
}

package interviewcamp.binarysearch;
/**
 * 
 * @author Sushil
 *
 */
public class BinarySearchClosestElement {

	public static void main(String[] args) {
      
		System.out.println(search(new int[] {1,2,4,5,7,8,9},6 ));
	}

	public static int search(int[] a, int targetA) {

		if (a == null) {
			return -1;
		}

		int left = 0;
		int right = a.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			result=recordMid(a, mid, targetA, result);
			if (a[mid] > targetA) {
				right = mid - 1;
			} else if (a[mid] < targetA) {
				left = mid + 1;
			} else {
				return mid;
			}
		}

		return result;
	}

	private static int recordMid(int[] a, int mid, int targetA, int result) {

		if(result==-1 || Math.abs((a[mid]-targetA)) < Math.abs(a[result]-targetA)) {
			return mid;
		}
		
		return result;
		
	}
	
}

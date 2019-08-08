package interviewcamp.binarysearch;

/**
 * @author Sushil
 *
 */
public class BinarySearchWithDuplicates {

	public static void main(String[] args) {

		System.out.println(Search(new int[] {2,3,4,4,5,6},4));
	}
	public static int Search(int[] a, int targetA){
		
		if(a==null) {
			return -1;
		}
		
		int left =0;
		int right = a.length-1;
		
		while(left < right ) {
			int mid = left + (right - left)/2;
			
			if((a[mid] > targetA) || (a[mid]==targetA && mid > 0 && a[mid-1]==targetA )) {
				right = mid-1;
			} else if(a[mid] < left) {
				left = mid+1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
	
}

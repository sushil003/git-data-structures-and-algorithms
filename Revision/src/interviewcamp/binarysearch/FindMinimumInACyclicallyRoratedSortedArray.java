package interviewcamp.binarysearch;
/**
 * 
 * @author Sushil
 *
 */
public class FindMinimumInACyclicallyRoratedSortedArray {

	public static void main(String[] args) {
		
		System.out.println(cyclicallySortedMin(new int[] {4,5,6,1,2,3}));
	}
	
	public static int cyclicallySortedMin(int[] a) {
		
		if(a==null) {
			return -1;
		}
		int left =0;
		int right=a.length-1;
		int result= a[a.length-1];
		
		while(left <= right) {
			int mid =left +(right-left)/2;
			
			if(a[mid] <=result && (mid==0 || a[mid-1] > a[mid])) {
				return mid;
			}else if(a[mid] > right) {
				left = mid+1;
			}else {
				right= mid-1;
			}
		}
		
		return -1;
	}

}

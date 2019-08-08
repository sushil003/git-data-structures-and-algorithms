package interviewcamp.binarysearch;

public class BinarySearchICamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int Search(int[] a, int targetA){
		
		if(a==null) {
			return -1;
		}
		
		int left =0;
		int right =a.length-1;
		
		while(left <=right) {
			int mid = left+((right-left)>>1);
			
			if(a[mid]==0) {
				return mid;
			}else if(a[mid] > 0) {
				right= mid-1;
			}else {
				left = mid+1;
			}
		}
		

		return -1;
	}
	
}

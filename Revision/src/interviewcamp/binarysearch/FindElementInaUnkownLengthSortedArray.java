package interviewcamp.binarysearch;

/**
 * 
 * @author Sushil
 *
 */
public class FindElementInaUnkownLengthSortedArray {

	public static void main(String[] args) {

		System.out.println(findWithunkownLength(new int[] {3,4,7,9,12,13,15,17,18,21},21));
	}

  public static int findWithunkownLength(int[] a , int target) {
	  
	  if(a==null || a.length==0 || target==0) {
		  return -1;
	  }
	  
	  int high = 1;
	  int lastIndex= -1;
	  
	  while(true) {
		  try {
			  
			  int temp = a[high];
			
		} catch (ArrayIndexOutOfBoundsException e) {
       
			 lastIndex = binarySearchForLastIndex(a, high/2,high);
			 break;
			
		}
		  high*=2;
	  }
	  
	  return binarySearchOverRanges(a,target,0,lastIndex);
  }

	private static int binarySearchOverRanges(int[] a, int target, int left, int right) {

		while(left <= right) {
			int mid = left +(right-left)/2;
			
			if(a[mid] > target) {
				right= mid-1;
			}else if(a[mid] < target) {
				left = mid+1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}

	private static int binarySearchForLastIndex(int[] a, int low, int high) {

		while(low <=high) {
			
			int mid = low + (high-low)/2;
			
			try {
				int temp = a[mid];
			} catch (ArrayIndexOutOfBoundsException e) {
               
				high = mid-1;
				continue;
				
			}
			
			try {
				int temp = a[mid+1];
			} catch (ArrayIndexOutOfBoundsException e) {

				return mid;
				
			}
			
			low = mid+1;
		}
		
		return -1;
	}
  
	
}

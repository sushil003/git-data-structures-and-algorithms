package sorting;

public class BinarySearch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums= new int[] {2,3,4,5,6,7,8,9,10,11,12,13,67,89,123,453,567,789,999,1000,1001};
		int target=999;
		System.out.println(binarySearchIterative(nums,target));
		System.out.println(binarySearchRecursive(nums,target,0,nums.length-1));

	}

	public static boolean binarySearchIterative(int[] nums, int target) {

		int left = 0;
		int right = nums.length-1;
	//	int mid = left + (right-left)/2;
		
	   while(left <=  right) {
		 int  mid = left + ((right-left)/2);
			if(nums[mid] == target) {
				return true;
			} else if(nums[mid] < target) {
				left =mid +1;
			} else {
				right = mid -1;
			}
	   }
		
		return false; 
	}
	
	public static boolean binarySearchRecursive(int[] nums, int target, int left, int right) {

	
		if(left > right ) {
			return false;
		}
		
		int mid = left + ((right-left)/2);
		
		if(nums[mid] == target) {
			return true;
		} else if(target < nums[mid]) {
			return binarySearchRecursive(nums, target, left,mid-1);
		} else {
			
			return binarySearchRecursive(nums, target,mid+1,right);
		}
	}

}

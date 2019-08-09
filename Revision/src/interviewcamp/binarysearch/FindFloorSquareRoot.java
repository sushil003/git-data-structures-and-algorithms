package interviewcamp.binarysearch;

public class FindFloorSquareRoot {

	public static void main(String[] args) {

		System.out.println(floorSqrt(16));
	}

	public static int floorSqrt(int x) {
		
		if(x==0 || x==1) {
			return x;
		}

		int left = 1;
		int right = x;
		int ans =0;
		
		while(left <= right) {
			
			int mid = left + (right-left)/2;
			
			if(mid*mid==x) {
				return mid;
			}else if(mid*mid > x) {
				right = mid-1;
			}else if(mid*mid < x){
				left =mid+1;
				ans= mid;
			}
		}
		
		
		return ans;
	}
}

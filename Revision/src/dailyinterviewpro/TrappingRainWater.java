package dailyinterviewpro;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped.
 * 
 * Example:
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 * 
 * @author Sushil
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int trappedWater = 0;
		while (left < right) {

			if (height[left] < height[right]) {
				if (height[left] > leftMax) {
					leftMax = height[left];
				} else {
					trappedWater += leftMax - height[left];
				}
				left++;
			} else {
				if (height[right] > rightMax) {
					rightMax = height[right];
				} else {
					trappedWater += rightMax - height[right];
				}
				right--;
			}
		}

		return trappedWater;
	}

}

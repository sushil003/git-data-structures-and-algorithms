package dailyinterviewpro;

import java.util.Arrays;

/**
 * Given a list of numbers, find if there exists a pythagorean triplet in that
 * list. A pythagorean triplet is 3 variables a, b, c where a^2 + b^2 = c^2
 * 
 * Example: Input: [3, 5, 12, 5, 13] Output: True Here, 5^2 + 12^2 = 13^2.
 * 
 * @author Sushil
 *
 */
public class PythagoreanTriplet {

	public static void main(String[] args) {

		System.out.println(findPythagoreanTriplets(new int[] {3, 5, 12, 5, 13}));
		
		System.out.println(findPythagoreanTriplets(new int[] { 3, 1, 4, 6, 5}));
		
        System.out.println(isTriplet(new int[] {3, 5, 12, 5, 13},5));
		
		System.out.println(isTriplet(new int[] { 3, 1, 4, 6, 5},5));
	}
	
	

	public static boolean findPythagoreanTriplets(int[] a) {
		
		Arrays.sort(a);
		
		for(int i=a.length-1; i>=0;i--) {

			int left=0;
			int right =i-1;
			
			while(left < right) {
				
				int sides = a[left]*a[left] +  a[right]*a[right];
				int dia = a[i]*a[i];
				
				if(sides==dia) {
					return true;
				}else if(sides < dia) {
					left++;
				}else {
					right--;
				}
			}
		}
		
		return false;
	}
	
	// Geek for Geek solution
	public static boolean isTriplet(int arr[], int n) 
    { 
        // Square array elements 
        for (int i = 0; i < n; i++) 
            arr[i] = arr[i] * arr[i]; 
  
        // Sort array elements 
        Arrays.sort(arr); 
  
        // Now fix one element one by one and find the other two 
        // elements 
        for (int i = n - 1; i >= 2; i--) { 
            // To find the other two elements, start two index 
            // variables from two corners of the array and move 
            // them toward each other 
            int l = 0; // index of the first element in arr[0..i-1] 
            int r = i - 1; // index of the last element in arr[0..i-1] 
            while (l < r) { 
                // A triplet found 
                if (arr[l] + arr[r] == arr[i]) 
                    return true; 
  
                // Else either move 'l' or 'r' 
                if (arr[l] + arr[r] < arr[i]) 
                    l++; 
                else
                    r--; 
            } 
        } 
  
        // If we reach here, then no triplet found 
        return false; 
    } 
}

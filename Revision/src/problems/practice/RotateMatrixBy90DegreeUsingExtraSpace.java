package problems.practice;

public class RotateMatrixBy90DegreeUsingExtraSpace {

	public static void main(String[] args) {

		int[][] origionlArray = {{1,2,3},
		                         {4,5,6},
		                         {7,8,9}};
		printMatrix(rotateMatrix90DegreeClockWise(origionlArray));
		
	}

	
	public static int[][] rotateMatrix90DegreeClockWise(int[][] origionlArray){
		int[][] roratedMatrix = new int[origionlArray.length][origionlArray[0].length];
		
		for(int i=0; i<origionlArray.length;i++) {
			for(int j=0; j< origionlArray[0].length; j++) {
				roratedMatrix[j][origionlArray.length-i-1] = origionlArray[i][j];
			}
		}
		
		return roratedMatrix;
	}
	
	// Function for print matrix 
	static void printMatrix(int arr[][]) 
	
	{ 
		int N = arr.length;
	    for (int i = 0; i < N; i++) 
	    { 
	        for (int j = 0; j < N; j++) 
	        System.out.print( arr[i][j] + " "); 
	        System.out.println(); 
	    } 
	} 
}

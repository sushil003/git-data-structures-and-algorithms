package problems.practice;

public class RotateMatrix90DegreeClockwiseInplace {

	public static void main(String[] args) {

		int a1[][] = {{1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9}};
		
		//printMatrix(rotate(a1,a1.length));
		printMatrix(rotateArray(a1));
	}

	public static int[][] rotateArray(int[][] a){
		
		int n = a.length;
		for(int i=0; i < n / 2 + n % 2;i++) {
			for(int j=0; j < n / 2 ;j++) {
				int[] temp=new int[4];
				int currentI=i;
				int currentJ=j;
				for(int k=0;k<4;k++) {
					temp[k]=a[currentI][currentJ];
					int[] newCoordinates=rotateSub(currentI,currentJ,n);
					currentI=newCoordinates[0];
					currentJ=newCoordinates[1];
				}
				for(int k=0;k<4;k++) {
					a[currentI][currentJ] = temp[(k + 3 ) % 4];
					int[] newCoordinates=rotateSub(currentI,currentJ,n);
					currentI=newCoordinates[0];
					currentJ=newCoordinates[1];
				}
			}
		}
		
		return a;
	}
	
    public static int[][] rotate(int[][] a, int n) {
        // n/2 gives us floor(n/2)
        // and n/2 + n%2 gives us ceiling(n/2)
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int currentI = i;
                int currentJ = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = a[currentI][currentJ];
                    int[] newCoordinates = rotateSub(currentI, currentJ, n);
                    currentI = newCoordinates[0]; currentJ = newCoordinates[1];
                }
                for (int k = 0; k < 4; k++) {
                    a[currentI][currentJ] = tmp[(k + 3) % 4];
                    int[] newCoordinates = rotateSub(currentI, currentJ, n);
                    currentI = newCoordinates[0]; currentJ = newCoordinates[1];
                }
            }
        }
        return a;
    }
	
	private static int[] rotateSub(int i,int j, int n) {
		int[] newCoordinates = new int[2];
		newCoordinates[0]=j;
		newCoordinates[1]=n-1-i;
		return newCoordinates;
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


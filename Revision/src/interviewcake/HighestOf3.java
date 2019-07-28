package interviewcake;

public class HighestOf3 {

	public static void main(String[] args) {

		System.out.println(highestProductOf3(new int[]{1, 10, -5, 1, -100}));
		System.out.println(highestProductOf3brutForce(new int[]{1, 10, -5, 1, -100}));
		//5000
	}
	
	public static int highestProductOf3(int[] arrayOfInts) {
		
		if(arrayOfInts.length <3) {
			throw new IllegalArgumentException("Atleast 3 number required");
		}
		
		int highest= Math.max(arrayOfInts[0],arrayOfInts[1]);
		int lowest= Math.min(arrayOfInts[0],arrayOfInts[1]);
		int highestProductOf2 = arrayOfInts[0]*arrayOfInts[1];
		int lowestProductOf2 = arrayOfInts[0]*arrayOfInts[1];
		int highestProductOf3=arrayOfInts[0]*arrayOfInts[1]*arrayOfInts[2];
		
		for(int i=2; i<arrayOfInts.length; i++) {
			int current=arrayOfInts[i];
			highestProductOf3= Math.max(Math.max(highestProductOf3, current*highestProductOf2),current*lowestProductOf2);
			highestProductOf2= Math.max(Math.max(highestProductOf2,  current*highest), current*lowest);
			lowestProductOf2 = Math.min(Math.min(lowestProductOf2,  current*highest), current*lowest);
			highest=Math.max(highest, current);
			lowest=Math.min(lowest, current);
			
		}
		
		return highestProductOf3;
	}
	
	public static int highestProductOf3brutForce(int[] arrayOfInts) {

		if (arrayOfInts.length < 3) {
			throw new IllegalArgumentException("Atleast 3 number required");
		}
//		int hghestProductOf3 = 0;
//		int tempProductOf3 = 0;

//		for (int i = 0; i < arrayOfInts.length; i++) {
//			for (int j = 0; j < arrayOfInts.length; j++) {
//				for (int k = 0; k < arrayOfInts.length; k++) {
//					hghestProductOf3 = arrayOfInts[i] * arrayOfInts[j] * arrayOfInts[k];
//					if ((hghestProductOf3 <= tempProductOf3)) {
//						hghestProductOf3 = tempProductOf3;
//						tempProductOf3=hghestProductOf3;
//					}
//				}
//			}
//		}
		
		int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2] ;
		int tempProductOf3 = highestProductOf3;
		
		for (int i = 0; i < arrayOfInts.length; i++) {
			for (int j = 0; j < arrayOfInts.length; j++) {
				for (int k = 0; k < arrayOfInts.length; k++) {
					if (i != j && i != k && j != k) {
						tempProductOf3 = arrayOfInts[i] * arrayOfInts[j] * arrayOfInts[k];
						
						if (tempProductOf3 > highestProductOf3) {
							highestProductOf3 = tempProductOf3;
						}
					}
					
				}
			}
		}

		return highestProductOf3;
	}

}

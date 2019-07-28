package interviewcake;

public class ProductOfNumbers {

	public static void main(String[] args) {

		for(int i : getProductsOfAllIntsExceptAtIndex(new int[]{2,4,10})){
			System.out.println(i);
		}
	}
	public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
		 if (intArray.length < 2) {
		        throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
		    }
		    int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];
		    int productSofar=1;
		    for(int i=0;i<intArray.length;i++){
		    	productsOfAllIntsExceptAtIndex[i]=productSofar;
		    	productSofar *= intArray[i];
		    }
		    productSofar=1;
		    for(int i=intArray.length-1;i>=0;i--){
		    	productsOfAllIntsExceptAtIndex[i]*=productSofar;
		    	productSofar *= intArray[i];
		    }
		    return productsOfAllIntsExceptAtIndex;
	}
}

package dailyinterviewpro;

/**
 * 
 * @author Sushil
 *
 */
public class MaximumProductOf3Number {

	public static void main(String[] args) {

		System.out.println(maximumProductOfThree(new int[] {-4,-4,2,8}));
	}

	
	public static int maximumProductOfThree(int[] list) {
		
		if(list.length < 3) {
			throw new IllegalArgumentException("Alteast 3 numver require");
		}
		
		int highest = Math.max(list[0], list[1]);
		int lowest  = Math.min(list[0], list[1]);
		int highestOf2 =list[0]*list[1];
		int lowestOf2  =list[0]*list[1];
		int highestOf3 = list[0]*list[1]*list[2];
		
		for(int i=2;  i < list.length ; i++ ) {
			int current = list[i];
			
			highestOf3= Math.max(Math.max(highestOf2*current, highestOf3), current*lowestOf2);
			highestOf2 = Math.max(Math.max(highest*current, highestOf2), current*lowest);
			lowestOf2=Math.max(Math.min(lowestOf2, current*highest), current*lowest);
			highest=Math.max(highest, current);
			lowest=Math.min(lowest, current);
			
		}
		
		return highestOf3;
	}
}

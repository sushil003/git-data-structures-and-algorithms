package interviewcake;
/**
 * 
 * @author Sushil
 *
 */
public class CharSwap {

	public static void main(String[] args) {

		char[] inputchar=new char[]{'p','e','n','t','a','g','o','n'};
		char[] outputchar=swapChar(inputchar);
		for(char temp: outputchar){
			System.out.println(temp+"\t");
		}
		
	}
	
	public static char[] swapChar(char[] inputchar) {
		
        int leftIndex=0;
        int rightIndex=inputchar.length-1;
        while(leftIndex<rightIndex){
        	char temchar=inputchar[leftIndex];
        	inputchar[leftIndex]=inputchar[rightIndex];
        	inputchar[rightIndex]=temchar;
        	leftIndex++;
        	rightIndex--;
        }
		return inputchar;
	}
	

}

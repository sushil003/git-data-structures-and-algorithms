package interviewcake;
/**
 * 
 * @author Sushil
 *
 */
public class ReverseWord {

	public static void main(String[] args) {

		char[] inputchar=new char[]{'c', 'a', 'k', 'e','s', ' ', 'p', 'o', 'u', 'n', 'd', ' ','s', 't', 'e', 'a', 'l'};
		reverseWords(inputchar);
		for(char temp: inputchar){
			System.out.println(temp+"\t");
		}
	}
	
	
	public static void reverseWords(char[] message) {
		
		reverseCharacters(message,0,message.length-1);
		int currentWordIndex=0;
		for(int i=0;i<=message.length;i++){
			if(i==message.length || message[i]==' ' ){
				reverseCharacters(message,currentWordIndex,i-1);
				currentWordIndex=i+1;
			}
		}
		
	}
	
	private static void reverseCharacters(char[] message, int leftIndex, int rightIndex) {

	    // walk towards the middle, from both sides
	    while (leftIndex < rightIndex) {

	        // swap the left char and right char
	        char temp = message[leftIndex];
	        message[leftIndex] = message[rightIndex];
	        message[rightIndex] = temp;
	        leftIndex++;
	        rightIndex--;
	    }

}
	}

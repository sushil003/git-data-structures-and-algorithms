package problems.practice;

public class ReverseWords {

	public static void main(String[] args) {

		char[] inputchar=new char[]{'c', 'a', 'k', 'e','s', ' ', 'p', 'o', 'u', 'n', 'd', ' ','s', 't', 'e', 'a', 'l'};
		reverseWords(inputchar);
		for(char temp: inputchar){
			System.out.println(temp+"\t");
		}
		
		System.out.println(reverseWordsUsingStringBuilder("i live in a house"));
		System.out.println(reverseWordsUsingSinglrStringBuilder("i live in a house"));
	}

	public static String reverseWordsUsingSinglrStringBuilder(String message) {

	    StringBuilder builder = new StringBuilder();

	    int wordEnd=message.length();
	    
	    for(int i=message.length()-1; i>=0;i--) {
	    	
	    	if(message.charAt(i)==' ') {
	    		builder.append(message.subSequence(i+1, wordEnd)).append(' ');
	    		wordEnd=i;
	    	}
	    }
        
	    String firstWord = message.substring(0,wordEnd);
	    
	   if(firstWord!=null && firstWord.length()>0) {
	    	 if(builder.length() > 0) {
	    		// builder.append(' ');
	    		 builder.append(firstWord);
	 	    }else {
	 	    	
	 	    	builder.append(firstWord);
	 	    }
	    }
	   
	   return builder.toString();
	
	}
	
	public static String reverseWordsUsingStringBuilder(String message) {

	    StringBuilder builder = new StringBuilder(message);
	   String[] tokens= builder.reverse().toString().split(" ");
	   StringBuilder resultBuilder = new StringBuilder();
	   for(String temp : tokens) {
		   StringBuilder tempBuilder = new StringBuilder(temp);
		   resultBuilder.append(tempBuilder.reverse().toString()+" ");
	   }
	   
	   return resultBuilder.toString();
	
	}

	
	public static void reverseWords(char[] message) {

		reverseCharacters(message,0,message.length-1);
		int start=0;
		int end =0;
		for(int i=0; i<=message.length;i++) {
			if(i==message.length || message[i]==' ') {
				end=i-1;
				reverseCharacters(message,start,end);
				start=i+1;
			}
		}
	
	}

	private static void reverseCharacters(char[] message, int leftIndex, int rightIndex) {

		while (leftIndex < rightIndex) {
			char temp = message[leftIndex];
			message[leftIndex] = message[rightIndex];
			message[rightIndex] = temp;
			leftIndex++;
			rightIndex--;
		}
	}
}

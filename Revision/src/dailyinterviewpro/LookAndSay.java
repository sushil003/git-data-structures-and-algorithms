package dailyinterviewpro;
/**
 * A look-and-say sequence is defined as the integer sequence beginning with a single digit in which the next term is obtained by describing the previous term. An example is easier to understand:

Each consecutive value describes the prior value.

1      #
11     # one 1's
21     # two 1's
1211   # one 2, and one 1.
111221 # #one 1, one 2, and two 1's.

Your task is, return the nth term of this sequence.
 * @author Sushil
 *
 */
public class LookAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String lookAndSay(int n) {

		  String s="1";
		  
		  for(int i=1; i<n; i++) {
			  s= getNextNumber(s);
		  }
		
		  return s;
	  }
	
	  private static String getNextNumber(String s) {

		  StringBuilder builder = new StringBuilder();
		  
		  for(int i=0; i<s.length();i++) {
			  
			  int count =1;
			  
			  while(i+1 <s.length() && s.charAt(i)==s.charAt(i+1)) {
				  ++i;
				  ++count;
			  }
			  
			  builder.append(count).append(s.charAt(i));
		  }
		  
		  return builder.toString();
	}
}

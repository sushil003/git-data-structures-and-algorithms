package interviewcamp.recursionandbacktracking;
import java.util.HashMap;
import java.util.Map;
public class Fibonacci {

	static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
  public static int fibonacci(int n) {

	  if(n<=1) {
		  return n;
	  }
	  
	  cache.putIfAbsent(n,fibonacci(n-1)+fibonacci(n-2));
	  
	  return cache.get(n);
  }

  public static void main(String[] args) {
   
  }
}

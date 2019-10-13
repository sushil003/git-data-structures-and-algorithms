package dailyinterviewpro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a list of words, group the words that are anagrams of each other. (An anagram are words made up of the same letters).

Example:

Input: ['abc', 'bcd', 'cba', 'cbd', 'efg']
Output: [['abc', 'cba'], ['bcd', 'cbd'], ['efg']]
 * @author Sushil
 *
 */
public class GroupWordsThatAreAnagrams {

	public static void main(String[] args) {
      
		List<String> dict = new ArrayList<>();
		
		dict.add("abc");
		dict.add("bcd");
		dict.add("cba");
		dict.add("cbd");
		dict.add("efg");
		
		System.out.println(findAnagrams(dict));
		
	}

	 public static List<List<String>> findAnagrams(List<String> dictionary) {
		 
		 Map<String, List<String>> map = new HashMap<>();
		 
		 for(String word : dictionary) {
			 
			 String sortedString = Stream.of(word.split("")).sorted().collect(Collectors.joining());
			 map.putIfAbsent(sortedString, new ArrayList<String>());
			 map.get(sortedString).add(word);
			 
		 }
		 
		 return map.values().stream().collect(Collectors.toList());

	 }

}

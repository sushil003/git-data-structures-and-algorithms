package problems.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

public class AnagramWords {

	public static void main(String[] args) {

		List<String> dict= new ArrayList<>();
		
		dict.add("dormitory");
		dict.add("cup");
		dict.add("more");
		dict.add("max");
		
		System.out.println("Without Java 8 : "+getAnagramWords(dict,"dirtyroom"));
		System.out.println("Using Java 8 : " +getAnagramWordsUsingJava8(dict,"dirtyroom"));
	}
	
	public static List<String> getAnagramWordsUsingJava8(List<String> dict, String word) {
		String sortedWord = Stream.of(word.split("")).sorted().collect(Collectors.joining());
		return dict.stream().filter(
				(item) -> sortedWord.equalsIgnoreCase(Stream.of(item.split("")).sorted().collect(Collectors.joining())))
				.collect(Collectors.toList());
	}

	public static List<String> getAnagramWords(List<String> dict,String word){
		List<String> anagramWords = new ArrayList<>();
		Set<Character> charSet = new HashSet<>();
		
		char[] wordCharArray = word.toCharArray();
		
		for(int i=0; i < wordCharArray.length ; i++) {
			charSet.add(wordCharArray[i]);
		}
		
		for(String s : dict) {
			if(isAnagram(s,charSet)) {
				anagramWords.add(s);
			}
		}
		
		return anagramWords;
	}
	
	private static boolean isAnagram(String s, Set<Character> charSet) {
		
		for(int i=0; i< s.length();i++) {
			
			if(!charSet.contains(s.charAt(i))) {
				return false;
			}
			
		}
		
		return true;
	}
}

package interviewcake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCloud {

	public static void main(String[] args) {

		WordCloudData cloudData=new WordCloudData();
		String inputString= "This is is best Best solution for Sushil Sushil";
		cloudData.populateWordsToCounts(inputString);
		for(Map.Entry<String, Integer> wordCountEntry : cloudData.getWordsToCounts().entrySet()){
			System.out.println("Count for word "+wordCountEntry.getKey()+" :"+wordCountEntry.getValue());
		}
	}
	
}

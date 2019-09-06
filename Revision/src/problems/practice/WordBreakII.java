package problems.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output: [ "cats and dog", "cat sand dog" ] Example 2:
 * 
 * Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen",
 * "pine", "pineapple"] Output: [ "pine apple pen apple", "pineapple pen apple",
 * "pine applepen apple" ] Explanation: Note that you are allowed to reuse a
 * dictionary word. Example 3:
 * 
 * Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: []
 * 
 * @author Sushil
 *
 */
public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
		Map<Integer, List<String>> map = new HashMap<>();
		return wordBreak(s, wordDictSet, map, 0);
	}

	private List<String> wordBreak(String s, Set<String> wordDictSet, Map<Integer, List<String>> map, int start) {

		LinkedList<String> l = new LinkedList<>();

		if (start == s.length()) {
			l.add("");
		}

		if (map.containsKey(start)) {
			return map.get(start);
		}

		for (int end = start + 1; end <= s.length(); end++) {

			if (wordDictSet.contains(s.substring(start, end))) {

				List<String> list = wordBreak(s, wordDictSet, map, end);

				for (String l1 : list) {
					l.add(s.substring(start, end) + (l1.equals("") ? "" : " ") + l1);
				}
			}
		}

		map.put(start, l);

		return l;

	}
}

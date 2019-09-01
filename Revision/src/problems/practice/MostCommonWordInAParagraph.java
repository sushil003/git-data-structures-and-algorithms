package problems.practice;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation. Words in the paragraph are not case sensitive. The answer is in
 * lowercase.
 * 
 * 
 * 
 * Example:
 * 
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"] Output: "ball" Explanation: "hit" occurs 3 times, but it is
 * a banned word. "ball" occurs twice (and no other word does), so it is the
 * most frequent non-banned word in the paragraph. Note that words in the
 * paragraph are not case sensitive, that punctuation is ignored (even if
 * adjacent to words, such as "ball,"), and that "hit" isn't the answer even
 * though it occurs more because it is banned.
 * 
 * @author Sushil
 *
 */
public class MostCommonWordInAParagraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String mostCommonWord(String paragraph, String[] banned) {

		paragraph = paragraph.replaceAll("\\p{Punct}", " ");
		String[] words = paragraph.toLowerCase().split(" ");
		Set<String> bannedSet = new HashSet<>();
		for (String ban : banned) {
			bannedSet.add(ban);
		}

		Map<String, Integer> wordCountMap = new TreeMap<>();

		String ans = "";
		int ansFreq = 0;

		for (String word : words) {

			if (word.isEmpty()) {
				continue;
			}

			if (!bannedSet.contains(word)) {
				wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
				if (wordCountMap.get(word) > ansFreq) {
					ans = word;
					ansFreq = wordCountMap.get(word);
				}
			}

		}

		return ans;
	}
}

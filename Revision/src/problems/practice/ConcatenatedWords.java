package problems.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of words (without duplicates), please write a program that
 * returns all concatenated words in the given list of words. A concatenated
 * word is defined as a string that is comprised entirely of at least two
 * shorter words in the given array.
 * 
 * Example: Input:
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; "ratcatdogcat"
 * can be concatenated by "rat", "cat", "dog" and "cat". Note: The number of
 * elements of the given array will not exceed 10,000 The length sum of elements
 * in the given array will not exceed 600,000. All the input string will only
 * include lower case letters. The returned elements order does not matter.
 * 
 * @author Sushil
 *
 */
public class ConcatenatedWords {

	class Trie {
		Trie[] array = new Trie[26];
		boolean isWord = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findAllConcatenatedWordsInADictUsingDP(String[] words) {

		Arrays.sort(words, (a, b) -> a.length() - b.length());

		List<String> result = new ArrayList<>();

		Set<String> set = new HashSet<>();

		for (int i = 0; i < words.length; i++) {

			if (wordBreak(words[i], set)) {

				result.add(words[i]);
			}

			set.add(words[i]);
		}

		return result;
	}

	private boolean wordBreak(String s, Set<String> set) {

		if (set.isEmpty()) {

			return false;
		}

		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

	public List<String> findAllConcatenatedWordsInADictUsingTrie(String[] words) {

		List<String> result = new ArrayList<>();

		if (words == null || words.length == 0) {
			return result;
		}

		Trie root = new Trie();

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > 0) {
				buildTrie(root, words[i]);
			}
		}

		for (int i = 0; i < words.length; i++) {

			if (search(words[i], root, 0, 0)) {
				result.add(words[i]);
			}
		}

		return result;
	}

	public boolean search(String word, Trie root, int begin, int num) {

		Trie current = root;

		for (int i = begin; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.array[index] == null) {
				return false;
			}
			current = current.array[index];
			if (current.isWord && search(word, root, i + 1, num + 1)) {
				return true;
			}
		}

		return num >= 1 && current.isWord;
	}

	public void buildTrie(Trie root, String s) {

		Trie current = root;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (current.array[index] == null) {
				current.array[index] = new Trie();
			}

			current = current.array[index];
		}

		current.isWord = true;
	}
}

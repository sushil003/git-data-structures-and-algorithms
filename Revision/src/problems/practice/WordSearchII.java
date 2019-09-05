package problems.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * Input: board = [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'],
 * ['i','f','l','v'] ] words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * @author Sushil
 *
 */
public class WordSearchII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findWords(char[][] board, String[] words) {

		TrieNode root = buildTrie(words);
		List<String> result = new ArrayList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, result, root);
			}
		}

		return result;
	}

	public void dfs(char[][] board, int i, int j, List<String> result, TrieNode p) {

		char c = board[i][j];

		if (c == '#' || p.next[c - 'a'] == null) {
			return;
		}

		p = p.next[c - 'a'];

		if (p.word != null) {
			result.add(p.word);
			p.word = null;
		}

		board[i][j] = '#';

		if (i > 0) {
			dfs(board, i - 1, j, result, p);
		}

		if (i < board.length - 1) {
			dfs(board, i + 1, j, result, p);
		}

		if (j > 0) {
			dfs(board, i, j - 1, result, p);
		}

		if (j < board[0].length - 1) {
			dfs(board, i, j + 1, result, p);
		}

		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {

		TrieNode root = new TrieNode();

		for (String word : words) {
			TrieNode p = root;
			for (char c : word.toCharArray()) {

				int i = c - 'a';
				if (p.next[i] == null) {
					p.next[i] = new TrieNode();
				}
				p = p.next[i];
			}
			p.word = word;
		}

		return root;
	}

	class TrieNode {

		TrieNode[] next = new TrieNode[26];
		String word;
	}
}

package problems.practice;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple"); trie.search("apple"); // returns true
 * trie.search("app"); // returns false trie.startsWith("app"); // returns true
 * trie.insert("app"); trie.search("app"); // returns true Note:
 * 
 * You may assume that all inputs are consist of lowercase letters a-z. All
 * inputs are guaranteed to be non-empty strings.
 * 
 * @author Sushil
 *
 */
class Trie {

	private static class TrieNode {

		public char c;

		public TrieNode[] links;

		public boolean isEnd;

		public TrieNode(char c) {
			this.c = c;
			this.links = new TrieNode[26];
		}

	}

	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode('$');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {

		TrieNode n = root;

		for (char c : word.toCharArray()) {
			if (n.links[c - 'a'] == null) {
				n.links[c - 'a'] = new TrieNode(c);
				n = n.links[c - 'a'];
			} else {
				n = n.links[c - 'a'];
			}
		}

		n.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode n = root;

		for (char c : word.toCharArray()) {
			if (n.links[c - 'a'] == null) {
				return false;
			} else {
				n = n.links[c - 'a'];
			}
		}

		return n.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode n = root;
		for (char c : prefix.toCharArray()) {
			if (n.links[c - 'a'] == null) {
				return false;
			} else {
				n = n.links[c - 'a'];
			}
		}

		return true;
	}
}

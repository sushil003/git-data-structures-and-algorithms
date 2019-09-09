package problems.practice;
/**
 * here is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

 * @author Sushil
 *
 */
public class AlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String alienOrder(String[] words) {

		if (words == null || words.length == 0) {
			return "";
		}

		if (words.length == 1) {
			return words[0];
		}

		boolean[][] graph = new boolean[26][26];

		// // mark existing letters
		for (String word : words) {
			for (char c : word.toCharArray()) {
				graph[c - 'a'][c - 'a'] = true;
			}
		}

		// build adjacent matrix

		int first = 0;
		int second = 1;

		while (second < words.length) {
			String s1 = words[first];
			String s2 = words[second];

			int minLen = Math.min(s1.length(), s2.length());

			for (int i = 0; i < minLen; i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					graph[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = true;
					break;
				}
			}

			first++;
			second++;
		}

		// Do topological sort

		boolean[] path = new boolean[26];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			if (!dfs(graph, sb, i, path)) {
				return "";
			}
		}

		for (int i = 0; i < 26; i++) {

			if (graph[i][i]) {
				sb.append((char) (i + 'a'));
			}
		}

		return sb.reverse().toString();
	}

	/** Do DFS to do topological sort. Return false for invalid input. */
	public boolean dfs(boolean[][] graph, StringBuilder sb, int index, boolean[] path) {
		// visited or non-existing letter
		if (!graph[index][index]) {
			return true;
		}
		// track letters in the dfs path for detecting if DAG or not
		path[index] = true;

		for (int i = 0; i < 26; i++) {
			if (i == index || !graph[index][i]) {
				continue;
			}
			// cyclic path (non-DAG)
			if (path[i]) {
				return false;
			}
			if (!dfs(graph, sb, i, path)) {
				return false;
			}
		}
		path[index] = false;
		graph[index][index] = false;
		sb.append((char) (index + 'a'));
		return true;
	}
}

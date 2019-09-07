package problems.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. Note:
 * 
 * Return an empty list if there is no such transformation sequence. All words
 * have the same length. All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list. You may assume beginWord and
 * endWord are non-empty and are not the same. Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 * Example 2:
 * 
 * Input: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"]
 * 
 * Output: []
 * 	
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * @author Sushil
 *
 */
public class WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<List<String>> queue = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.offer(list);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            HashSet<String> removed = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> cur = queue.poll();
                String lastWord = cur.get(cur.size() - 1);
                for (int j = 0; j < lastWord.length(); j++) {
                    char[] array = lastWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        array[j] = ch;
                        String next = new String(array);
                        if (set.contains(next)) {
                            removed.add(next);
                            cur.add(next);
                            queue.offer(new ArrayList<>(cur));
                            cur.remove(cur.size() - 1);
                        }
                    }
                }
            }
            if (removed.contains(endWord)) {
                break;
            }
            for (String s : removed) {
                set.remove(s);
            }
        }
        List<List<String>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            list = queue.poll();
            String last = list.get(list.size() - 1);
            if (last.equals(endWord)) {
                result.add(list);
            }
        }
        return result;
    }
}

package problems.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author Sushil
 *
 */
public class AutocompleteSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TrieNode {
        TrieNode[] next;
        Map<String, Integer> wordCount;
        
        TrieNode() {
            next = new TrieNode[130];
            wordCount = new HashMap<>();    
        }
    }
    
    TrieNode root;
    String buffer; 
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        buildTrie(sentences, times);
        buffer = "";
    }
    
    public List<String> input(char input_c) {
        if (input_c=='#') {
            addWord(buffer, 1);
            buffer = "";
            return new ArrayList<>();
        }
           
        buffer = buffer + input_c;
        TrieNode cur = root;
        for (char c: buffer.toCharArray()) {  
            TrieNode next = cur.next[c];
			//if prefix ! exist in Trie, stop and return empty [] directly
            if ( next == null) return new ArrayList<>();   
            cur = next;
        }     
		 //..... walk to the end of prefix 
        return get_top_3(cur.wordCount);    
    }
    
    List<String> get_top_3(Map<String, Integer> counts ) {
	
	    //sort map 1. word's frequency -> 2.  by lexi order (using String compareTo)
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
             (a, b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : 
                        b.getValue() - a.getValue()));
        pq.addAll(counts.entrySet());
        
        List<String> res = new ArrayList<>();
        int k = 0;
		
		//pull element based on priority, make sure pq is not empty yet
        while (k < 3 && ! pq.isEmpty()) {   
            Map.Entry<String, Integer> e = pq.poll();
            res.add(e.getKey());
            k++;
        }
        return res;
    }
    
    void buildTrie(String[] sentences, int[] times) {
        for (int i=0; i<sentences.length; i++) {
            addWord(sentences[i], times[i]);
        }
    }
    
    void addWord(String s, int new_count) {
        TrieNode cur = root;
        for (char c: s.toCharArray()) {
            if (cur.next[c] == null) {
                cur.next[c] = new TrieNode();
            }
            cur = cur.next[c];
            int cur_count = cur.wordCount.getOrDefault(s, 0);
            cur.wordCount.put(s, cur_count + new_count);
        }
    }
    
}

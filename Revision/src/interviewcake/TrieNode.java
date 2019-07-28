package interviewcake;

import java.util.HashMap;

/**
 * 
 * @author Sushil
 *
 */
public class TrieNode {

	private HashMap<Character, TrieNode> nodeChildren;

    public TrieNode() {
        this.nodeChildren = new HashMap<>();
    }

    public boolean hasChildNode(char character) {
        return this.nodeChildren.containsKey(character);
    }

    public void makeChildNode(char character) {
        this.nodeChildren.put(character, new TrieNode());
    }

    public TrieNode getChildNode(char character) {
        return this.nodeChildren.get(character);
    }
}

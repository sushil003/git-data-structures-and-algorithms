package problems.practice;

import basicdatastructures.TreeNode;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 * @author Sushil
 *
 */
public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
    // preorder traversal
	public boolean isSubtree(TreeNode s, TreeNode t) {

		String tree1 = preorder(s, true);
		String tree2 = preorder(t, true);

		return tree1.indexOf(tree2) >= 0;
	}

	private String preorder(TreeNode node, boolean left) {

		if (node == null && left) {
			return "lnull";
		} else if (node == null && !left) {
			return "rnull";
		}

		return "#" + node.val + " " + preorder(node.left, true) + " " + preorder(node.right, false);
	}
}

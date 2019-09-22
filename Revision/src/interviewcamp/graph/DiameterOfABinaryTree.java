package interviewcamp.graph;

import basicdatastructures.TreeNode;

/**
 * The diameter of a tree (sometimes called the width) is the number of nodes on
 * the longest path between two end nodes. The diagram below shows two trees
 * each with diameter nine, the leaves that form the ends of a longest path are
 * shaded (note that there is more than one path in each tree of length nine,
 * but no path longer than nine nodes).
 * 
 * @author Sushil
 *
 */
public class DiameterOfABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int diameter(TreeNode root) {
		
		/* base case if tree is empty */
		if(root==null) {
			return 0;
		}
		
		/* get the height of left and right sub trees */
		int leftH = depth(root.left);
		int rightH = depth(root.right);
		
		/* get the diameter of left and right subtrees */
		int leftDia= diameter(root.left);
		int rightDia = diameter(root.right);
		
		/* Return max of following three 
        1) Diameter of left subtree 
       2) Diameter of right subtree 
       3) Height of left subtree + height of right subtree + 1 */
		return Math.max(leftH+rightH+1, Math.max(leftDia, rightDia));
		
	}
	
	private int depth(TreeNode root) {
		if(root==null) {
			return 0;
			
		}
		return 1+ Math.max(depth(root.left), depth(root.right));
	}
}

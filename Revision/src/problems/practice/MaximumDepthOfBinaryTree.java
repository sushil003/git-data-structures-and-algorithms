package problems.practice;

import java.util.ArrayDeque;
import java.util.Deque;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

 * @author Sushil
 *
 */
public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int maxDepthBFS(TreeNode root) {
	      if(root==null){
	          return 0;
	      }
	        int depth=0;
	         Deque<TreeNode> bfsQueue = new ArrayDeque<>();
			 TreeNode node = root;
	         bfsQueue.add(node);
	         while(!bfsQueue.isEmpty()){
	             int currSize = bfsQueue.size();
	             for(int i=0; i<currSize;i++){
	                 node = bfsQueue.remove();
	                 if(node.left!=null){
	                     bfsQueue.add(node.left);
	                 }
	                 if(node.right!=null){
	                     bfsQueue.add(node.right);
	                 }
	             }
	            
	             depth++;
	             
	         }
	         
	         return depth;
	    }
	
	public int maxDepthDFS(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftMax = maxDepthDFS(root.left);
			int rightMax = maxDepthDFS(root.right);
			return Math.max(leftMax, rightMax) + 1;
		}

	}
}

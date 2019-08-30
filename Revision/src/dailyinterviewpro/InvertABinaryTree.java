package dailyinterviewpro;

import java.util.ArrayDeque;
import java.util.Deque;

import basicdatastructures.TreeNode;

/**
 * ou are given the root of a binary tree. Invert the binary tree in place. That is, all left children should become right children, and all right children should become left children.

Example:

    a
   / \
  b   c
 / \  /
d   e f

The inverted version of this tree is as follows:

  a
 / \
 c  b
 \  / \
  f e  d

 * @author Sushil
 *
 */
public class InvertABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
	    if (root == null) {
	        return null;
	    }
	    TreeNode right = invertTree(root.right);
	    TreeNode left = invertTree(root.left);
	    root.left = right;
	    root.right = left;
	    return root;
	}
	
	 public TreeNode invertTreeDFS(TreeNode root) {
	     
	        if(root==null){
	            return root;
	        }
	        
	        Deque<TreeNode> queue = new ArrayDeque<>();
	        queue.add(root);
	        
	        while(!queue.isEmpty()){
	          
	            TreeNode node = queue.remove();
	            TreeNode temp = node.left;
	            node.left=node.right;
	            node.right=temp;
	            if(node.left!=null){
	                queue.add(node.left); 
	            }
	             if(node.right!=null){
	                queue.add(node.right); 
	            }
	        }
	       return root;
	    }
}

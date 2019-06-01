package problems.practice;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

 * @author sushi
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {

		
	}

	 private static class BalancedStatusWithHeight{
	        int height;
	        boolean balanced;
	        
	       BalancedStatusWithHeight(int height,boolean balanced){
	           this.height = height;
	           this.balanced = balanced;
	       } 
	    }
	    
	    public boolean isBalanced(TreeNode root) {
	        return checkedBalanced(root).balanced;
	    }
	    
	    private BalancedStatusWithHeight checkedBalanced (TreeNode root){
	        
	        if(root==null){
	            return new BalancedStatusWithHeight(-1,true);
	        }
	        
	        BalancedStatusWithHeight leftResult =checkedBalanced(root.left);
	        
	        if(!leftResult.balanced){
	            return leftResult;
	        }
	        
	         BalancedStatusWithHeight rightResult =checkedBalanced(root.right);
	        
	        if(!rightResult.balanced){
	            return rightResult;
	        }
	        
	        int height = Math.max(leftResult.height,rightResult.height)+1;
	        boolean balanced = Math.abs(leftResult.height-rightResult.height)<=1;
	        
	        return new BalancedStatusWithHeight(height,balanced);
	        
	    }
}

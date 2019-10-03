package dailyinterviewpro;

import basicdatastructures.TreeNode;

/**
 * You are given the root of a binary search tree. Return true if it is a valid
 * binary search tree, and false otherwise. Recall that a binary search tree has
 * the property that all values in the left subtree are less than or equal to
 * the root, and all values in the right subtree are greater than or equal to
 * the root.
 * 
 * @author Sushil
 *
 */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {

		
	}

	
	 public boolean isValidBST(TreeNode root) {
		 
	      return helper(root, null, null);
	  }
	    

	 public boolean helper(TreeNode node, Integer lower,Integer upper){
	     
	     if(node==null){
	         return true;
	     }
	     
	     int val = node.val;
	     
	     if(lower !=null && val <=lower){
	         
	         return false;
	     }
	     
	     if(upper!=null && val >= upper){
	         
	         return false;
	     }
	     
	     if(!(helper(node.right,val,upper))){
	         return false;
	     }
	     
	     if(!(helper(node.left,lower,val))){
	         return false;
	     }
	     
	     return true;
	 }
}

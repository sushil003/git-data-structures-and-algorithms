package problems.practice;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 * @author sushi
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public boolean isSymmetric(TreeNode root) {
	        
	        return root==null || isSymmetric(root.left,root.right);
	    }
	    
	    private boolean isSymmetric(TreeNode subRoot0,TreeNode subRoot1){
	        
	        if(subRoot0 ==null && subRoot1==null){
	          
	            return true;
	        }
	        
	        if(subRoot0!=null && subRoot1!=null){
	          
	            return subRoot0.val == subRoot1.val &&
	                isSymmetric(subRoot0.left,subRoot1.right) &&
	                isSymmetric(subRoot0.right,subRoot1.left);
	        }   
	        
	        return false;
	}
}

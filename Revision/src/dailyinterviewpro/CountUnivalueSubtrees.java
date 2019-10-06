package dailyinterviewpro;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
 * @author Sushil
 *
 */
public class CountUnivalueSubtrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 int count=0;
	    
	    public int countUnivalSubtrees(TreeNode root) {
	       
	        if(root==null){
	            return 0;
	        }
	        
	        isUniVal(root);
	        
	        return count;
	        
	    }
	    
	    private boolean isUniVal(TreeNode node){
	        
	        if(node.left==null && node.right==null){
	            count++;
	            return true;
	        }
	        
	        boolean isUniVal = true;
	        
	        if(node.left!=null){
	            
	            isUniVal = isUniVal(node.left) && isUniVal && node.val==node.left.val;
	            
	        }
	        
	        if(node.right!=null){
	            isUniVal = isUniVal(node.right) && isUniVal && node.val==node.right.val;
	        }
	        
	        if(!isUniVal){
	            return false;
	        }
	        
	        count++;
	        
	        return true;
	    }
}

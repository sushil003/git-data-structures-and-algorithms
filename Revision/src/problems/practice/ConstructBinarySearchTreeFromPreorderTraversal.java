package problems.practice;

import java.util.Arrays;
import java.util.HashMap;

import basicdatastructures.TreeNode;

/**
 * Return the root node of a binary search tree that matches the given preorder
 * traversal.
 * 
 * (Recall that a binary search tree is a binary tree where for every node, any
 * descendant of node.left has a value < node.val, and any descendant of
 * node.right has a value > node.val. Also recall that a preorder traversal
 * displays the value of the node first, then traverses node.left, then
 * traverses node.right.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [8,5,1,7,10,12] Output: [8,5,10,1,7,null,12]
 * 
 * 
 * 
 * Note:
 * 
 * 1 <= preorder.length <= 100 The values of preorder are distinct.
 * 
 * @author Sushil
 *
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

	int[] preorder;

	int pre_idx = 0;

	HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public TreeNode bstFromPreorder(int[] preorder) {
	        
	        this.preorder = preorder;
	      
	        int[] inorder = Arrays.copyOf(preorder,preorder.length);
	        
	        Arrays.sort(inorder);
	       
	        int idx=0;
	        
	        for(int in : inorder){
	         
	            map.put(in,idx++);
	        }
	        
	        return helper(0,inorder.length);
	        
	    }
	    
	    public TreeNode helper(int in_left,int in_right){
	        
	        if(in_left==in_right){
	            return null;
	        }
	        
	        int root_val = preorder[pre_idx];
	        
	        TreeNode root = new TreeNode(root_val);
	        
	        pre_idx++;
	        
	        int index = map.get(root_val);
	        
	        root.left = helper(in_left,index);
	        root.right = helper(index+1,in_right);
	        
	        return root;
	    }
}

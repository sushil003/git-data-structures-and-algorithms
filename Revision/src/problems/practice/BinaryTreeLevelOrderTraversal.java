package problems.practice;

import java.util.ArrayList;
import java.util.List;

import basicdatastructures.TreeNode;

/**
 * 
 * @author Sushil
 *
 */
public class BinaryTreeLevelOrderTraversal {

	List<List<Integer>> levels = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<List<Integer>> levelOrderDFS(TreeNode root) {
	       if(root==null){
	          return levels; 
	       }
	         helper(root,0);
	        
	        return levels;
	    }
	    
	    private void helper(TreeNode root,int level){
	        
	        if(levels.size()==level){
	            levels.add(new ArrayList<Integer>());
	        }
	        
	        levels.get(level).add(root.val);
	        
	        if(root.left!=null){
	            helper(root.left,level+1);
	        }
	        
	         if(root.right!=null){
	            helper(root.right,level+1);
	        }
	    }
	
}

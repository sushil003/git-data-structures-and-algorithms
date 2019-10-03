package dailyinterviewpro;

import java.util.ArrayDeque;
import java.util.Deque;

import basicdatastructures.TreeNode;

/**
 * You are given the root of a binary tree. Return the deepest node (the
 * furthest node from the root).
 * 
 * @author Sushil
 *
 */
public class DeepestNodeInABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int maxDepth(TreeNode root) {
	     
         if(root==null){
             return 0;
         }
         
         int left = maxDepth(root.left);
         int right = maxDepth(root.right);
         
         return 1+ Math.max(left,right);
    }
	
	 
	 public int maxDepthUsingBFS(TreeNode root) {
	     
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
	 
}

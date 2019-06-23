package problems.practice;

import java.util.ArrayDeque;
import java.util.Deque;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author Sushil
 *
 */
public class BinaryTreehasPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPathSumResucrsive(TreeNode root, int sum) {
	       

		if(root==null) {
			return false;
		}
		
		sum-=root.val;
		
		if(root.left==null && root.right==null) {
			return sum==0;
		}
		
		return hasPathSumResucrsive(root.left,sum) || hasPathSumResucrsive(root.right,sum);
        
    }
	
	public boolean hasPathSumIterative(TreeNode root, int sum) {
	       
		  if(root==null){
	            return false;
	        }
	        
	        Deque<TreeNode> nodeStack = new ArrayDeque<>();
	        Deque<Integer> sumStack = new ArrayDeque<>();
	        nodeStack.push(root);
	        sumStack.push(sum-root.val);
	        
	        TreeNode node;
	        
	        int currSum;
	        
	        while(!nodeStack.isEmpty()){
	            node = nodeStack.pop();
	            currSum= sumStack.pop();
	            
	            if(node.left==null && node.right==null && currSum==0){
	                return true;
	            }
	            
	            if(node.left!=null){
	                nodeStack.push(node.left);
	                sumStack.push(currSum-node.left.val);
	            }
	            
	             
	            if(node.right!=null){
	                nodeStack.push(node.right);
	                sumStack.push(currSum-node.right.val);
	            }
	        }
	        
	        return false;
        
    }
}

package problems.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 * @author Sushil
 *
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<Integer> inorderTraversalIterative(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        Stack<TreeNode> stack = new Stack<>();
	        TreeNode curr= root;
	        
	        while(curr!=null || !stack.isEmpty()){
	            
	            while(curr!=null){
	                stack.push(curr);
	                curr=curr.left;
	            }
	            
	            curr = stack.pop();
	            result.add(curr.val);
	            curr=curr.right;
	        }
	        
	        return result;
	    }
	
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<>();

		inorder(root, result);

		return result;

	}

	private void inorder(TreeNode root, List<Integer> result) {

		if (root == null) {
			return;
		}

		inorder(root.left, result);
		result.add(root.val);
		inorder(root.right, result);
	}
}

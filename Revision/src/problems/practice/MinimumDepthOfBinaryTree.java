package problems.practice;

import java.util.ArrayDeque;
import java.util.Deque;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

 * @author Sushil
 *
 */
public class MinimumDepthOfBinaryTree {
	
	private static class MinDep{
		TreeNode miNode;
		
		int mindep;
		
		MinDep(TreeNode minNode,int mindep){
			this.mindep=mindep;
			this.miNode=minNode;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepthBFS(TreeNode root) {

		if(root==null) {
			return 0;
		}
		Deque<MinDep> deque =new ArrayDeque<>();
		deque.add(new MinDep(root, 1));
		int currMinDepth =0;
		while(!deque.isEmpty()) {
			
			MinDep minDep= deque.remove();
			TreeNode currNode = minDep.miNode;
			currMinDepth = minDep.mindep;
			if(currNode.left==null && currNode.right==null) {
				break;
			}
			
			if(currNode.left!=null) {
				deque.add(new MinDep(currNode.left, currMinDepth+1));
			}
			
			if(currNode.right!=null) {
				deque.add(new MinDep(currNode.right, currMinDepth+1));
			}
			
		}
		
		return currMinDepth;
	}
	
	public int minDepthDFS(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int minDepth = Integer.MAX_VALUE;

		if (root.left != null) {
			minDepth = Math.min(minDepthDFS(root.left), minDepth);
		}

		if (root.right != null) {
			minDepth = Math.min(minDepthDFS(root.right), minDepth);
		}

		return minDepth + 1;
	}
}

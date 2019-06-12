package problems.practice;

import java.util.ArrayDeque;
import java.util.Deque;

import basicdatastructures.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 * @author Sushil
 *
 */
public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		} else {
			return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
		}
	}
	
	
	public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		
		if(!check(p,q)) {
			return false;
		}
		
		Deque<TreeNode> deqP = new ArrayDeque<>();
		Deque<TreeNode> deqQ = new ArrayDeque<>();
        
		deqP.addLast(p);
		deqQ.addLast(q);
		
		while(!deqP.isEmpty()) {
			TreeNode pNode = deqP.removeFirst();
			TreeNode qNode = deqQ.removeFirst();
			
			if(!check(pNode, qNode)) {
				return false;
			}
			
			if(pNode!=null) {
				if(!check(pNode.left, qNode.left)) {
					return false;
				}
				if(pNode.left!=null) {
					deqP.add(pNode.left);
					deqQ.add(qNode.left);
				}
				
				if(!check(pNode.right, qNode.right)) {
					return false;
				}
				
				if(pNode.right!=null) {
					deqP.add(pNode.right);
					deqQ.add(qNode.right);
				}
			}
		}
		
		return true;
	}
	
	private boolean check(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return true;
	}
	
}

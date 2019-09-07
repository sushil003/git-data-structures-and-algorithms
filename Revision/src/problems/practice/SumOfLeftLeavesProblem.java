package problems.practice;

import basicdatastructures.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
 * @author Sushil
 *
 */
public class SumOfLeftLeavesProblem {

	int sum = 0;
	int sum_leafs=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return sum_leafs;
		}
		isLeftLeaf(root.left, true);
		isLeftLeaf(root.right, false);
		return sum_leafs;
	}

	public void isLeftLeaf(TreeNode root, boolean if_left_leaf) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null && if_left_leaf) {
			sum_leafs += root.val;
			return;
		}
		isLeftLeaf(root.left, true);
		isLeftLeaf(root.right, false);
	}

	public int sumOfLeftLeaves1(TreeNode root) {

		if (root == null) {
			return 0;
		}
		helper(root);
		return sum;
	}

	public void helper(TreeNode node) {

		if (node == null) {
			return;
		}

		if (node.left != null && (node.left.left == null && node.left.right == null)) {
			sum += node.left.val;
		}

		helper(node.left);
		helper(node.right);
	}
}

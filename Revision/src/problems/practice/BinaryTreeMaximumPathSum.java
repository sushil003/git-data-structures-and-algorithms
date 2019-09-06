package problems.practice;

import basicdatastructures.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 * @author Sushil
 *
 */
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		maxGain(root);

		return maxSum;
	}

	private int maxGain(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftGain = Math.max(maxGain(root.left), 0);
		int rightGain = Math.max(maxGain(root.right), 0);

		int newPathSum = root.val + leftGain + rightGain;

		maxSum = Math.max(maxSum, newPathSum);

		return root.val + Math.max(leftGain, rightGain);
	}
}

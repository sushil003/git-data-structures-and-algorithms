package problems.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author Sushil
 *
 */
public class BinaryTreePathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> paths = new ArrayList();

		if (root == null) {
			return paths;
		}

		Deque<TreeNode> qNodes = new ArrayDeque<>();
		Deque<Integer> qSum = new ArrayDeque<>();
		Deque<List<Integer>> qLists = new ArrayDeque<>();

		qNodes.add(root);
		qSum.add(sum);
		qLists.add(new LinkedList<>());

		while (!qNodes.isEmpty()) {
			TreeNode node = qNodes.remove();
			int currSum = qSum.remove();
			List<Integer> currList = qLists.remove();
			currList.add(node.val);

			if (node.left == null && node.right == null && node.val == currSum) {
				paths.add(new LinkedList<>(currList));
			}

			if (node.left != null) {
				qNodes.add(node.left);
				qSum.add(currSum - node.val);
				qLists.add(new LinkedList<>(currList));
			}

			if (node.right != null) {
				qNodes.add(node.right);
				qSum.add(currSum - node.val);
				qLists.add(new LinkedList<>(currList));
			}
		}

		return paths;

	}

	public List<List<Integer>> pathSumRecursive(TreeNode root, int sum) {

		List<List<Integer>> paths = new ArrayList();

		pathSum(root, paths, new LinkedList(), sum, 0);

		return paths;

	}

	public void pathSum(TreeNode root, List<List<Integer>> paths, Deque<Integer> path, int sum, int pathSum) {

		if (root == null) {
			return;
		}

		path.addLast(root.val);

		int currSum = pathSum + root.val;

		if (root.left == null && root.right == null && currSum == sum) {
			paths.add(new ArrayList(path));
		}
		pathSum(root.left, paths, path, sum, currSum);
		pathSum(root.right, paths, path, sum, currSum);
		path.removeLast();
	}
}

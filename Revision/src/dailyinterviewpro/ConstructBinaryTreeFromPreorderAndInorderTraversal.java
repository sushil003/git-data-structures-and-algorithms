package dailyinterviewpro;

import java.util.HashMap;

import basicdatastructures.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 * @author Sushil
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] preorder;

	int pre_idx = 0;

	HashMap<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		this.preorder = preorder;
		int in_idx = 0;

		for (int in : inorder) {

			map.put(in, in_idx++);
		}

		return helper(0, inorder.length);
	}

	private TreeNode helper(int in_left, int in_right) {

		if (in_left == in_right) {
			return null;
		}

		int rootVal = preorder[pre_idx];
		pre_idx++;

		TreeNode root = new TreeNode(rootVal);

		int index = map.get(rootVal);

		root.left = helper(in_left, index);
		root.right = helper(index + 1, in_right);

		return root;
	}
}

package problems.practice;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * Example 1:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3. Example 2:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * Note:
 * 
 * All of the nodes' values will be unique. p and q are different and both
 * values will exist in the binary tree.
 * 
 * @author sushi
 *
 */
public class LowestCommonAncestorOfABinaryTree {

	private static class Status {

		int numOfNodes;
		TreeNode anc;

		Status(int numOfNodes, TreeNode anc) {
			this.numOfNodes = numOfNodes;
			this.anc = anc;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		return fincLCA(root, p, q).anc;
	}

	private Status fincLCA(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return new Status(0, null);
		}

		Status leftResult = fincLCA(root.left, p, q);

		if (leftResult.numOfNodes == 2) {
			return leftResult;
		}

		Status rightResult = fincLCA(root.right, p, q);

		if (rightResult.numOfNodes == 2) {
			return rightResult;
		}

		int numOfNodes = leftResult.numOfNodes + rightResult.numOfNodes + (root == p ? 1 : 0) + (root == q ? 1 : 0);

		return new Status(numOfNodes, numOfNodes == 2 ? root : null);

	}
}

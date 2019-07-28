package interviewcake;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * We do a depth-first walk through the tree, testing each node for validity as
 * we go. If a node appears in the left subtree of an ancestor, it must be less
 * than that ancestor. If a node appears in the right subtree of an ancestor, it
 * must be greater than that ancestor.
 * 
 * Instead of keeping track of every ancestor to check these inequalities, we
 * just check the largest number it must be greater than (its lowerBound) and
 * the smallest number it must be less than (its upperBound).
 * 
 * Checking if an in-order traversal of the tree is sorted is a great answer
 * too, especially if you're able to implement it without storing a full list of
 * nodes.
 * 
 * @author Sushil
 *
 */
public class BinarySearchTreeChecker {

	private static class NodeBounds {

		BinaryTreeNode node;
		int lowerBound;
		int upperBound;

		NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound) {
			this.node = node;
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
	/**
	 * Using recursion
	 * @param root
	 * @return
	 */
	public static boolean isBinarySearchTree(BinaryTreeNode root) {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBinarySearchTree(BinaryTreeNode root, int lowerBound, int upperBound) {
		if (root == null) {
			return true;
		}

		if (root.value >= upperBound || root.value <= lowerBound) {
			return false;
		}

		return isBinarySearchTree(root.left, lowerBound, root.value)
				&& isBinarySearchTree(root.right, root.value, upperBound);
	}
    
	/**
	 * Using DFS
	 * @param root
	 * @return
	 */
	public static boolean isBinarySearchTree1(BinaryTreeNode root) {

		// start at the root, with an arbitrarily low lower bound
		// and an arbitrarily high upper bound
		Deque<NodeBounds> nodeAndBoundsStack = new ArrayDeque<>();
		nodeAndBoundsStack.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		// depth-first traversal
		while (!nodeAndBoundsStack.isEmpty()) {
			NodeBounds nb = nodeAndBoundsStack.pop();
			BinaryTreeNode node = nb.node;
			int lowerBound = nb.lowerBound;
			int upperBound = nb.upperBound;

			// if this node is invalid, we return false right away
			if (node.value <= lowerBound || node.value >= upperBound) {
				return false;
			}

			if (node.left != null) {
				// this node must be less than the current node
				nodeAndBoundsStack.push(new NodeBounds(node.left, lowerBound, node.value));
			}
			if (node.right != null) {
				// this node must be greater than the current node
				nodeAndBoundsStack.push(new NodeBounds(node.right, node.value, upperBound));
			}
		}

		// if none of the nodes were invalid, return true
		// (at this point we have checked all nodes)
		return true;
	}
}

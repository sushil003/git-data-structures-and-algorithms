package interviewcake;

/**
 * Write a method to find the 2nd largest element in a binary search tree.
 * 
 * @author Sushil
 *
 */
public class SecondLargestElementInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int findLargest(BinaryTreeNode rootNode) {
		BinaryTreeNode current = rootNode;
		while (current.right != null) {
			current = current.right;
		}
		return current.value;
	}

	/**
	 * If we have a left subtree but not a right subtree, then the current node is
	 * the largest overall (the "rightmost") node. The second largest element must
	 * be the largest element in the left subtree. We use our findLargest() method
	 * above to find the largest in that left subtree! 
	 * 
	 * If we have a right child, but that right child node doesn't have any children, then the right child must be
	 * the largest element and our current node must be the second largest element!
	 * 
	 * Else,
	 * we have a right subtree with more than one element, so the largest and
	 * second largest are somewhere in that subtree. So we step right.
	 * 
	 * @param rootNode
	 * @return
	 */
	public static int findSecondLargest(BinaryTreeNode rootNode) {
		if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
			throw new IllegalArgumentException("Tree must have at least 2 nodes");
		}

		BinaryTreeNode current = rootNode;

		while (true) {

			// case: current is largest and has a left subtree
			// 2nd largest is the largest in that subtree
			if (current.left != null && current.right == null) {
				return findLargest(current.left);
			}

			// case: current is parent of largest, and largest has no children,
			// so current is 2nd largest
			if (current.right != null && current.right.left == null && current.right.right == null) {
				return current.value;
			}

			current = current.right;
		}
	}
}

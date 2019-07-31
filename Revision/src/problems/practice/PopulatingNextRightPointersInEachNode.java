package problems.practice;

import java.util.ArrayDeque;
import java.util.Deque;

import basicdatastructures.Node;

/**
 * 
 * @author Sushil
 *
 */
public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node connect(Node root) {

		if (root == null)
			return root;
		if (root.right != null) {
			if (root.next != null) {
				connectNext(root.right, root.next);
			}
		}
		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			} else if (root.next != null) {
				connectNext(root.left, root.next);
			}
		}
		connect(root.right);
		connect(root.left);
		return root;
	}

	public void connectNext(Node node, Node next) {
		if (next.left != null) {
			node.next = next.left;
		} else if (next.right != null) {
			node.next = next.right;
		} else {
			node.next = null;
		}
	}

	public Node connectBFS(Node root) {

		if (root == null) {
			return root;
		}
		Deque<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node n = queue.poll();
				if (i < size - 1) {
					n.next = queue.peek();
				}
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
		}

		return root;
	}

	public Node connectDFS(Node root) {
		if (root == null) {
			return root;
		}
		if (root.left != null && root.right != null) {
			root.left.next = root.right;
		}
		if (root.right != null && root.next != null) {
			root.right.next = root.next.left;
		}
		connectDFS(root.left);
		connectDFS(root.right);
		return root;
	}
}

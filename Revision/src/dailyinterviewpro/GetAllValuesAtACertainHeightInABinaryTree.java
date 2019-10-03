package dailyinterviewpro;
/**
 * Given a binary tree, return all values given a certain height h.
 * @author Sushil
 *
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import basicdatastructures.TreeNode;

public class GetAllValuesAtACertainHeightInABinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(7);
		
		List<Integer> result = getAllValuesAtHeight(root,3);
		
		System.out.println(result);
	}

	public static List<Integer> getAllValuesAtHeight(TreeNode root, int height){
		List<Integer> result = new ArrayList<>();
		
		Deque<TreeNode> queue = new ArrayDeque<>();
		
		queue.add(root);
		int count =1;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			if(count==height) {
				while(!queue.isEmpty()) {
					result.add(queue.remove().val);
				}
				
				break;
			}
			
			for(int i=0; i<size;i++) {
				
				TreeNode node = queue.remove();
				
				if(node.left!=null) {
					queue.add(node.left);
				}
				
				if(node.right!=null) {
					queue.add(node.right);
				}
				
			}
			count++;
		}
		
		return result;
	}
}

package dailyinterviewpro;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import basicdatastructures.TreeNode;

/**
 * Given an integer k and a binary search tree, find the floor (less than or
 * equal to) of k, and the ceiling (larger than or equal to) of k. If either
 * does not exist, then print them as None.
 * 
 * @author Sushil
 *
 */
public class FloorAndCeilingOfBinarySearchTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(8);
		root.left=new TreeNode(4);
		root.left.left= new TreeNode(2);
		root.left.right= new TreeNode(6);
		root.right=new TreeNode(12);
		root.right.left=new TreeNode(10);
		root.right.right=new TreeNode(14);
		int[] flooeCeiling= {0,0};
		findCeilingFloor(flooeCeiling,root,9);
		int[] flooeCeilingDFS= {0,0};
		 int floor=Integer.MIN_VALUE;
		  int ceil =Integer.MAX_VALUE;
		  flooeCeilingDFS[0]=floor;
		  flooeCeilingDFS[1]=ceil;
		findCeilingFloorDFS(flooeCeilingDFS,root,9);
		System.out.println(Arrays.toString(flooeCeiling));
		System.out.println(Arrays.toString(flooeCeilingDFS));
	}

  public static void findCeilingFloor(int[] result,TreeNode root,int k) {
	  
	  Deque<TreeNode> queue = new ArrayDeque<>();
	  queue.add(root);
	  int floor=Integer.MIN_VALUE;
	  int ceil =Integer.MAX_VALUE;
	  
	  while(!queue.isEmpty()) {
		  TreeNode node=null;
			  node = queue.remove(); 
			  if(node.val>=k) {
				  ceil= Math.min(ceil, node.val);
			  }
			  if(node.val<=k) {
				  floor= Math.max(floor, node.val);
			  }
			  
			  if(node.left!=null) {
				  queue.add(node.left);
			  }
			  if(node.right!=null) {
				  queue.add(node.right);
			  }
	  }
	  result[0]= floor;
	  result[1]=ceil;
  }
  
	public static int[] findCeilingFloorDFS(int[] result, TreeNode root, int k) {

		if (root == null) {
			return result;
		}
		int floor = result[0];
		int ceil = result[1];

		if (k <= root.val) {
			ceil = Math.min(ceil, root.val);
			result[1] = ceil;
		}

		if (k >= root.val) {
			floor = Math.max(floor, root.val);
			result[0] = floor;
		}

		if (k <= root.val && root.left != null) {
			findCeilingFloorDFS(result, root.left, k);
		}

		if (k >= root.val && root.right != null) {
			findCeilingFloorDFS(result, root.right, k);
		}
		return result;
	}
	
}

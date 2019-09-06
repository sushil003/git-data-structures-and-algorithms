package problems.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author Sushil
 *
 */
public class ZigZagLevelOrderTraversalForBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> levels = new ArrayList<>();
        if(root==null){
            return levels;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean normalOrder = false;
        
        while(!queue.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int size =queue.size();
            normalOrder=!normalOrder;
            while(size >0){
                size--;
                TreeNode node = queue.poll();
                
                if(normalOrder){
                    level.add(node.val);
                }else {
                      level.addFirst(node.val);
                }
                
                if(node.left!=null){
                    queue.offer(node.left);
                }
                
                 if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            
            levels.add(level);
        }
        
        return levels;
    }
}

package problems.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import basicdatastructures.TreeNode;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 * @author Sushil
 *
 */
public class BinaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<List<Integer>> verticalOrder(TreeNode root) {
	       
	        List<List<Integer>> result = new ArrayList<>();
	        
	        if(root==null){
	            return result;
	        }
	        
	        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        Queue<Integer> col = new LinkedList<>();
	        
	        q.add(root);
	        col.add(0);
	        
	        int min=0;
	        int max=0;
	        
	        while(!q.isEmpty()){
	            TreeNode node = q.poll();
	            Integer colNo = col.poll();
	            
	            map.putIfAbsent(colNo,new ArrayList<Integer>());
	            map.get(colNo).add(node.val);
	            
	            if(node.left!=null){
	                q.add(node.left);
	                col.add(colNo-1);
	                min=Math.min(min,colNo-1);
	            }
	            
	             if(node.right!=null){
	                q.add(node.right);
	                col.add(colNo+1);
	                max=Math.max(max,colNo+1);
	            }
	            
	        }
	        
	        for(int i=min;i<=max;i++){
	           result.add(map.get(i)); 
	        }
	        
	        return result;
	    }
}

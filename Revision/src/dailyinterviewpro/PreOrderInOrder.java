package dailyinterviewpro;

import basicdatastructures.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private int preorderIndex;
    private int inorderIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int inorderEnd) {
        
        if (preorderIndex >= preorder.length) {
            return null;
        }
        
        if (inorder[inorderIndex] == inorderEnd) {
            ++inorderIndex;
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        root.left = buildTree(preorder, inorder, root.val);
        root.right = buildTree(preorder, inorder, inorderEnd);
        return root;
    }
}
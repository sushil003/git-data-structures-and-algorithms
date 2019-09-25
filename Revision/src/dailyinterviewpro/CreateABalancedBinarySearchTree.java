package dailyinterviewpro;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import basicdatastructures.TreeNode;

/**
 * Given a sorted list of numbers, change it into a balanced binary search tree.
 * You can assume there will be no duplicate numbers in the list.
 *
 * @author Sushil
 *
 */
public class CreateABalancedBinarySearchTree {

public static void main(String[] args) {

int[] a = {1, 2, 3, 4, 5, 6, 7};
TreeNode root = createBST(a);
List<Integer> result = bStLevelOrderPrinting(root,new ArrayList<Integer>());
System.out.println(result);

}


public static List<Integer> bStLevelOrderPrinting(TreeNode root, List<Integer> result){

Deque<TreeNode> queueDeque = new ArrayDeque<>();
queueDeque.add(root);

while(!queueDeque.isEmpty()) {
int size = queueDeque.size();
for(int i=0; i< size; i++) {
TreeNode node = queueDeque.remove();
result.add(node.val);
if(node.left!=null) {
queueDeque.add(node.left);
}
if(node.right!=null) {
queueDeque.add(node.right);
}
}

}
return result;
}

public static TreeNode createBST(int[] a) {

return bstBuilder(a,0,a.length-1);
}

private static TreeNode bstBuilder(int[] a, int start,int end) {

if(start > end || boundChecks(a,start) || boundChecks(a,end)) {
return null;
}
int mid = start +(end-start)/2;
TreeNode root = new TreeNode(a[mid]);
root.left = bstBuilder(a,start,mid-1);
root.right = bstBuilder(a, mid+1, end);
return root;
}

private static boolean boundChecks(int[] a, int index) {

return index < 0 || index >= a.length;
}
}

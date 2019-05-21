package problems.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import basicdatastructures.TreeNode;

/**
 * 
 * @author sushi
 *
 */
public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "null";
        }
        
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
    
    public TreeNode rdeserialize(List<String> l){
        
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        
        return root;
    }
}

package problems.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import basicdatastructures.GraphNode;

/**
 * Given a reference of a node in a connected undirected graph, return a deep
 * copy (clone) of the graph. Each node in the graph contains a val (int) and a
 * list (List[Node]) of its neighbors.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * 
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * 
 * Explanation: Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3. Node 3's value
 * is 3, and it has two neighbors: Node 2 and 4. Node 4's value is 4, and it has
 * two neighbors: Node 1 and 3.
 * 
 * 
 * Note:
 * 
 * The number of nodes will be between 1 and 100. The undirected graph is a
 * simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q
 * must have node p as neighbor too. You must return the copy of the given node
 * as a reference to the cloned graph.
 * 
 * @author Sushil
 *
 */
public class CloneGraph {

	Map<GraphNode, GraphNode> oldToNew = new HashMap<GraphNode, GraphNode>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public GraphNode cloneGraphDFS(GraphNode node) {
	    if (oldToNew.containsKey(node)) // If the node has been cloned, return the cloned node
	        return oldToNew.get(node);
	    GraphNode cloneNode = new GraphNode();
	    cloneNode.val = node.val;
	    oldToNew.put(node, cloneNode); // update the hash map

	    cloneNode.neighbors = new ArrayList<GraphNode>();
	    for (int i = 0; i < node.neighbors.size(); i++) {
	        cloneNode.neighbors.add(cloneGraphDFS(node.neighbors.get(i)));
	    }    
	    return cloneNode;
	}
	
	 public GraphNode cloneGraphBFS(GraphNode node) {
	     if(node == null) return node;
	     
	     // Use BFS algorithm to traverse the graph and get all nodes.
	     ArrayList<GraphNode> nodes = getNodes(node);
	     
	     // Copy nodes, store the old->new mapping information in a HashMap.
	     HashMap<GraphNode, GraphNode> mapping = new HashMap<>();
	     for(GraphNode n : nodes) {
	     	mapping.put(n, new GraphNode(n.val, new ArrayList<GraphNode>()));
	     }
	     
	     // Copy neighbors
	     for(GraphNode n : nodes) {
	    	 GraphNode newNode = mapping.get(n);
	     	for(GraphNode neighbor : n.neighbors) {
	     		GraphNode newNeighbor = mapping.get(neighbor);
	     		newNode.neighbors.add(newNeighbor);
	     	}
	     }
	     
	     return mapping.get(node);
	 }
	 
	 public ArrayList<GraphNode> getNodes(GraphNode node) {
	 	Queue<GraphNode> queue =  new LinkedList<>();
	 	HashSet<GraphNode> set =  new HashSet<>();
	 	
	 	queue.offer(node);
	 	set.add(node);
	 	
	 	while(!queue.isEmpty()) {
	 		GraphNode head = queue.poll();
	 		for(GraphNode neighbor : head.neighbors) {
	 			if(!set.contains(neighbor)) {
	 				queue.offer(neighbor);
	 				set.add(neighbor);
	 			}
	 		}
	 	}
	 	
	 	return new ArrayList<GraphNode>(set);
	 }
}

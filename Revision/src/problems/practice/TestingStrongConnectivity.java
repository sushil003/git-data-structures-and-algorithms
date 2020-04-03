package problems.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TestingStrongConnectivity {

	public static void main(String[] args) {

		  /*
	      Here you are given the adjacency list, but even if you were
	      given the raw edges and vertices (remember: G = (V, E)), you'd
	      still be able to build the adjacency list in O(|E|) time.

	      Just loop over the edges and build what you see below.
	    */
	    Map<Integer, List<Integer>> originalNodeToAdjacents = new HashMap<>();
	    originalNodeToAdjacents.put(0, Arrays.asList(1));
	    originalNodeToAdjacents.put(1, Arrays.asList(2));
	    originalNodeToAdjacents.put(2, Arrays.asList(3, 4));
	    originalNodeToAdjacents.put(3, Arrays.asList(0));
	    originalNodeToAdjacents.put(4, Arrays.asList(2));

	    /*
	      The graph above:

	        0 ---> 1 ---> 2 <---> 4
	        ^            /
	         \         /
	           \     /
	             \  ⌄
	               3
	    */

	    /*
	      If we reverse each edge:

	        0 <--- 1 <--- 2 <---> 4
	         \            ^
	          \         /
	            \     /
	             ⌄   /
	               3
	    */

	    System.out.println(isStronglyConnected(originalNodeToAdjacents));
	}

	private static boolean isStronglyConnected(Map<Integer, List<Integer>> originalNodeToAdjacents) {
	    
		boolean allNodesReachedViaBFS = allNodesReachedViaBFS(originalNodeToAdjacents);
		
		if(!allNodesReachedViaBFS) {
			return false;
		}
		
		Map<Integer, List<Integer>> reverseNodeToAdjacents = reverseGraph(originalNodeToAdjacents);
		
		boolean allReverseNodesReachedViaBFS = allNodesReachedViaBFS(reverseNodeToAdjacents);
		
		return allReverseNodesReachedViaBFS;
		
	  }

	private static Map<Integer, List<Integer>> reverseGraph(Map<Integer, List<Integer>> originalNodeToAdjacents) {
		
		Map<Integer, List<Integer>> reverse = new HashMap<>();
		
		for(Map.Entry<Integer, List<Integer>> entry : originalNodeToAdjacents.entrySet()) {
			
			Integer key = entry.getKey();
			List<Integer> value = entry.getValue();
			
			for(Integer adj : value) {
				List<Integer> reverseAdj;
				
				if(reverse.containsKey(adj)) {
					reverseAdj= reverse.get(adj);
				}else {
					reverseAdj = new ArrayList<>();
				}
				
				reverseAdj.add(key);
				reverse.put(adj, reverseAdj);
			}
		}

		return reverse;
	}

	private static boolean allNodesReachedViaBFS(Map<Integer, List<Integer>> originalNodeToAdjacents) {
		
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		
		visited.add(0);
		queue.add(0);
		
		while(!queue.isEmpty()) {
			
			Integer node = queue.poll();
			
			List<Integer> adj = originalNodeToAdjacents.get(node);
			
			for(Integer temp : adj) {
				
				if(!visited.contains(temp)) {
					visited.add(temp);
					queue.add(temp);
				}
			}
		}
		

		return visited.size()==originalNodeToAdjacents.size();
	}

	 
}

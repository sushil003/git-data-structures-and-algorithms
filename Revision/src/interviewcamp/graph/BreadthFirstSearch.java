package interviewcamp.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * @author Sushil
 *
 */
public class BreadthFirstSearch {

	public static void main(String[] args) {

		
	}

	public static boolean bfs(Graph graph, int target) {
		for (Node node : graph.getNodes()) {
			if (node.getState() == State.UNVISITED && bfsVisit(node, target))
				return true;
		}
		return false;
	}

	public static boolean bfsVisit(Node start, int target) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(start);
		start.setState(State.VISITING);
		while (!q.isEmpty()) {
			Node current = q.remove();
			if (current.getData() == target)
				return true;
			for (Node neighbor : current.getNeighbors()) {
				if (neighbor.getState() == State.UNVISITED) {
					q.add(neighbor);
					neighbor.setState(State.VISITING);
				}
			}
			current.setState(State.VISITED);
		}
		return false;
	}

	
	public enum State {
		UNVISITED, VISITING, VISITED;
	}

	public class Graph {
		List<Node> nodes;

		public Graph(List<Node> nodes) {
			super();
			this.nodes = nodes;
		}

		public void addNode(Node node) {
			nodes.add(node);
		}

		public List<Node> getNodes() {
			return nodes;
		}
	}

	public class Node {
		List<Node> neighbors;
		int data;
		State state;

		public Node(int data) {
			super();
			this.data = data;
			state = State.UNVISITED;
			neighbors = new ArrayList<Node>();
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setState(State state) {
			this.state = state;
		}

		public State getState() {
			return state;
		}

		public void addNeighbor(Node node) {
			neighbors.add(node);
		}

		public List<Node> getNeighbors() {
			return neighbors;
		}
	}

}

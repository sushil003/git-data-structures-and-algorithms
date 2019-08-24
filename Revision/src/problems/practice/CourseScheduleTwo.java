package problems.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class CourseScheduleTwo {
    // Topological Sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjacencyList = getAdjacencyList(numCourses, prerequisites);
        int[] incoming = getIncomingEdges(numCourses, prerequisites);
        Deque<Integer> queue = initializeQueue(incoming);
        int count = 0;
        int[] result = new int[numCourses];
        int resultIndex = 0;
        
        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            result[resultIndex++] = vertex;
            ++count;
            for (Integer adjacentVertex : adjacencyList.get(vertex)) {
                if (--incoming[adjacentVertex] == 0) {
                    queue.add(adjacentVertex);
                }
            }
        }
        
        return count == numCourses ? result : new int[] {};
    }
    
    private List<List<Integer>> getAdjacencyList(int numCourses, int[][] ps) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] p : ps) {
            adjacencyList.get(p[1]).add(p[0]);
        }
        return adjacencyList;
    }
    
    private Deque<Integer> initializeQueue(int[] incoming) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < incoming.length; i++) {
            if (incoming[i] == 0) {
                queue.add(i);
            }
        }
        return queue;
    }
    
    private int[] getIncomingEdges(int numCourses, int[][] p) {
        int[] incoming = new int[numCourses];
        for (int i = 0; i < p.length; i++) {
            ++incoming[p[i][0]];
        }
        return incoming;
    }
}
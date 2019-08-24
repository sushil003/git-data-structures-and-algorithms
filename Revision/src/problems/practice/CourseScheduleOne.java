package problems.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class CourseScheduleOne {
    
    // Topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjacencyList = initAdjacencyList(numCourses, prerequisites);
        int[] incoming = new int[numCourses];
        
        for (int[] prerequisite : prerequisites) {
             ++incoming[prerequisite[0]];            
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < incoming.length; i++) {
            if (incoming[i] == 0) {
                queue.add(i);
            }
        }
        
        int visitedNodeCount = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            
            ++visitedNodeCount;
            
            for (Integer adjacentVertex : adjacencyList.get(node)) {
                if (--incoming[adjacentVertex] == 0) {
                    queue.add(adjacentVertex);
                }
            }
        }
        
        return visitedNodeCount == numCourses;
    }
    
    private List<List<Integer>> initAdjacencyList(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        return adjacencyList;
    }
}
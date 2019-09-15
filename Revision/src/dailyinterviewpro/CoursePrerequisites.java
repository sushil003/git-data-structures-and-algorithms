package dailyinterviewpro;
/**
 * You are given a hash table where the key is a course code, and the value is a list of all the 
 * course codes that are prerequisites for the key.
 *  Return a valid ordering in which we can complete the courses. If no such ordering exists, return NULL.

Example:
{
  'CSC300': ['CSC100', 'CSC200'], 
  'CSC200': ['CSC100'], 
  'CSC100': []
}

This input should return the order that we need to take these courses:
 ['CSC100', 'CSC200', 'CSCS300']

 * @author Sushil
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CoursePrerequisites {

	public static void main(String[] args) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("CSC300", new ArrayList<>());
		map.get("CSC300").add("CSC100");
		map.get("CSC300").add("CSC200");
		
		map.put("CSC200", new ArrayList<>());
		map.get("CSC200").add("CSC100");
		
		map.put("CSC100", new ArrayList<>());
		
		List<String> courseOrdering = coursesToTake(map);
		
		for(String course : courseOrdering) {
			System.out.println(course);
		}
		
	}

	public static List<String> coursesToTake(Map<String, List<String>> coursesMap) {

		List<String> courseOrdering = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		Stack<String> stack = new Stack<>();
		
		List<String> courseList = new ArrayList<>(coursesMap.keySet());
		
		visited.add(courseList.get(0));
	    dfs(courseList.get(0), coursesMap, visited, stack);  
	    
	    while(!stack.isEmpty()) {
	    	courseOrdering.add(stack.pop());
	    }
        
	    Collections.reverse(courseOrdering);
	    
		return courseOrdering;
	}

	private static void dfs(String courseKey,Map<String, List<String>> coursesMap, Set<String> visited, Stack<String> stack) {
        
		List<String> dependentCourses = coursesMap.get(courseKey);
		
		if(dependentCourses.contains(courseKey)) {
			return;
		}
		
		for(String childCourse : dependentCourses) {
			 
			if(!visited.contains(childCourse)) {
				visited.add(childCourse);
				dfs(childCourse,coursesMap, visited, stack);
			}
			
		}
		
		stack.push(courseKey);
		
		
	}
}

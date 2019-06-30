package problems.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * @author Sushil
 *
 */
public class Permutations2 {

	public static void main(String[] args) {

		int[] input = {1,1,2};
		List<List<Integer>> outputList = permuteUnique(input);
		
		System.out.println(outputList);
 	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
	    
        List<List<Integer>> output = new ArrayList<>();
        List<Integer>  numList = new ArrayList<>();
        
        for(int num : nums){
            numList.add(num);
        }
        
        backTrack(numList.size(),output,numList,0);
        return output;
    }
    
    private static void backTrack(int n,List<List<Integer>> output,  List<Integer>  numList, int first){
        
        if(n==first){
            output.add(new ArrayList<>(numList));
        }
        
        Set<Integer> containsSet = new HashSet<>();
        
        for(int i=first; i <n ;i++){
            if(!containsSet.contains(numList.get(i))){
                containsSet.add(numList.get(i));
                Collections.swap(numList,first,i);
                backTrack(n,output,numList,first+1);
                Collections.swap(numList,first,i);
            }
        }
    }
}

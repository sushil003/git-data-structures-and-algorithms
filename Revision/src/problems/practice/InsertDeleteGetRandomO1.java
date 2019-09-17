package problems.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 * 
 * @author Sushil
 *
 */
public class InsertDeleteGetRandomO1 {

	public static void main(String[] args) {

		
	}
	
	  Random rand;
	    
	    List<Integer> list;
	    
	    Map<Integer,Integer> valueToIndexMap;

	    /** Initialize your data structure here. */
	    public InsertDeleteGetRandomO1() {
	        rand = new Random();
	        list = new ArrayList<>();
	        valueToIndexMap = new HashMap<>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        
	        if(valueToIndexMap.containsKey(val)){
	            
	            return false;
	        }
	        
	        valueToIndexMap.put(val,list.size());
	        list.add(val);
	        
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	     
	        if(!valueToIndexMap.containsKey(val)){
	            return false;
	        }
	        
	        int indexToRemove = valueToIndexMap.get(val);
	        int lastElement = list.get(list.size()-1);
	        list.set(indexToRemove,lastElement);
	        list.remove(list.size()-1);
	        
	        valueToIndexMap.put(lastElement,indexToRemove);
	        valueToIndexMap.remove(val);
	        
	        
	        return true;
	        
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	      
	        int index = rand.nextInt(list.size());
	        
	        return list.get(index);
	    }

}

package problems.practice;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new
 * item. For the purpose of this problem, when there is a tie (i.e., two or more
 * keys that have the same frequency), the least recently used key would be
 * evicted.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * @author Sushil
 *
 */
public class LFUCache {

	public static void main(String[] args) {

		LFUCache cache = new LFUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
	}
	 public int capacity;
	    public int stamp;
	    public HashMap<Integer,Tuple> hashMap;
	    public TreeMap<Tuple,Integer> treeMap;
	    

	    public LFUCache(int capacity) {
	        this.capacity=capacity;
	        hashMap=new HashMap<Integer,Tuple>();
	        treeMap=new TreeMap<Tuple,Integer>((o1,o2)->{
	            
	            if(o1.times==o2.times){
	                return o1.stamp-o2.stamp;
	            }else{
	                return o1.times-o2.times;
	            }
	        });
	    }
	    
	    public int get(int key) {
	       
	        if(capacity==0 || !hashMap.containsKey(key)){
	            return -1;
	        }
	        
	        Tuple old = hashMap.get(key);
	        treeMap.remove(old);
	        Tuple newTuple = new Tuple(old.value,stamp++,old.times+1);
	        hashMap.put(key,newTuple);
	        treeMap.put(newTuple,key);
	        return old.value;
	    }
	    
	    public void put(int key, int value) {
	        
	        if(capacity==0){
	            return;
	        }
	        
	        if(hashMap.containsKey(key)){
	            Tuple old = hashMap.get(key);
	            Tuple newTuple = new Tuple(value,stamp++,old.times+1);
	            treeMap.remove(old);
	            hashMap.put(key,newTuple);
	            treeMap.put(newTuple,key);
	        }else{
	            if(treeMap.size()==capacity){
	                int endKey= treeMap.pollFirstEntry().getValue();
	                hashMap.remove(endKey);
	            }
	            Tuple newTuple = new Tuple(value,stamp++,1);
	            hashMap.put(key,newTuple);
	            treeMap.put(newTuple,key);
	        }
	    }
	    
	    class Tuple {
	        int value;
	        int stamp;
	        int times;
	        
	        public Tuple(int value,int stamp, int times){
	          
	            this.value=value;
	            this.stamp=stamp;
	            this.times=times;
	        }
	    }
	
}

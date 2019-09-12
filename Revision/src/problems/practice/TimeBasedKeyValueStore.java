package problems.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Create a timebased key-value store class TimeMap, that supports two
 * operations.
 * 
 * 1. set(string key, string value, int timestamp)
 * 
 * Stores the key and value, along with the given timestamp. 2. get(string key,
 * int timestamp)
 * 
 * Returns a value such that set(key, value, timestamp_prev) was called
 * previously, with timestamp_prev <= timestamp. If there are multiple such
 * values, it returns the one with the largest timestamp_prev. If there are no
 * values, it returns the empty string ("").
 * 
 * @author Sushil
 *
 */
public class TimeBasedKeyValueStore {
	
	Map<String, TreeMap<Integer, String>> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        
        map = new HashMap<>();
    }

	public void set(String key, String value, int timestamp) {

		if (!map.containsKey(key)) {
			map.put(key, new TreeMap<Integer, String>());
		}

		map.get(key).put(timestamp, value);

	}

	public String get(String key, int timestamp) {

		TreeMap<Integer, String> treeMap = map.get(key);

		Integer t = treeMap.floorKey(timestamp);

		return t != null ? treeMap.get(t) : "";

	}

}

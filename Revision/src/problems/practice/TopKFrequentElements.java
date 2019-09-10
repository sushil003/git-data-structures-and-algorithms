package problems.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> topKFrequent(int[] nums, int k) {
	       
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> queue= new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.add(entry);
            if(queue.size()>k){
               queue.poll(); 
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(result.size() < k){
            result.add(queue.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}

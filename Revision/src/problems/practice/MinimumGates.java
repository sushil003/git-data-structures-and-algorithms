package problems.practice;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumGates {

	public static void main(String[] args) {
		int a[] = {1300,1340,1350,1500,1900,2200};
		int d[] = {1310,1600,1520,1530,2300,2400};
		
		Queue<Integer> queue = new LinkedList<>();
		
		int len = a.length;
		int gatesize = 0;
		queue.add(d[0]);
		gatesize = queue.size();
		for(int i=1; i<len; i++) {
				if(a[i]>queue.peek()) {
					queue.poll();
					queue.add(d[i]);
				}else {
					queue.add(d[i]);
					gatesize++;
				}
		}
		System.out.println(gatesize);
	}
}

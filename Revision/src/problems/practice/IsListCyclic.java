package problems.practice;

import basicdatastructures.LinkedListNode;

/**
 * 
 * @author sushi
 *
 */
public class IsListCyclic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public static LinkedListNode<Integer> hasCycle(LinkedListNode<Integer> head) {

		  LinkedListNode<Integer> slow= head;
		  LinkedListNode<Integer> fast= head;
		  
		  while(fast!=null && fast.next!=null) {
			  slow =slow.next;
			  fast = fast.next.next;
			  if(slow==fast) {
				  
				  int cycleLength =0;
				  do {
					  ++cycleLength;
					  fast=fast.next;
				  }while(slow!=fast);
				  
				  LinkedListNode<Integer> cycleAdvIter = head;
				  while(cycleLength-- >0) {
					  cycleAdvIter=cycleAdvIter.next;
				  }
				  
				  LinkedListNode<Integer> iter = head;
				  
				  while(iter!=cycleAdvIter) {
					  iter= iter.next;
					  cycleAdvIter= cycleAdvIter.next;
				  }
				  
				  return iter;
				  
			  }
			  
		  }
		  
		  
		  return null;
	  }
	
}

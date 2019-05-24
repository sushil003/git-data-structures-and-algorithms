package problems.practice;

import basicdatastructures.LinkedListNode;

/**
 * For a given list and int x 
 * arrange the list such that node less than x 
 * appear before x and node greater than x appear 
 * after x
 * @author sushi
 *
 */
public class PivotList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public static LinkedListNode<Integer> listPivoting(LinkedListNode<Integer> l, int x) {

		  LinkedListNode<Integer> lessThanX =new LinkedListNode<Integer>(0, null);
		  LinkedListNode<Integer> equalToX =new LinkedListNode<Integer>(0, null);
		  LinkedListNode<Integer> greaterThanX =new LinkedListNode<Integer>(0, null);
		  
		  LinkedListNode<Integer> lessIter=lessThanX;
		  LinkedListNode<Integer> equalIter=equalToX;
		  LinkedListNode<Integer> greaterIter=greaterThanX;
		  
		  LinkedListNode<Integer> iter= l;
		  
		  while(iter!=null) {
			  
			  if(iter.data < x) {
				  lessIter.next=iter;
				  lessIter=iter;
			  } else if(iter.data==x) {
				  equalIter.next=iter;
				  equalIter=iter;
			  }else {
				  greaterIter.next=iter;
				  greaterIter=iter;
			  }
			  iter =iter.next;
		  }

		  greaterIter.next=null;
		  equalIter.next=greaterThanX.next;
		  lessIter.next= equalToX.next;
		  
		  
		  return lessThanX.next;
		  
	  }
}

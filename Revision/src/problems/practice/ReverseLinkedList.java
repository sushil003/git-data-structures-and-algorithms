package problems.practice;

import basicdatastructures.ListNode;

/**
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 * 
 * @author sushi
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
 
		ListNode first= new ListNode(1);
		first.next=new ListNode(2);
		first.next.next=new ListNode(3);
		first.next.next.next=new ListNode(4);
		first.next.next.next.next=new ListNode(5);
		first.next.next.next.next.next=null;
		
		ListNode reversed = reverseListIterative(first);
		
		while(reversed!=null) {
			System.out.println(reversed.val);
			reversed=reversed.next;
		}
		
  
	}

	public static ListNode reverseListIterative(ListNode head) {

		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static ListNode reverseListRecursive(ListNode head) {

		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode p = reverseListRecursive(head.next);
		head.next.next= head;
		head.next=null;
		return p;
	}
}

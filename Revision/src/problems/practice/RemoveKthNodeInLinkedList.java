package problems.practice;

import basicdatastructures.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * @author sushi
 *
 */
public class RemoveKthNodeInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode first = dummyHead.next;
		while (n-- > 0) {
			first = first.next;
		}

		ListNode second = dummyHead;
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummyHead.next;
	}
}

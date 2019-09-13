package dailyinterviewpro;

import basicdatastructures.ListNode;

/**
 * You are given a singly linked list and an integer k. Return the linked list,
 * removing the k-th last element from the list.
 * 
 * @author Sushil
 *
 */
public class RemovekthLastElementFromLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd(ListNode head, int k) {

		ListNode dummy = new ListNode(0);

		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;

		for (int i = 1; i <= k + 1; i++) {
			first = first.next;
		}

		while (first != null) {
			first = first.next;
			second = second.next;
		}

		second.next = second.next.next;

		return dummy.next;
	}

}

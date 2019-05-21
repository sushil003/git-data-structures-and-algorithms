package problems.practice;

import basicdatastructures.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 * 
 * @author sushi
 *
 */
public class ReverseSublist {

	public static void main(String[] args) {

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null) {
			return null;
		}

		ListNode prev = null;
		ListNode curr = head;

		while (m > 1) {
			prev = curr;
			curr = curr.next;
			m--;
			n--;
		}

		ListNode con = prev;
		ListNode tail = curr;

		ListNode third = null;

		while (n > 0) {
			third = curr.next;
			curr.next = prev;
			prev = curr;
			curr = third;
			n--;
		}

		if (con != null) {
			con.next = prev;
		} else {
			head = prev;
		}

		tail.next = curr;
		return head;

	}
}

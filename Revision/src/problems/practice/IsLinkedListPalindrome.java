package problems.practice;

import basicdatastructures.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * Input: 1->2 Output: false 
 * 
 * Example 2:
 * 
 * Input: 1->2->2->1 Output: true
 * 
 * @author sushil
 *
 */
public class IsLinkedListPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode firstIter = head;
		ListNode secondIter = reverseLinkedList(slow);

		while (firstIter != null && secondIter != null) {

			if (firstIter.val != secondIter.val) {
				return false;
			}

			firstIter = firstIter.next;
			secondIter = secondIter.next;

		}

		return true;
	}

	private ListNode reverseLinkedList(ListNode head) {
		ListNode pre = null;
		ListNode next;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}

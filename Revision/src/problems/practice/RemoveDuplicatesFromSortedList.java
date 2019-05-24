package problems.practice;

import basicdatastructures.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * Input: 1->1->2 Output: 1->2 Example 2:
 * 
 * Input: 1->1->2->3->3 Output: 1->2->3
 * 
 * @author sushi
 *
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode iter = head;
		while (iter != null && iter.next != null) {
			ListNode nextNode = iter.next;
			if (iter.val == iter.next.val) {
				iter.next = iter.next.next;
			} else {
				iter = iter.next;
			}
		}

		return head;
	}
}

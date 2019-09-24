package dailyinterviewpro;

import java.util.PriorityQueue;
import java.util.Queue;

import basicdatastructures.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * @author Sushil
 *
 */
public class MergeKSortedLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKListsUsingPriorityQueue(ListNode[] lists) {

		Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

		for (ListNode l : lists) {
			if (l != null) {
				queue.add(l);
			}
		}

		ListNode head = new ListNode(-1);
		ListNode curr = head;

		while (!queue.isEmpty()) {
			curr.next = queue.poll();
			curr = curr.next;
			ListNode next = curr.next;
			if (next != null) {
				queue.add(next);
			}
		}

		return head.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 1) {
			return lists[0];
		}

		if (lists.length == 0) {
			return null;
		}

		ListNode head = mergeTwoList(lists[0], lists[1]);

		for (int i = 2; i < lists.length; i++) {

			head = mergeTwoList(head, lists[i]);
		}

		return head;
	}

	public ListNode mergeTwoList(ListNode l1, ListNode l2) {

		ListNode head = new ListNode(-1);
		ListNode curr = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		curr.next = l1 == null ? l2 : l1;

		return head.next;
	}
}

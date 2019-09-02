package problems.practice;

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
 * 
 * @author Sushil
 *
 */
public class MergeKSortedLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {

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
}

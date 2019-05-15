package problems.practice;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4 
 * Output: 1->1->2->3->4->4
 * @author sushi
 *
 */
public class MergeTwoSortedLinkedLists {

	public static void main(String[] args) {

		
	}

	public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		if (l1.val < l2.val) {
			l1.next = mergeTwoListsRecursive(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoListsRecursive(l1, l2.next);
			return l2;
		}
	}

	public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {

		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}

			prev = prev.next;
		}

		prev.next = l1 == null ? l2 : l1;

		return prehead.next;

	}

	public class ListNode {
		ListNode next;
		int val;

		ListNode(int x) {
			val = x;
		}
	}
}

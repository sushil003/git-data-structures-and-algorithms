package dailyinterviewpro;

import basicdatastructures.ListNode;

/**
 * Given the head of a linked list, we repeatedly delete consecutive sequences
 * of nodes that sum to 0 until there are no such sequences.
 * 
 * After doing so, return the head of the final linked list. You may return any
 * such answer.
 * 
 * 
 * 
 * (Note that in the examples below, all sequences are serializations of
 * ListNode objects.)
 * 
 * Example 1:
 * 
 * Input: head = [1,2,-3,3,1] Output: [3,1] Note: The answer [1,2,1] would also
 * be accepted. Example 2:
 * 
 * Input: head = [1,2,3,-3,4] Output: [1,2,4] Example 3:
 * 
 * Input: head = [1,2,3,-3,-2] Output: [1]
 * 
 * @author Sushil
 *
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

	public static void main(String[] args) {

		
	}

	public ListNode removeZeroSumSublists(ListNode head) {
        ListNode root = new ListNode(0), slow = root, fast = head;
        root.next = head;
        boolean flag = true;
        while (flag && root.next != null) {
            flag = false;
            while (slow.next != null) {
                int sum = fast.val;
                while (sum != 0 && fast.next != null) {
                    fast = fast.next;
                    sum += fast.val;
                }
                if (sum == 0) {
                    slow.next = fast.next;
                    flag = true;
                }
                else 
                    slow = slow.next;
                fast = slow.next;
            }
        }
        return root.next;
    }
}

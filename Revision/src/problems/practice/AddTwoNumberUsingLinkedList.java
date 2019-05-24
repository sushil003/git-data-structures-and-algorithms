package problems.practice;

import basicdatastructures.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 * Output: 7 -> 0 -> 8 
 * Explanation: 342 + 465 = 807.
 * 
 * @author sushi
 *
 */
public class AddTwoNumberUsingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummyHead = new ListNode(0);
        ListNode placeIter = dummyHead;
        int carry =0;
        while(l1!=null || l2!=null || carry!=0){
          
        int val = carry + (l1!=null ? l1.val : 0) +(l2!=null ? l2.val : 0);
        placeIter.next = new ListNode(val%10);
        carry = val/10;
        l1= l1!=null ? l1.next : null;
        l2= l2!=null ? l2.next : null;
        placeIter=placeIter.next;
            
        }
        
        return dummyHead.next;
    }
}

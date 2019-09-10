package dailyinterviewpro;

import basicdatastructures.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins
 * 
 * @author Sushil
 *
 */
public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        if(lenA > lenB){
            headA= advanceToK(headA,lenA-lenB);
        }else if(lenA < lenB){
            headB = advanceToK(headB,lenB-lenA);
        }
        
        while(headA!=null && headB!=null && headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
     
        return headA;
    }
    
    private ListNode advanceToK(ListNode node,int k){
        
        while(k-->0){
            node=node.next;
        }
        
        return node;
    }

    private int getLength(ListNode node){
        int len=0;
        
        while(node!=null){
            len++;
            node = node.next;
        }
        
        return len;
    }
	
}

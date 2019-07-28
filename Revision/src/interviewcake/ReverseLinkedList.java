package interviewcake;

/**
 * 
 * @author Sushil
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static LinkedListNode reverse(LinkedListNode headOfList) {
		LinkedListNode currentNode = headOfList;
		LinkedListNode previousNode = null;
		LinkedListNode nextNode = null;

		// until we have 'fallen off' the end of the list
		while (currentNode != null) {

			// copy a pointer to the next element
			// before we overwrite currentNode.next
			nextNode = currentNode.next;

			// reverse the 'next' pointer
			currentNode.next = previousNode;

			// step forward in the list
			previousNode = currentNode;
			currentNode = nextNode;
		}

		return previousNode;
	}
}

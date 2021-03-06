package interviewcake;

import basicdatastructures.LinkedListNode;

/**
 * 
 * @author Sushil
 *
 */
public class CycleInALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean containsCycle(LinkedListNode firstNode) {

		// start both runners at the beginning
		LinkedListNode slowRunner = firstNode;
		LinkedListNode fastRunner = firstNode;

		// until we hit the end of the list
		while (fastRunner != null && fastRunner.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;

			// case: fastRunner is about to "lap" slowRunner
			if (fastRunner == slowRunner) {
				return true;
			}
		}

		// case: fastRunner hit the end of the list
		return false;
	}
}

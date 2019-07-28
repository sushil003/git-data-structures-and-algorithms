package interviewcake;

/**
 * 
 * @author Sushil
 *
 */
public class FirstComeFirstServed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isFirstComeFirstServed(int[] takeOut, int[] dineIn, int[] servedOrders) {
	    int takeOutIndex = 0;
	    int dineInIndex = 0;

	    for (int order : servedOrders) {

	        // if we still have orders in takeOut
	        // and the current order in takeOut is the same
	        // as the current order in servedOrders
	        if (takeOutIndex < takeOut.length && order == takeOut[takeOutIndex]) {
	            takeOutIndex++;

	        // if we still have orders in dineIn
	        // and the current order in dineIn is the same
	        // as the current order in servedOrders
	        } else if (dineInIndex < dineIn.length && order == dineIn[dineInIndex]) {
	            dineInIndex++;

	        // if the current order in servedOrders doesn't match the current
	        // order in takeOut or dineIn, then we're not serving first-come,
	        // first-served
	        } else {
	            return false;
	        }
	    }

	    // all orders in servedOrders have been "accounted for"
	    // so we're serving first-come, first-served!
	    return true;
	}
}

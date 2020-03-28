package interviewcake;

/**
 * 
 * @author Sushil
 *
 */
public class CoinChange {

	public static void main(String[] args) {

		int[] a = {2,4,5};
		
		System.out.println(changePossibilitiesBottomUp(9,a));
	}

	public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
		int[] waysOfDoingNCents = new int[amount + 1]; // array of zeros from 0..amount
		waysOfDoingNCents[0] = 1;

		for (int coin : denominations) {
			for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
				int higherAmountRemainder = higherAmount - coin;
				waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
			}
		}

		return waysOfDoingNCents[amount];
	}
}

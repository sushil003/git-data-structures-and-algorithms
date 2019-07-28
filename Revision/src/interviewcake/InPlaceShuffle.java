package interviewcake;

import java.util.Random;

/**
 * This is a semi-famous algorithm known as the Fisher-Yates shuffle (sometimes
 * called the Knuth shuffle).
 * 
 * @author Sushil
 *
 */
public class InPlaceShuffle {

	private static Random rand = new Random();

	private static int getRandom(int floor, int ceiling) {
		return rand.nextInt((ceiling - floor) + 1) + floor;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void shuffle(int[] array) {

		// if it's 1 or 0 items, just return
		if (array.length <= 1) {
			return;
		}

		// walk through from beginning to end
		for (int indexWeAreChoosingFor = 0; indexWeAreChoosingFor < array.length - 1; indexWeAreChoosingFor++) {

			// choose a random not-yet-placed item to place there
			// (could also be the item currently in that spot)
			// must be an item AFTER the current item, because the stuff
			// before has all already been placed
			int randomChoiceIndex = getRandom(indexWeAreChoosingFor, array.length - 1);

			// place our random choice in the spot by swapping
			if (randomChoiceIndex != indexWeAreChoosingFor) {
				int valueAtIndexWeChoseFor = array[indexWeAreChoosingFor];
				array[indexWeAreChoosingFor] = array[randomChoiceIndex];
				array[randomChoiceIndex] = valueAtIndexWeChoseFor;
			}
		}
	}
}

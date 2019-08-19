package problems.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * 
 * add - Add the number to an internal data structure. find - Find if there
 * exists any pair of numbers which sum is equal to the value.
 * 
 * Example 1:
 * 
 * add(1); add(3); add(5); find(4) -> true find(7) -> false Example 2:
 * 
 * add(3); add(1); add(2); find(3) -> true find(6) -> false
 * 
 * @author Sushil
 *
 */
public class TwoSumIIIDataStructureDesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Integer> numbers;

	/** Initialize your data structure here. */
	public TwoSumIIIDataStructureDesign() {
		numbers = new ArrayList<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		numbers.add(number);
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		return isTwoSumPresent(value, numbers);
	}

	private boolean isTwoSumPresent(int target, List<Integer> numbers) {
		Collections.sort(numbers);
		int left = 0;
		int right = numbers.size() - 1;

		while (left < right) {

			int sum = numbers.get(left) + numbers.get(right);

			if (sum < target) {
				left++;
			} else if (sum > target) {
				right--;
			} else {
				return true;
			}
		}

		return false;
	}
}

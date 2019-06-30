package problems.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * @author Sushil
 *
 */
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();
		List<Integer> numsList = new ArrayList<>();

		for (int num : nums) {
			numsList.add(num);
		}
		backTrack(numsList.size(), output, numsList, 0);
		return output;

	}

	private void backTrack(int n, List<List<Integer>> output, List<Integer> numsList, int first) {

		if (n == first) {
			output.add(new ArrayList<>(numsList));
		}

		for (int i = first; i < n; i++) {
			Collections.swap(numsList, first, i);
			backTrack(n, output, numsList, first + 1);
			Collections.swap(numsList, first, i);
		}
	}
}

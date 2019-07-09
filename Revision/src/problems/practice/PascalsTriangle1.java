package problems.practice;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author Sushil
 *
 */
public class PascalsTriangle1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> results = new ArrayList<>();

		if (numRows == 0) {
			return results;
		}

		List<Integer> first = new ArrayList<>();
		first.add(1);
		results.add(first);

		for (int i = 1; i < numRows; i++) {

			List<Integer> currRow = new ArrayList<>();
			List<Integer> prevRow = results.get(i - 1);
			currRow.add(1);

			for (int j = 1; j < i; j++) {

				currRow.add(prevRow.get(j - 1) + prevRow.get(j));

			}
			currRow.add(1);
			results.add(currRow);
		}
		return results;
	}
}

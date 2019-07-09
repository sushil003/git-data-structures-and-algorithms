package problems.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
 * @author Sushil
 *
 */
public class PascalsTriangle2 {

	public static void main(String[] args) {

		System.out.println(getRow(3));
	}

	public static List<Integer> getRow(int rowIndex) {

		List<Integer> row = null;
		List<Integer> pre = null;

		for (int i = 0; i <= rowIndex; i++) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				row.add(j == 0 || i == j ? 1 : pre.get(j) + pre.get(j - 1));
			}
			pre = row;
		}
		return row;
	}
}

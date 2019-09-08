package problems.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1:
 * 
 * Input: [[1,1],2,[1,1]] Output: [1,1,2,1,1] Explanation: By calling next
 * repeatedly until hasNext returns false, the order of elements returned by
 * next should be: [1,1,2,1,1]. Example 2:
 * 
 * Input: [1,[4,[6]]] Output: [1,4,6] Explanation: By calling next repeatedly
 * until hasNext returns false, the order of elements returned by next should
 * be: [1,4,6].
 * 
 * @author Sushil
 *
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

	int index;

	List<Integer> flattenList;

	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		index = 0;
		flattenList = getFlattenList(nestedList);
	}

	public List<Integer> getFlattenList(List<NestedInteger> nestedList) {

		List<Integer> result = new ArrayList<>();

		for (NestedInteger nest : nestedList) {

			if (nest.isInteger()) {

				result.add(nest.getInteger());
			} else {
				result.addAll(getFlattenList(nest.getList()));
			}
		}

		return result;
	}

	@Override
	public Integer next() {
		return flattenList.get(index++);
	}

	@Override
	public boolean hasNext() {
		return index < flattenList.size();
	}

}

package dailyinterviewpro;

import java.util.ArrayList;
import java.util.List;

/**
 * For example: [(1, 3), (5, 8), (4, 10), (20, 25)]
 * 
 * This input should return [(1, 3), (4, 10), (20, 25)] since (5, 8) and (4, 10)
 * can be merged into (4, 10).
 * 
 * @author Sushil
 *
 */
public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Meetings {

		public int start;
		public int end;

		public Meetings(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public int[][] merge(int[][] intervals) {

		if (intervals == null || intervals.length == 0) {
			return new int[][] {};
		}

		List<Meetings> meetList = new ArrayList<>();

		for (int[] interval : intervals) {
			meetList.add(new Meetings(interval[0], interval[1]));
		}

		meetList.sort((o1, o2) -> o1.start - o2.start);

		List<Meetings> mergedList = new ArrayList<>();

		mergedList.add(meetList.get(0));

		for (Meetings meetings : meetList) {

			Meetings lastMergedMeeting = mergedList.get(mergedList.size() - 1);

			if (lastMergedMeeting.end >= meetings.start) {

				lastMergedMeeting.end = Math.max(lastMergedMeeting.end, meetings.end);
			} else {
				mergedList.add(meetings);
			}

		}

		int[][] result = new int[mergedList.size()][2];

		for (int i = 0; i < mergedList.size(); i++) {
			result[i][0] = mergedList.get(i).start;
			result[i][1] = mergedList.get(i).end;
		}

		return result;
	}

}

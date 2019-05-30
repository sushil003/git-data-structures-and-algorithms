package problems.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author sushi
 *
 */
public class SunsetView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class BuildingWithHeight {
		public Integer id;
		public Integer height;

		public BuildingWithHeight(Integer id, Integer height) {
			this.id = id;
			this.height = height;
		}
	}

	public static List<Integer> examineBuildingsWithSunset(Iterator<Integer> sequence) {
		int buildingHeightId = 0;
		Deque<BuildingWithHeight> candidates = new ArrayDeque<>();
		while (sequence.hasNext()) {
			int buildingHeight = sequence.next();

			while (!candidates.isEmpty() && Integer.compare(buildingHeight, candidates.peekFirst().height) >= 0) {
				candidates.removeFirst();
			}
			candidates.addFirst(new BuildingWithHeight(buildingHeightId++, buildingHeight));
		}
		return candidates.stream().map(c -> c.id).collect(Collectors.toList());
	}
}

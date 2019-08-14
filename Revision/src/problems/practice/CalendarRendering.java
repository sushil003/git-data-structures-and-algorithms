package problems.practice;

import java.util.List;
import java.util.stream.Collectors;

public class CalendarRendering {

	public static class Event {
		public int start, finish;

		public Event(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
	}

	private static class Endpoint {
		public int time;
		public boolean isStart;

		Endpoint(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}
	}

	public static int findMaxSimultaneousEvents(List<Event> A) {

		List<Endpoint> endpoints = A.stream()
				.map(event -> List.of(new Endpoint(event.start, true), new Endpoint(event.finish, false)))
				.flatMap(List::stream).collect(Collectors.toList());

		endpoints.sort((a, b) -> {
			if (a.time != b.time) {
				return Integer.compare(a.time, b.time);
			}
			return a.isStart && !b.isStart ? -1 : !a.isStart && b.isStart ? 1 : 0;
		});

		int maxNoOfEvent = 0;
		int numOfSimultenousEvent = 0;
		for (Endpoint endpoint : endpoints) {

			if (endpoint.isStart) {
				++numOfSimultenousEvent;
				maxNoOfEvent = Math.max(maxNoOfEvent, numOfSimultenousEvent);
			} else {
				--numOfSimultenousEvent;
			}
		}

		return maxNoOfEvent;
	}

	public static void main(String[] args) {

	}
}

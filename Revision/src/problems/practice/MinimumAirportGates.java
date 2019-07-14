package problems.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumAirportGates {

	private static class FlightTimes {
		public Integer startTime;
		public Integer endTime;

		public FlightTimes(Integer startTime, Integer endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	public static void main(String[] args) {
        
		List<FlightTimes> noOfFlights= new ArrayList<>();
		noOfFlights.add(new FlightTimes(1300,1310));
		noOfFlights.add(new FlightTimes(1340,1600));
		noOfFlights.add(new FlightTimes(1350,1520));
		noOfFlights.add(new FlightTimes(1500,1530));
		noOfFlights.add(new FlightTimes(1900,2300));
		noOfFlights.add(new FlightTimes(2200,2400));
		
		System.out.println(getMinimumGates(noOfFlights));
	}

	public static int getMinimumGates(List<FlightTimes> noOfFlights) {
		
		int requiredGates =1;
		int gates=1;
		
		List<Integer> startTimeList= new ArrayList<>();
		List<Integer> endTimeList = new ArrayList<>();
		
		for(FlightTimes flightTimes : noOfFlights) {
			startTimeList.add(flightTimes.startTime);
			endTimeList.add(flightTimes.endTime);
		}
		
		Collections.sort(startTimeList);
		Collections.sort(endTimeList);
		
		int start=1;
		int end =0;
		
		while(start < startTimeList.size() && end < endTimeList.size()) {
			
			if(startTimeList.get(start) <= endTimeList.get(end)) {
				gates++;
				start++;
				requiredGates=Math.max(requiredGates, gates);
			}else {
				gates--;
				end++;
			}
		}
		
		return requiredGates;
		
	}
}

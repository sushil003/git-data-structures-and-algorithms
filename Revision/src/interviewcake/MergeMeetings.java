package interviewcake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * @author Sushil
 *
 */
public class MergeMeetings {

	public static void main(String[] args) {

		List<Meeting> input=new ArrayList<>();
		/*input.add(new Meeting(0,1));
		input.add(new Meeting(3,5));
		input.add(new Meeting(4,8));
		input.add(new Meeting(10,12));
		input.add(new Meeting(9,10));*/
		input.add(new Meeting(1,3));
		input.add(new Meeting(2,5));
		input.add(new Meeting(4,7));
		List<Meeting> mergedMeetingsList =mergeRanges(input);
		for(Meeting tempMeeting:mergedMeetingsList){
			
			System.out.println("Meeting("+tempMeeting.getStartTime()+","+tempMeeting.getEndTime()+")\n");
		}
	}

	public static List<Meeting> mergeRanges(List<Meeting> meetings) {

		List<Meeting> sortedMeetings = new ArrayList<>(meetings);
		 Collections.sort(sortedMeetings,new Comparator<Meeting>(
				 
				 ) {

					@Override
					public int compare(Meeting o1, Meeting o2) {
						
						return o1.getStartTime()-o2.getStartTime();
					}
		});

		 List<Meeting> mergedMeetingsList=new ArrayList<>();
		 mergedMeetingsList.add(sortedMeetings.get(0)); 
		 
		 for(Meeting currentMeeting:sortedMeetings){
			 
			 Meeting lastMergedMeeting=mergedMeetingsList.get(mergedMeetingsList.size()-1);
			 if(currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()){
				 lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));
			 }else{
				 mergedMeetingsList.add(currentMeeting);
			 }
		 }
	
		 
		return mergedMeetingsList;
	}
}

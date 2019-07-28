package interviewcake;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Sushil
 *
 */
public class TwoMovieFit {

	public static void main(String[] args) {
		
		int[] movieArray=new int[]{1,2,3,4,5,6,7,8,9};

		System.out.println("True or false"+canTwoMoviesFillFlight(movieArray,1));
	}

	public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {
		
		Set<Integer> seenMovieSet=new HashSet<>();
		for(int firstmovie :movieLengths){
			int secondMovieCanBeSeen=flightLength-firstmovie;
			if(seenMovieSet.contains(secondMovieCanBeSeen)){
				return true;
			}
			seenMovieSet.add(firstmovie);
		}
		return false;
	}
}

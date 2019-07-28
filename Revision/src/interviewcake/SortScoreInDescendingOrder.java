package interviewcake;

/**
 * 
 * @author Sushil
 *
 */
public class SortScoreInDescendingOrder {

	public static void main(String[] args) {

		  int[] unsortedScores = {37, 89, 41, 65, 91, 53};
		  final int HIGHEST_POSSIBLE_SCORE = 100;
		int[] sortedScoresIndescendingOrder=sortScores(unsortedScores,HIGHEST_POSSIBLE_SCORE);
		for(int sortScore :sortedScoresIndescendingOrder){
			System.out.println(sortScore);
		}
	}
	
 public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

	 int[] scoreCount =new int[highestPossibleScore+1];
	 for(int score :unorderedScores){
		 scoreCount[score]++;
	 }
	 int currentSortedIndex=0;
	 int[] sortedScore=new int[unorderedScores.length];
	 for(int score=highestPossibleScore;score>=0 ;score--){
		 int occurances=scoreCount[score];
		 for(int i=0;i<occurances; i++){
			 sortedScore[currentSortedIndex]=score;
			 currentSortedIndex++;
		 }
	 }
	 return sortedScore;
 }

}

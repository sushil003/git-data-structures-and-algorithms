package problems.practice;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * E.G – 
1. Input String [mom], list of anagrammatic pairs are [m,m],[mo,om] , so answer is 2.
2. Input String [kkkk], k comes in 6(n=4) pairs using n(n-1)/2, kk comes 3(n=3) pairs using n(n-1)/2, kkk comes in only one pair so output is 6+3+1=10

 * @author Sushil
 *
 */
public class AnagramSolution {
	static int calculateNumberOfPairs(String s) {

		Map<String, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String tmp = s.substring(i, j);

				char[] chars = tmp.toCharArray();
				Arrays.sort(chars);
				tmp = String.valueOf(chars);
				// System.out.println(tmp);

				if (map.keySet().contains(tmp)) {
					map.put(tmp, map.get(tmp) + 1);
				} else {
					map.put(tmp, 1);
				}
			}
		}
		// System.out.println(map);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				int n = entry.getValue();
				count = count + n * (n - 1) / 2;
			}
		}
		return count;
	}

    public static void main(String[] args) {
		String str = "kkkk";
		int result = calculateNumberOfPairs( str );
		System.out.println( "Result >> " + result );
	}
}

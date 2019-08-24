package problems.practice;

public class TrailingZeroesProblem {

	public static void main(String[] args) {
		TrailingZeroesProblem trailingZeroesProblem = new TrailingZeroesProblem();
		System.out.println(trailingZeroesProblem.trailingZeroes(10));
	}

	public int trailingZeroes(int n) {

		int count = 0;

		while (n > 0) {
			n /= 5;
			count += n;
		}

		return count;

	}
}

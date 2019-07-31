package problems.practice;

import java.util.HashSet;
import java.util.Set;

public class CollatzChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean testCollatzConjecture(int n) {

		Set<Long> verfiedNumberSet = new HashSet<>();

		for (int i = 3; i <= n; i += 2) {
			Set<Long> seq = new HashSet<>();

			long testI = i;

			while (testI <= i) {

				if (!verfiedNumberSet.add(testI)) {
					break;
				}

				if (!seq.add(testI)) {
					return false;
				}

				if (testI / 2 != 0) {
					long newTestI = testI * 3 + 1;

					if (newTestI <= testI) {
						throw new ArithmeticException();
					}

					testI = newTestI;
				} else {
					testI /= 2;
				}

			}
		}

		return true;
	}
}

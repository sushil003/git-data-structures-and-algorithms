package interviewcamp.arraysandstrings;

/**
 * Check if a String is a rotation of another. For example,["canada", "dacana"]
 * -> true["canada", "canada"] -> true["canada", "canary"] -> false["dacana",
 * "adacan"] -> true
 * 
 * @author Sushil
 *
 */
public class StringIsRotationOfAnother {

	public static void main(String[] args) {

		System.out.println(isRotation("canada", "dacana"));
	}

	public static boolean isRotation(String a, String b) {
		if (a == null || b == null || a.length() != b.length())
			return false;
		return (a + a).contains(b);
	}
}

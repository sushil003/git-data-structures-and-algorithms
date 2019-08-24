package problems.practice;

import java.util.Arrays;

public class PhoneNumberMnemonics {

	public static void main(String[] args) {

		printAllwords(new int[] {2,1,3});
	}

	public static void printAllwords(int[] phoneNumber) {
		
		 if (phoneNumber == null || phoneNumber.length == 0)       
			 return;
		
		char[] buffer = new char[phoneNumber.length];
		
		printWordHelper(phoneNumber,buffer,0,0);
	}

	private static void printWordHelper(int[] phoneNumber, char[] buffer, int nextIndex, int bufferIndex) {

		if (nextIndex >= phoneNumber.length || bufferIndex >= buffer.length) {
			System.out.println(Arrays.toString(buffer));
			return;
		}

		char[] letters = getLetters(phoneNumber[nextIndex]);

		if (letters.length == 0) {
			printWordHelper(phoneNumber, buffer, nextIndex + 1, bufferIndex);
		}

		for (char c : letters) {
			buffer[bufferIndex]=c;
			printWordHelper(phoneNumber, buffer, nextIndex + 1, bufferIndex+1);
		}
	}

	private static char[] getLetters(int nextIndex) {

		switch (nextIndex) {
		case 0:
			return new char[] {};
		case 1:
			return new char[] {};
		case 2:
			return new char[] { 'a', 'b', 'c' };
		case 3:
			return new char[] { 'd', 'e', 'f' };
		case 4:
			return new char[] { 'g', 'h', 'i' };
		case 5:
			return new char[] { 'j', 'k', 'l' };
		case 6:
			return new char[] { 'm', 'n', 'o' };
		case 7:
			return new char[] { 'p', 'q', 'r', 's' };
		case 8:
			return new char[] { 't', 'u', 'v' };
		case 9:
			return new char[] { 'w', 'x', 'y', 'z' };
		}
		throw new IllegalArgumentException("Invalid Digit " + nextIndex);
	}
}

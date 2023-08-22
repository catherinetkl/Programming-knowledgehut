package com.fdmgroup.exercise6_testcases;

public class Exercise1point3 {

	public String simpleEncoder(String string){
		// create an array to store encoded characters
		char[] encodedChars = new char[string.length()];
		
		for (int i = 0; i < string.length(); i++) {
			char originalChar = string.charAt(i); // get original character at index i
			char encodedChar;
			
			// check if it's a space, it remains unchanged
			if (originalChar == ' ') {
				encodedChar = ' ';
			// Consider the 1-based position
			} else if ((i + 1) % 2 == 0) {
				encodedChar = encodeEven(originalChar); // Encode character at even position
			} else {
				encodedChar = encodeOdd(originalChar); // encode character at odd position
			}
			
			encodedChars[i] = encodedChar; // Store encoded character in the array
		}
		return new String(encodedChars); // convert char array to String and return
	}
	
	// Method to encode character at an odd position
	private char encodeOdd(char c) {
		if (c == 'z') {
			return 'a'; // Loop around for 'z'
		}
		return (char) (c + 1); // move one step forward in element
	}
	
	// Method to encode character at even position
	private char encodeEven(char c) {
		if (c == 'a' ) {
			return 'z'; // Loop around for 'a'
		}
		return (char) (c - 1);
	}

}

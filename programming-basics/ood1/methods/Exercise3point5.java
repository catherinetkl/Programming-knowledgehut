package com.fdmgroup.exercise5_part3;

public class Exercise3point5 {

	public int[] extractEvenArray(int[] array) {
		int count = 0;
		
		// count the number of even numbers
		for (int num: array) {
			if (num % 2 == 0) {
				count++;
			}
		}
		
		// create a new array to store even numbers
		int[] evenNumbersArray = new int[count];
		
		int index = 0;
		// populate new array with even numbers
		for (int num : array) {
			if (num % 2 == 0) {
				evenNumbersArray[index] = num;
				index++;
			}
		}
		return evenNumbersArray;
	}

}

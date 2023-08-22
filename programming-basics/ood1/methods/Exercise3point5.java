/* Write a method called extractEvenArray. 
It should take an int array as an argument. 
It should return an int array which contains all of the even numbers from the original array. 
The returned array should not be any bigger than the size required to hold the even numbers. 
The even numbers in the returned array should be in the same order as in the original array. 
For example:
With this array as an argument: 	[2,5,3,7,6,7,3,4,3]

The method would return:		[2,6,4] */

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

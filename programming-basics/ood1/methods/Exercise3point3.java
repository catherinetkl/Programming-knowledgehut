/* Write a method called arrayFrequency. It should take two arguments: an int array and a int. 
The method should return an int containing the number of times the int occurs in the array. */

package com.fdmgroup.exercise5_part3;

public class Exercise3point3 {

	public int arrayFrequency(int[] array, int number) {
		int frequency = 0; 	// initialise a counter to 0
		
		// iterate through the array
		for (int element : array) {
			if (element == number) {
				/* if current element matches number
				   increment frequency counter*/
				frequency++;
			}
		}
		return frequency; // return final count
	}
}

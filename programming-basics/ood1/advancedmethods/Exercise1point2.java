package com.fdmgroup.exercise6_testcases;

public class Exercise1point2 {

	public int[] bubbleSort(int[] array) {
		// create a copy of the original array to sort
		int[] sortedArray = array.clone();
		
		int n = sortedArray.length;
		boolean swapped; // Flag to indicate whether any swaps were made
		
		do {
			swapped = false; // initialise swapped as false
			
			// iterate through array from second to last element
			for (int i = 1; i < n; i++) {
				// compare each adjacent pair of elements
				if (sortedArray[i - 1] > sortedArray[i]) {
					// swap elements if they are in the wrong order
					int temp = sortedArray[i - 1];
					sortedArray[i - 1] = sortedArray[i];
					sortedArray[i] = temp;
					swapped = true; // set swapped to true as swap was made
				}
			}
			n--; // decrease n since largest element has moved to its correct position
		} while(swapped); // repeat process if any swaps were made in previous iteration
		
		return sortedArray;
	}

}

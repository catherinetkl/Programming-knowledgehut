package com.fdmgroup.exercise5_part3;

public class Exercise3point4 {

	public int maxNumber(int[] array) {
        int max = Integer.MIN_VALUE;  // Initialise max with a very low value
        
        // Traverse array elements and update max
        for (int num : array) {
            if (num > max) {
                max = num;  // Update max if the current element is greater
            }
        }
        
        return max;  // Return the maximum value
	}

}
  
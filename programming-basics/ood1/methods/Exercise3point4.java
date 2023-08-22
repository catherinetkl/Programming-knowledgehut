/* Write a method called maxNumber. It should take an int array as an argument. 
It should return an int containing the highest number in the array. 
Note that numbers in the array could be positive or negative. 
So in this array: [-7,-4,-9] the highest number would be -4. */

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
  

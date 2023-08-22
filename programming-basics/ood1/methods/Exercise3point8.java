package com.fdmgroup.exercise5_part3;

import java.util.Arrays;

public class Exercise3point8 {

    public double medianNumber(double[] numbers) {
        Arrays.sort(numbers);  // Sort the array in ascending order
        
        // calculates length of sorted array
        int length = numbers.length;
        
        /* calculates the index of the middle element. 
         * For even-length arrays, it represents the index before the 
         * exact middle, and for odd-length arrays, 
         * it represents the exact middle index */
        int middleIndex = length / 2;
        
        if (length % 2 == 0) {
            // If the array has even length, calculate mean of two middle values
        	double middleValue1 = numbers[middleIndex - 1]; // Value before the exact middle
            double middleValue2 = numbers[middleIndex]; // Value at the exact middle
            return (middleValue1 + middleValue2) / 2.0; // Return the mean of the two middle values
        } else {
            // If the array has odd length, return the middle value
            return numbers[middleIndex];
        }
    }
}

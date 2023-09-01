package com.fdmgroup.exercise5_part3;

import java.util.ArrayList;
import java.util.List;

public class Exercise3point6 {

    public String[] reverseStringArray(String[] array) {
    	// get length of array to determine size of new reversedArray
        int length = array.length;
        
        // Create a list to hold reversed elements
        List<String> reversedList = new ArrayList<>();
        
        // Populate the list in reverse order
        for (int i = length - 1; i >= 0; i--) {
            reversedList.add(array[i]);
        }
        
        // Convert the list back to an array
        String[] reversedArray = reversedList.toArray(new String[0]);
        
        return reversedArray;  // Return the reversed array
    }
}

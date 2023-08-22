/* Write a method called arrayContains. It should take two arguments: a String array and a String. 
The method should return a Boolean: true if the array contains the String and false otherwise. */

package com.fdmgroup.exercise5_part3;

import java.util.Arrays;
import java.util.List;

public class Exercise3point2 {

    public boolean arrayContains(String[] array, String string) {
    	// Convert the array into a List using Arrays.asList(array)
    	List<String> list = Arrays.asList(array);
    	/* Use the contains method of the List interface to 
    	 * check if the string is present in the list*/
    	return list.contains(string);
    }

}

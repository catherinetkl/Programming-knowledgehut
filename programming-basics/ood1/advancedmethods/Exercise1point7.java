package com.fdmgroup.exercise6_testcases;

import java.util.regex.*;

public class Exercise1point7 {

	public boolean validPostcode(String postcode) {
    // Convert to uppercase to handle case-insensitivity
    String cleanedPostcode = postcode.toUpperCase();
    System.out.println("Cleaned Postcode: " + cleanedPostcode); // Debug line

    // Define the regex pattern for a valid UK postcode
    String regex = "^(?:(?:(?:[A-Z][0-9]{1,2})|(?:[A-Z]{2}[0-9]{1,2}))[ ]?[0-9][A-Z]{2})$";
//    System.out.println("Regex Pattern: " + regex); // Debug line
    
    Pattern PC = Pattern.compile(regex);
    Matcher matcher = PC.matcher(cleanedPostcode); // Use cleanedPostcode instead of postcode
    boolean result = matcher.matches();
    return result;
	}
}

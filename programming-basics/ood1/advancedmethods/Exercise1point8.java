package com.fdmgroup.exercise6_testcases;

public class Exercise1point8 {

    public boolean validPassword(String password) {
        // Check if the password has at least 7 characters
        if (password.length() < 7) {
            return false;
        }
        
        // Define regex patterns for each requirement
        String upperCasePattern = ".*[A-Z].*"; // Matches an uppercase letter
        String lowerCasePattern = ".*[a-z].*";	// matches a lowercase letter
        String digitPattern = ".*\\d.*"; // matches a digit
        String symbolPattern = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?\\\\].*"; // Matches a non-alphanumeric character

        // Check if password meets 3 out of 4 criteria
        int count = 0;
        //	Check if the password contains at least one upper case letter
        if (password.matches(upperCasePattern)) {
            count++; // Increment the count if the condition is true
        }
        // Check if the password contains at least one lower case letter
        if (password.matches(lowerCasePattern)) {
            count++; // Increment the count if the condition is true
        }
        // Check if the password contains at least one digit
        if (password.matches(digitPattern)) {
            count++; // Increment the count if the condition is true
        }
        // Check if the password contains at least one symbol
        if (password.matches(symbolPattern)) {
            count++; // Increment the count if the condition is true
        }

        // Return true if the password meets the criteria
        return count >= 3;
    }
}


package com.fdmgroup.exercise6_testcases;

public class Exercise1point4 {

    public String encode(String text) {
        StringBuilder encodedText = new StringBuilder(); // Initialise a StringBuilder to store the encoded text
        
        for (int i = 0; i < text.length(); i++) {
            char originalChar = text.charAt(i);
            char encodedChar;
            
            if (originalChar == ' ') {
                encodedChar = ' '; // Spaces remain unchanged
            } else {
                encodedChar = encodeCharacter(originalChar, i);
            }
            
            encodedText.append(encodedChar); // Append the encoded character to the StringBuilder
        }
        
        return encodedText.toString(); // Convert the StringBuilder to a String and return
    }

    private char encodeCharacter(char c, int position) {
        int offset = (position + 1) % 26;
        
        // Check if the character is uppercase
        if (Character.isUpperCase(c)) {
            char encodedChar = (position + 1) % 2 == 0 // Even position
                    ? (char) ('A' + (c - 'A' - offset + 26) % 26) // Calculate the encoded character for lowercase at even position by subtracting offset
                    : (char) ('A' + (c - 'A' + offset) % 26); // Calculate the encoded character for uppercase at odd position by adding offset
            return Character.toLowerCase(encodedChar);
         // Check if the character is lowercase
        } else if (Character.isLowerCase(c)) {
            char encodedChar = (position + 1) % 2 == 0 // check if even position
                    ? (char) ('a' + (c - 'a' - offset + 26) % 26) // Calculate the encoded character for lowercase at even position by subtracting offset
                    : (char) ('a' + (c - 'a' + offset) % 26); // Calculate the encoded character for lowercase at odd position by adding offset
            return encodedChar; // Already in lowercase
        // Keep other characters (e.g., digits, symbols) unchanged
        } else {
            return c;
        }
    }
}




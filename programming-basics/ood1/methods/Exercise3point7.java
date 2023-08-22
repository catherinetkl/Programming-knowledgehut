package com.fdmgroup.exercise5_part3;

import java.util.HashMap;
import java.util.Map;

public class Exercise3point7 {

    public boolean isAnagram(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false; // Anagrams must have the same length
        }
        
        // Create a map to store character frequencies
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count character frequencies in string1
        for (char c : string1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Compare character frequencies with string2
        for (char c : string2.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false; // Extra or missing characters found
            }
            
            // Decrement the count for the current character
            charCount.put(c, charCount.get(c) - 1);
            
            // Remove the character from the map if its count becomes zero
            if (charCount.get(c) == 0) {
                charCount.remove(c);
            }
        }
        
        // If the map is empty, all characters have matched
        return charCount.isEmpty();
    }
}



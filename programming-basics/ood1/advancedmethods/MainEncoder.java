package com.fdmgroup.exercise6_testcases;

import java.util.Arrays;

public class MainEncoder {

	public static void main(String[] args) {
//        Exercise1point4 exercise4 = new Exercise1point4();
//
//        // Test cases
//        String[][] testCases = {
//            {"abcd", "bzfz"},
//            {"ABCD", "bzfz"},
//            {"aaaa", "bydw"},
//            {"zzzz", "axcv"},
//            {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "bydwfuhsjqlonmpkritgvexczabydwfuhsjqlonmpkritgvexcza"},
//            {"two words", "uur biyvb"},
//            {"the quick brown fox jumps over the lazy dog", "ufh voput mfbic wwq eyjrr pthn now blnl syx"}
//        };
//
//        for (String[] testCase : testCases) {
//            String input = testCase[0];
//            String expectedOutput = testCase[1];
//            
//            String encodedOutput = exercise4.encode(input);
//
//            System.out.println("Input: " + input);
//            System.out.println("Expected Output: " + expectedOutput);
//            System.out.println("Encoded Output: " + encodedOutput);
//            System.out.println("Match: " + encodedOutput.equals(expectedOutput));
//            System.out.println();
//        }
//		Exercise1point5 exercise5 = new Exercise1point5();
//		// Create an array of integers
//        int[] array = {1, 2, 3, 4, 5};
//        
//        // Test the rotateArray() method with different values of array and numberOfRotations
//        int[] rotatedArray1 = exercise5.rotateArray(array, 1);
//        System.out.println("rotateArray(array, 1) = " + Arrays.toString(rotatedArray1)); // Should print [5, 1, 2, 3, 4]
//        
//        int[] rotatedArray2 = exercise5.rotateArray(array, 2);
//        System.out.println("rotateArray(array, 2) = " + Arrays.toString(rotatedArray2)); // Should print [4, 5, 1, 2, 3]
//        
//        int[] rotatedArray3 = exercise5.rotateArray(array, 3);
//        System.out.println("rotateArray(array, 3) = " + Arrays.toString(rotatedArray3)); // Should print [3, 4, 5, 1, 2]
//        
//        int[] rotatedArray4 = exercise5.rotateArray(array, 4);
//        System.out.println("rotateArray(array, 4) = " + Arrays.toString(rotatedArray4)); // Should print [2, 3, 4, 5, 1]
//        
//        int[] rotatedArray5 = exercise5.rotateArray(array, 5);
//        System.out.println("rotateArray(array, 5) = " + Arrays.toString(rotatedArray5)); // Should print [1, 2, 3, 4, 5]
//        
//        int[] rotatedArray6 = exercise5.rotateArray(array, 6);
//        System.out.println("rotateArray(array, 6) = " + Arrays.toString(rotatedArray6)); // Should print [5, 1, 2, 3, 4]
//	}
//        Exercise1point6 exercise1point6 = new Exercise1point6();
//
//        // Test cases
//        String[][] testCases = {
//            {"RIGHT", "UP", "DOWN", "LEFT", "LEFT", "DOWN", "DOWN"},
//            {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"},
//            {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN", "UP", "UP", "UP", "RIGHT"},
//            {"RIGHT", "DOWN", "RIGHT", "RIGHT", "RIGHT", "DOWN", "RIGHT", "UP", "UP", "UP", "RIGHT"},
//            {"LEFT", "UP", "LEFT", "UP", "RIGHT", "DOWN", "RIGHT", "DOWN", "RIGHT", "DOWN", "RIGHT", "DOWN", "RIGHT", "DOWN", "DOWN", "RIGHT", "UP", "UP", "UP", "RIGHT"},
//            {"DOWN", "DOWN", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT"},
//            {"DOWN", "DOWN", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT"}
//        };
//
//        for (int i = 0; i < testCases.length; i++) {
//            String[] commands = testCases[i];
//            int gridSize = commands.length; // Size of the grid for each test case
//
//            int result = exercise1point6.roverMove(gridSize, commands);
//            System.out.println("Test Case " + (i + 1) + ": Final Position = " + result);
//        }
//    }
//		Exercise1point7 exercise7 = new Exercise1point7();
//
//        // Run test cases
//        System.out.println("Test Results:");
//        System.out.println("--------------");
//
//        // Positive test cases
//        System.out.println("AB12 3CD: " + exercise7.validPostcode("AB12 3CD"));
//        System.out.println("ab12 3cd: " + exercise7.validPostcode("ab12 3cd"));
//        System.out.println("AB123CD: " + exercise7.validPostcode("AB123CD"));
//        System.out.println("EF4 5GH: " + exercise7.validPostcode("EF4 5GH"));
//        System.out.println("EF45GH: " + exercise7.validPostcode("EF45GH"));
//        System.out.println("ef4 5gh: " + exercise7.validPostcode("ef4 5gh"));
//        System.out.println("J67 8KL: " + exercise7.validPostcode("J67 8KL"));
//        System.out.println("J678KL: " + exercise7.validPostcode("J678KL"));
//        System.out.println("j67 8kl: " + exercise7.validPostcode("j67 8kl"));
//        System.out.println("M9 0NP: " + exercise7.validPostcode("M9 0NP"));
//        System.out.println("M90NP: " + exercise7.validPostcode("M90NP"));
//        System.out.println("m9 0np: " + exercise7.validPostcode("m9 0np"));
		// Create an instance of Exercise1point8
        Exercise1point8 exercise8 = new Exercise1point8();
        
        // Test cases
        String[] passwords = {
            "aA1$", "bcdefg2", "34_5678", "J$KLMNP",
            "Pa$$word1", "Password1", "Pa$$word", "PASSWORD_1"
        };

        System.out.println("Test Results:");
        System.out.println("--------------");
        
        int totalTests = 0;
        int failures = 0;

        for (String password : passwords) {
            boolean result = exercise8.validPassword(password);
            totalTests++;
            
            String status = result ? "Passed" : "Failed";
            System.out.println("Test for password '" + password + "': " + status);
            
            if (!result) {
                failures++;
            }
        }

        System.out.println("Total Tests: " + totalTests);
        System.out.println("Failures: " + failures);
        System.out.println("Success: " + (totalTests - failures));
    }
}
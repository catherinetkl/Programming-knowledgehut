package com.fdmgroup.exercise6_testcases;

public class Exercise1point5 {

    public int[] rotateArray(int[] array, int numberOfRotations) {
        int length = array.length;
        int[] rotatedArray = new int[length]; // Create a new array to store the rotated values

        // Calculate the effective number of rotations within array length
        numberOfRotations = numberOfRotations % length;
        if (numberOfRotations < 0) {
            numberOfRotations += length; // Handle negative rotations by adding the length
        }

        // Perform the rotation
        for (int i = 0; i < length; i++) {
            int rotatedIndex = (i + numberOfRotations) % length;
            rotatedArray[rotatedIndex] = array[i];
        }

        return rotatedArray;
    }
}


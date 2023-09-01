package com.fdmgroup.exercise6_testcases;

public class Exercise1point6 {


    public int roverMove(int gridSize, String[] commands) {
        int currentPosition = 0; // Initialize the rover's starting position at index 0
        
        // Define the grid dimensions
        int numRows = gridSize;
        int numCols = gridSize;

        // Define the possible movement directions
        int[] rowMovement = {-1, 1, 0, 0}; // UP, DOWN
        int[] colMovement = {0, 0, -1, 1}; // LEFT, RIGHT

        // Iterate through each command
        for (String command : commands) {
            // Determine the movement direction based on the command
            int direction = -1; // Initialize with an invalid value
            if (command.equals("UP")) {
                direction = 0;
            } else if (command.equals("DOWN")) {
                direction = 1;
            } else if (command.equals("LEFT")) {
                direction = 2;
            } else if (command.equals("RIGHT")) {
                direction = 3;
            }

            // Calculate the new position based on the direction
            int newRow = (currentPosition / numCols) + rowMovement[direction];
            int newCol = (currentPosition % numCols) + colMovement[direction];

            // Check if the new position is within the grid boundaries
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                // Update the rover's current position
                currentPosition = newRow * numCols + newCol;
            }
        }

        return currentPosition; // Return the final position of the rover
    }
}


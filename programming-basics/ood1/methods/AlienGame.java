/* Create a method called getPoints. The method should take the colour of the alien as an argument 
and should return the number of points you get for that colour as an int. */

package com.fdmgroup.methodsExercises;

public class AlienGame {
    public static void main(String[] args) {
        int points = getPoints("red");
        System.out.println("You've scored " + points + " points!");
    }

    public static int getPoints(String alienColour) {
        return switch (alienColour) {
            case "green" -> 5;
            case "red" -> 10;
            case "yellow" -> 15;
            default -> 0; // Invalid colour
        };
    }
}

package com.fdmgroup;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * Class to create a simple console version of the Hangman game. Word is randomly picked from a pre-populated word list.
 *
 * The Hangman class implements a text-based Hangman game where the player attempts to guess a hidden word.
 * It tracks the guessed letters, remaining guesses, and provides feedback to the player.
 *
 * The game starts with a randomly selected word from a predefined list, and the player can guess one letter at a time.
 * The player has a limited number of guesses, and the game continues until they guess the word or run out of guesses.
 *
 * The player can exit the game by entering "EXIT" as their guess.
 *
 * @author Catherine
 */
public class Hangman {

    // Array of words for the Hangman game
    private static String[] words = {"terminator", "banana", "computer", "cow", "rain", "water"};

    // Randomly select a word from the list
    private static String word = words[(int) (Math.random() * words.length)];

    // Set to track guessed letters
    private static Set<String> guessedLetters = new HashSet<>();

    // Queue to track the order of guessed letters
    private static Queue<String> guessedOrder = new LinkedList<>();

    // Create a string of dashes to represent the word
    private static String asterisk = new String(new char[word.length()]).replace("\0", "-");

    // Initialize the number of guesses allowed
    private static int guessesLeft = 8;

    /**
     * The main method to start the Hangman game.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Print initial welcome message
        System.out.println("Welcome to Hangman!");
        // Display the hidden word with dashes in uppercase
        System.out.println("The word now looks like this: " + asterisk.toUpperCase());
        // Display the number of guesses left
        System.out.println("You have " + guessesLeft + " guesses left.");

        // Loop until guesses run out or the word is guessed
        while (guessesLeft > 0 && asterisk.contains("-")) {
            // Prompt the user for their guess
            System.out.print("Your guess [EXIT to stop game]: ");
            String guess = sc.next().toLowerCase();

            // Check if the user wants to exit the game
            if (guess.equals("exit")) {
                break;
            }

            // Validate and process the user's guess is a valid single letter
            if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
                guessedOrder.add(guess); // Add the guess to the order queue
                hang(guess); // // Call the hang function to process the guess
            } else {
                // Display an error message for invalid input
                System.out.println("Invalid input. Please enter a single letter.");
            }
        }

        sc.close();
    }

    /**
     * Method to process a player's guess and update the game state.
     *
     * @param guess The player's guessed letter.
     */
    public static void hang(String guess) {
        // Check if the guessed letter was already guessed before
        if (guessedLetters.contains(guess)) {
            // Display a message indicating the letter was guessed before
            System.out.println("This letter was guessed before.");
            return;
        }

        // Add the guessed letter to the set of guessed letters
        guessedLetters.add(guess);

        // Check if the guessed letter is in the word
        if (word.contains(guess)) {
            String newAsterisk = "";
            // Loop through the word to update the hidden word representation
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess.charAt(0)) {
                    newAsterisk += guess.charAt(0); // Replace dashes with correct guessed letters
                } else {
                    newAsterisk += asterisk.charAt(i); // Keep dashes for incorrect guesses
                }
            }
            // Update the hidden word representation
            asterisk = newAsterisk;
            // Display a message for a correct guess
            System.out.println("That guess is correct.");
        } else {
            // Decrease the number of remaining guesses
            guessesLeft--;
            // Display a message for an incorrect guess
            System.out.println("There are no " + guess + "'s in the word.");
        }

        // Display the current status of the word and guesses left
        System.out.println("The word now looks like this: " + asterisk.toUpperCase());
        // Display the number of guesses left
        System.out.println("You have " + guessesLeft + " guesses left.");

        // Display the list of guessed letters in the order that the user inputs
        System.out.print("Your guess: ");
        boolean isFirst = true;
        for (String letter : guessedOrder) {
            if (!isFirst) {
                System.out.print(", ");
            }
            System.out.print(letter.toUpperCase());
            isFirst = false;
        }
        System.out.println();

        // Check for game outcome
        if (asterisk.equals(word)) {
            System.out.println("You guessed the word: " + word.toUpperCase());
            System.out.println("You win.");
        } else if (guessesLeft == 0) {
            System.out.println("You're completely hung.");
            System.out.println("The word was: " + word.toUpperCase());
            System.out.println("You lose.");
        }
    }
}

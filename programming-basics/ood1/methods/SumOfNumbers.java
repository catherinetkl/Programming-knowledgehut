/* Create a method called sumOfNumbersUpTo. 
It should take an int as an argument and return a long. */

package com.fdmgroup.methodsExercises;

public class SumOfNumbers {
    public static void main(String[] args) {
        int number = 5;
        long sum = sumOfNumbersUpTo(number);
        System.out.println("Sum of numbers up to " + number + ": " + sum);
    }

    public static long sumOfNumbersUpTo(int n) {
        long total = 0;

        for (int x = 1; x<= n; x++) {
            total += x;
        }
        return total;
    }
}

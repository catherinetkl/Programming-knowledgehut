package com.fdmgroup.exercise6_testcases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise1point1 {

	public List<Integer> primeNumbers(int highestNumber) {
		/* Use IntStream to generate a range of numbers
		 * from 2 to highestNumber, apply filter to keep only prime numbers
		 * convert IntStream to a list of Integers */
		return IntStream.rangeClosed(2, highestNumber)
				.filter(this::isPrime) // use isPrime method as a filter
				.boxed() // convert int values to Integer objects
				.collect(Collectors.toList()); // Collect results into a list
	}
	
	// helper method to check if a number is prime
	private boolean isPrime(int num) {
		if (num <= 1) {
			return false; // Numbers less than or equal 1 are not prime
		}
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false; /* if number is divisible by any number
				 			     between 2 and sqrt(num), it's not prime*/
			}
		}
		return true; // if no divisors are found, num is prime
	}
}

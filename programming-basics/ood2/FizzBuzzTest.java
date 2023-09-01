package com.fdmgroup.junitclassdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/*
 * A number >= 1 is given as input
 * if the number is divisible by 3 - return "Fizz"
 * If the number is divisible by 5 - return "Buzz"
 * If the number is divisible by 3 and 5 - return "FizzBuzz"
 * if none of these conditions are met - the number is returned
 * 1 - 1
 * 2 - 2
 * 3 - Fizz
 * 4 - 4
 * 5 - Buzz
 * 6 - Fizz
 * 7 - 7
 * 8 - 8
 * 9 - Fizz
 * 10 - Buzz
 * 11 - 11
 * 12 - Fizz
 * 13 - 13
 * 14 - 14
 * 15 - FizzBuzz
 */

class FizzBuzzTest {
	


	@Test
	public void test_FizzBuzzConverter_Returns1_When1IsTheInput() {

		// Arrange
		FizzBuzz fizzBuzz = new FizzBuzz();

		// Act
		String stringReturned = fizzBuzz.fizzBuzzConverter(1);

		// Assert
		assertEquals("1", stringReturned);
	}

	@Test
	public void test_FizzBuzzConverter_Returns2_When2IsTheInput() {

		// Arrange
		FizzBuzz fizzBuzz = new FizzBuzz();

		// Act
		String stringReturned = fizzBuzz.fizzBuzzConverter(2);

		// Assert
		assertEquals("2", stringReturned);
	}

	@Test
	public void test_FizzBuzzConverter_ReturnsFizz_When3IsTheInput() {

		// Arrange
		FizzBuzz fizzBuzz = new FizzBuzz();

		// Act
		String stringReturned = fizzBuzz.fizzBuzzConverter(3);

		// Assert
		assertEquals("Fizz", stringReturned);
	}

	@Test
	public void test_FizzBuzzConverter_ReturnsBuzz_When5IsTheInput() {

		// Arrange
		FizzBuzz fizzBuzz = new FizzBuzz();

		// Act
		String stringReturned = fizzBuzz.fizzBuzzConverter(5);

		// Assert
		assertEquals("Buzz", stringReturned);
	}

	@Test
	public void test_FizzBuzzConverter_ReturnsFizzBuzz_When15IsTheInput() {

		// Arrange
		FizzBuzz fizzBuzz = new FizzBuzz();

		// Act
		String stringReturned = fizzBuzz.fizzBuzzConverter(15);

		// Assert
		assertEquals("FizzBuzz", stringReturned);
	}

}

/* Create a void method called displayTimesTable. 
It should take an int as an argument and display the times table for that int in the same format 
as in Loops exercise 2.4. For instance if the argument is 3 the method should display the 3 times table. 
If the argument is 5 the method should display the 5 times table. */

package com.fdmgroup.methodsExercises;

public class TimesTable {

	public static void main(String[] args) {
		int number = 3;
		displayTimesTable(number);
	}
	
	public static void displayTimesTable(int n) {
		for (int x = n; x <= n * 12; x += n) {
			System.out.println((x / n) + " x " + x + " = " + x);
		}
	}
}

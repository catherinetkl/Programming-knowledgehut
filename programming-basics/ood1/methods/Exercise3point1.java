/* Write a method called leapYear. It should take an int argument containing a year and return a boolean 
which is true if the year is a leap year. Leap years are divisible by 4. However the first year of a century
is not a leap year unless the year is divisible by 400.
E.g. 		2016 is a leap year so should return true
		2019 is not a leap year so should return false
		2000 is a leap year so should return true
		1900 is not a leap year so should return false
*/

package com.fdmgroup.exercise5_part3;

import java.time.Year;

public class Exercise3point1 {

	public boolean leapYear(int year) {
		/* in-built method isLeap() in the Year class 
		to identify if an input year is leap or not*/
		return Year.of(year).isLeap();
	}
}

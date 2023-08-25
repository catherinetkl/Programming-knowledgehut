package com.fdmgroup.tdd.gradecalculator;

public class GradeCalculator implements GradeCalculatorService {

	@Override
	public String getClassification(double mark) {
	    // Define the grade boundaries
	    double passThreshold = 75.0;
	    double meritThreshold = 80.0;
	    double distinctionThreshold = 90.0;
	    double perfectScore = 100.0;

	    // Check the mark against the boundaries
	    if (mark > perfectScore || mark < 0.0) {
	        throw new IllegalArgumentException("Invalid grade: " + mark);
	    }
	    
	    if (mark < passThreshold) {
	        return "fail";
	    } else if (mark < meritThreshold) {
	        return "pass";
	    } else if (mark < distinctionThreshold) {
	        return "merit";
	    } else {
	        return "distinction";
	    }
	    
	}
}

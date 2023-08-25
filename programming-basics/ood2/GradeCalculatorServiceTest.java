//package com.fdmgroup.tdd.gradecalculator;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;

//@ExtendWith(MockitoExtension.class)
//public class GradeCalculatorServiceTest {
//    private GradeCalculatorService gradeCalculator; // Mock object
//
////    @BeforeEach
////    public void setup() {
////        gradeCalculator = mock(GradeCalculatorService.class); // Create a mock object for GradeCalculatorService
////    }
//    
//    @Test // Test 1: Test for failing grade
//    public void test_GradeCalculatorReturnsFailWhenResultLessThan75() {
//        // Arrange: Set up the mock behaviour
//        when(gradeCalculator.getClassification(60.0)).thenReturn("fail");
//
//        // Act
//        String result = gradeCalculator.getClassification(60.0);
//
//        // Assert
//        assertEquals("fail", result);
//    }
//
//    @Test // Test 2: Test for passing grade
//    public void test_GradeCalculatorReturnsPassWhenResultGreaterThanOrEqualTo75AndLessThan80() {
//    	// Arrange: Set up the mock behaviour
//        when(gradeCalculator.getClassification(76.0)).thenReturn("pass");
//        
//        // Act
//        String result = gradeCalculator.getClassification(76.0);
//
//        // Assert
//        assertEquals("pass", result);
//    }
//    @Test // Test 3: Test for merit grade
//    public void test_GradeCalculatorReturnsMeritWhenResultGreaterThanOrEqualTo80AndLessThan90() {
//    	// Arrange: Set up the mock behaviour
//        when(gradeCalculator.getClassification(89.0)).thenReturn("merit");
//
//    	// Act: Call the getClassification method to get the result
//    	String result = gradeCalculator.getClassification(89.0);
//
//    	// Assert: Compare the actual result with the expected message ("merit")
//    	assertEquals("merit", result);
//    }
//
//    @Test // Test 4: Test for distinction grade
//    public void test_GradeCalculatorReturnsDistinctionWhenResultGreaterThanOrEqualTo90AndLessThanOrEqualTo100() {
//    	// Arrange: Set up the mock behaviour
//        when(gradeCalculator.getClassification(99.0)).thenReturn("distinction");
//
//    	// Act: Call the getClassification method to get the result
//    	String result = gradeCalculator.getClassification(99.0);
//
//    	// Assert: Compare the actual result with the expected message ("distinction")
//    	assertEquals("distinction", result);
//    }
//  
//  	@Test // Test 5: Test for failing grade when mark is 0
//  	public void test_GradeCalculatorReturnsFailWhenResultEqualTo0() {
//  		// Arrange: Set up the mock behaviour
//        when(gradeCalculator.getClassification(0.0)).thenReturn("fail");
//
//  		// Act: Call the getClassification method to get the result
//  		String result = gradeCalculator.getClassification(0.0);
//
//  		// Assert: Compare the actual result with the expected message ("fail")
//  		assertEquals("fail", result);
//  	}
//  	
//  	@Test // Test 6: Test for passing grade where it is on passing threshold
//  	public void test_GradeCalculatorReturnsPassWhenResultEqualToSeventyFive() {
//  		// Arrange: Set up the mock behaviour
//        when(gradeCalculator.getClassification(75.0)).thenReturn("pass");
//
//  		// Act: Call the getClassification method to get the result
//  		String result = gradeCalculator.getClassification(75.0);
//
//  		// Assert: Compare the actual result with the expected message ("fail")
//  		assertEquals("pass", result);
//  	}
//
//  	@Test // Test 7: Test for pass grade just below merit threshold
//  	public void test_GradeCalculatorReturnsPassWhenResultJustBelowEighty() {
//  		// Arrange: Set up the mock behaviour
//        when(gradeCalculator.getClassification(79.9)).thenReturn("pass");
//
//  		// Act: Call the getClassification method to get the result
//  		String result = gradeCalculator.getClassification(79.9);
//
//  		// Assert: Compare the actual result with the expected message ("pass")
//  		assertEquals("pass", result);
//  	}
//
//  	@Test // Test 8: Test for invalid grade above perfect score
//  	public void test_GradeCalculatorReturnsErrorMessageWhenResultGreaterThan100() {
//  	    // Arrange: Set up the mock behaviour
//  	    when(gradeCalculator.getClassification(101.0)).thenThrow(new IllegalArgumentException("Invalid grade: 101.0"));
//
//  	    // Act and Assert
//  	    assertThrows(IllegalArgumentException.class, () -> {
//  	        gradeCalculator.getClassification(101.0);
//  	    });
//  	}
//  
//  	@Test // Test 9: Test for negative grade
//    public void test_GradeCalculatorThrowsExceptionWhenResultIsNegative() {
//        // Arrange: Set up the mock behaviour to throw an exception
//        when(gradeCalculator.getClassification(-10.0)).thenThrow(new IllegalArgumentException("Invalid grade: -10.0"));
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> {
//            gradeCalculator.getClassification(-10.0);
//        });
//    }
//}
package com.fdmgroup.tdd.gradecalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class GradeCalculatorServiceTest {
	@Test // Test 1: Test for failing grade
	public void test_GradeCalculatorReturnsFailWhenResultLessThan75() {
	// Arrange: Create an instance of the GradeCalculator class
		GradeCalculator gc = new GradeCalculator();
	        
		// Set a failing grade value and the expected message
		double failingGrade = 60.0;
		String message = "fail";

		// Act: Call the getClassification method to get the result       
		String result = gc.getClassification(failingGrade);
	        
		// Assert: Compare the actual result with the expected message ("fail")
		assertEquals(message, result);
	}
	@Test // Test 2: Test for passing grade
	public void test_GradeCalculatorReturnsPassWhenResultGreaterThanOrEqualTo75AndLessThan80() {
		// Arrange: Create an instance of the GradeCalculator class
	    GradeCalculator gc = new GradeCalculator();
	        
	    // Set a passing grade value and the expected message
	    double passingGrade = 76.0;
	    String message = "pass";
	        
	    // Act: Call the getClassification method to get the result  
	    String result = gc.getClassification(passingGrade);

	    // Assert: Compare the actual result with the expected message ("pass")
	    assertEquals(message, result);
	}

	@Test // Test 3: Test for merit grade
	public void test_GradeCalculatorReturnsMeritWhenResultGreaterThanOrEqualTo80AndLessThan90() {
		// Arrange: Create an instance of the GradeCalculator class
	    GradeCalculator gc = new GradeCalculator();
	        
	    // Set a merit grade value and the expected message
	    double meritGrade = 89.0;
	    String message = "merit";

	    // Act: Call the getClassification method to get the result  
	    String result = gc.getClassification(meritGrade);

	    // Assert: Compare the actual result with the expected message ("merit")
	    assertEquals(message, result);
	}

	@Test // Test 4: Test for distinction grade
	public void test_GradeCalculatorReturnsDistinctionWhenResultGreaterThanOrEqualTo90AndLessThanOrEqualTo100() {
		// Arrange: Create an instance of the GradeCalculator class
	    GradeCalculator gc = new GradeCalculator();
	        
	    // Set a distinction grade value and the expected message
	    double distinctionGrade = 99.0;
	    String message = "distinction";

	    // Act: Call the getClassification method to get the result
	    String result = gc.getClassification(distinctionGrade);

	    // Assert: Compare the actual result with the expected message ("distinction")
	    assertEquals(message, result);
	}
	    
	@Test // Test 5: Test for failing grade when mark is 0
	public void test_GradeCalculatorReturnsFailWhenResultEqualTo0() {
		// Arrange: Create an instance of the GradeCalculator class
	    GradeCalculator gc = new GradeCalculator();
	        
	    // Set a lowest possible mark and the expected message
	    double failingGrade = 0.0; 
	    String message = "fail";

	    // Act: Call the getClassification method to get the result
	    String result = gc.getClassification(failingGrade);

	    // Assert: Compare the actual result with the expected message ("fail")
	    assertEquals(message, result);
	}

	@Test // Test 6: Test for passing grade (edge case: on passing threshold)
	public void test_GradeCalculatorReturnsPassWhenResultEqualToSeventyFive() {
		// Arrange: Create an instance of the GradeCalculator class
	    GradeCalculator gc = new GradeCalculator();
	        
	    // Set a grade value n the passing threshold and the expected message
	    double passingGrade = 75.0;
	    String message = "pass";

	    // Act: Call the getClassification method to get the result
	    String result = gc.getClassification(passingGrade);

	    // Assert: Compare the actual result with the expected message ("fail")
	    assertEquals(message, result);
	}

	@Test // Test 7: Test for pass grade (edge case: just below merit threshold)
	public void test_GradeCalculatorReturnsPassWhenResultJustBelowEighty() {
		// Arrange: Create an instance of the GradeCalculator class
	    GradeCalculator gc = new GradeCalculator();
	        
	    // Set a grade value n just below the merit threshold and the expected message
	    double passGrade = 79.9;
	    String message = "pass";

	    // Act: Call the getClassification method to get the result
	    String result = gc.getClassification(passGrade);

	    // Assert: Compare the actual result with the expected message ("pass")
	    assertEquals(message, result);
	 }
	
	@Test // Test 8: Test for invalid grade (edge case: above perfect score)
	public void test_GradeCalculatorThrowsExceptionWhenResultGreaterThan100() {
	    // Arrange
	    GradeCalculator gc = new GradeCalculator();
	    double invalidGrade = 101.0; // Above the perfect score

	    // Act and Assert
	    // We expect an IllegalArgumentException to be thrown when the grade is greater than 100
	    assertThrows(IllegalArgumentException.class, () -> {
	        gc.getClassification(invalidGrade);
	    });
	}

	    
	 @Test // Test 9: Test for negative grade
	 public void test_GradeCalculatorThrowsExceptionWhenResultIsNegative() {
		 // Arrange
		 GradeCalculator gc = new GradeCalculator();
		 double negativeGrade = -10.0; // Negative grade value

		 // Act and Assert
		 // We expect an IllegalArgumentException to be thrown when the grade is negative
	     assertThrows(IllegalArgumentException.class, () -> {
	    	 gc.getClassification(negativeGrade);
	     });
	 }
}

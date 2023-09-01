package com.fdmgroup.bookstoretdd;

// Import required packages and classes
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.ArrayList;

// Define the test class
public class CheckoutTest {
	// Declare instance variables
    private Checkout checkout;
    private Basket basket;

    // Run this method before each test
    @BeforeEach
    public void setUp() {
    	// Initialise an empty list of books and create a basket
        ArrayList<Book> books = new ArrayList<>();
        basket = new Basket(books);
        // Create a checkout instance using the basket
        checkout = new Checkout(basket);
    }

    // Test case: Calculate price for an empty basket
    @Test
    public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket() {
    // Act: Calculate the price
    double totalPrice = checkout.calculatePrice(basket);
    // Assert: Check if the total price is zero
    assertEquals(0.0, totalPrice);
    }

    // Parameterized test: Calculate price for different sets of book prices
    @ParameterizedTest
    @CsvSource({
    // CSV source data for Parameterised test: Calculate price for different sets of book prices
     "25.99, 25.99",
     "10.0, 15.0, 25.0",
     "25.99, 25.99, 25.99, 77.19",
     "25.99, 25.99, 25.99, 25.99, 25.99, 25.99, 25.99, 178.29",
     "25.99, 25.99, 25.99, 25.99, 25.99, 25.99, 25.99, 25.99, 25.99, 25.99, 226.11"
    })
    
    public void test_CalculatePrice_ReturnsCorrectPrice(@ConvertWith(DoubleArrayConverter.class) double[] prices) {
    	// Arrange: Add books to the basket with specified prices
        addBooksToBasket(prices);
        // Act: Calculate the discounted price
        double discountedPrice = checkout.calculatePrice(basket);
        // Assert: Calculate the expected total and compare with the calculated price
        double expectedTotal = calculateExpectedTotal(prices);
        assertEquals(expectedTotal, discountedPrice, 0.01); // Specify delta for comparing doubles
    }

    @Test
    public void test_CalculatePrice_ReturnsCorrectPriceForSingleBook() {
        double bookPrice = 10.0;
        addBooksToBasket(bookPrice);
        double discountedPrice = checkout.calculatePrice(basket);
        assertEquals(bookPrice, discountedPrice, 0.01);
    }

    @Test
    public void test_CalculatePrice_ReturnsCorrectPriceForMaximumDiscountQuantity() {
        double bookPrice = 10.0;
        int maxDiscountQuantity = 10;
        addBooksToBasket(bookPrice, maxDiscountQuantity);
        double expectedTotal = calculateExpectedTotal(bookPrice, maxDiscountQuantity);
        double discountedPrice = checkout.calculatePrice(basket);
        assertEquals(expectedTotal, discountedPrice, 0.01);
    }

    @Test
    public void test_CalculatePrice_ReturnsCorrectPriceForCombinationOfDiscounts() {
        double bookPrice = 10.0;
        int numberOfBooks = 13; // Qualifies for both discounts
        addBooksToBasket(bookPrice, numberOfBooks);
        double expectedTotal = calculateExpectedTotal(bookPrice, numberOfBooks);
        double discountedPrice = checkout.calculatePrice(basket);
        assertEquals(expectedTotal, discountedPrice, 0.01);
    }

    @Test
    public void test_CalculatePrice_ThrowsExceptionForInvalidInputs() {
        Book bookWithNegativePrice = new Book();
        bookWithNegativePrice.setPrice(-10.0);
        
        // Add the book with negative price to the basket before calling calculatePrice
        basket.addBook(bookWithNegativePrice);
        
        // Use a lambda expression for the assertThrows parameter to ensure the exception is thrown within the lambda
        assertThrows(IllegalArgumentException.class, () -> {
            checkout.calculatePrice(basket);
        });
    }

    // Helper method: Add books to the basket with given prices
    private void addBooksToBasket(double... prices) {
    	for (double price : prices) {
    		Book book = new Book();
            book.setPrice(price);
            basket.addBook(book);
        }
    }

    // Helper method: Calculate the expected total price after applying discounts
    private double calculateExpectedTotal(double... prices) {
        double total = 0.0;
        for (double price : prices) {
            total += price;
        }
        int numberOfBooksInBasket = prices.length;

        // Calculate discount based on the number of full sets of three books
        int numberOfFullSets = numberOfBooksInBasket / 3;
        double totalDiscount = numberOfFullSets * 0.01;

        // Apply additional 10% discount if there are 10 or more books
        if (numberOfBooksInBasket >= 10) {
            totalDiscount += 0.10;
        }

        // Calculate discounted price
        double discountedPrice = total - (total * totalDiscount);
        return discountedPrice;
    }


    // Custom argument converter
    public static class DoubleArrayConverter extends SimpleArgumentConverter {
    	// Constructor for the custom argument converter
    	public DoubleArrayConverter() {
        // No need to do anything in the constructor
        }

        // Convert the source object to double array
        @Override
        protected Object convert(Object source, Class<?> targetType) {
        	if (source instanceof String && targetType.isAssignableFrom(double[].class)) {
        		// Split the source string and convert to double array
        		String[] tokens = ((String) source).split(",");
                double[] result = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                	result[i] = Double.parseDouble(tokens[i]);
                }
                return result;
             }
             // Throw an exception for unsupported conversion
             throw new IllegalArgumentException("Conversion from " + source.getClass() + " to " + targetType + " not supported.");
        }
    }
}

package com.fdmgroup.bookstoretdd;

import java.util.ArrayList;

public class Checkout {
    // Constructor takes a Basket instance, but not used in the provided code
    public Checkout(Basket basket) {
        // TODO Auto-generated constructor stub
    }

    // Method to calculate the discounted price of the books in the basket
    public double calculatePrice(Basket basket) {
        double totalPrice = 0.0;
        int numberOfBooksInBasket = 0;

        // Get the list of books from the basket
        ArrayList<Book> bookList = basket.getBooksInBasket();

        // Calculate the total price and count of books
        for (Book book : bookList) {
            double bookPrice = book.getPrice();
            
            // Ensure book price is non-negative
            if (bookPrice < 0) {
                throw new IllegalArgumentException("Book price cannot be negative.");
            }
            
            // Add book price to total and increment book count
            totalPrice += bookPrice;
            numberOfBooksInBasket++;
        }

        // Calculate discount based on the number of full sets of three books
        double totalDiscount = calculateTotalDiscount(numberOfBooksInBasket);

        // Calculate additional 10% discount for 10 or more books
        totalDiscount += calculateAdditionalDiscount(numberOfBooksInBasket);

        // Apply the discount to the total price
        double discountedPrice = applyDiscount(totalPrice, totalDiscount);
        return discountedPrice;
    }

    // Method to calculate discount based on the number of books
    private double calculateTotalDiscount(int numberOfBooks) {
        // calculating total discount based on book count
        double totalDiscount = (numberOfBooks / 3) * 0.01;
        return totalDiscount;
    }

    // Method to calculate additional discount for 10 or more books
    private double calculateAdditionalDiscount(int numberOfBooks) {
        // calculating additional discount for 10 or more books
        double additionalDiscount = (numberOfBooks >= 10) ? 0.10 : 0.0;
        return additionalDiscount;
    }

    // Method to apply discount to total price
    private double applyDiscount(double totalPrice, double totalDiscount) {
        // applying discount to total price
        double discountedPrice = totalPrice - (totalPrice * totalDiscount);
        return discountedPrice;
    }
}

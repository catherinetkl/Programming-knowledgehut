package com.fdmgroup.bookstoretdd;

//Import the required library
import java.util.ArrayList;

//Define the Basket class
public class Basket {
	// Declare an instance variable to store the list of books
	ArrayList<Book> bookList;

	// Constructor to initialize the Basket with a list of books
	public Basket(ArrayList<Book> books) {
		// Assign the provided list of books to the instance variable
		this.bookList = books;
	}

	// Method to retrieve the list of books in the basket
	public ArrayList<Book> getBooksInBasket() {
		// Return the list of books stored in the instance variable
		return bookList;
	}

	// Method to add a book to the basket
	public void addBook(Book book) {
	    if (bookList.size() >= getMaxBooks()) {
	        throw new IllegalArgumentException("Basket is full. Cannot add more books.");
	    }
	    if (book != null) {
	        bookList.add(book);
	    } else {
	        throw new IllegalArgumentException("Invalid book. Cannot add null book.");
	    }
	}

	// Method to remove a specific book from the basket
	public void removeBook(Book book) {
		// Remove the provided book from the list of books
		bookList.remove(book);
	}

	// Method to get the quantity of a specific book in the basket
	public int getQuantity(Book book) {
		// Initialize a variable to store the book's quantity
		int quantity = 0;

		// Iterate through the book list to count occurrences of the specific book
		for (Book b : bookList) {
			if (b.equals(book)) {
				quantity++;
			}
		}

		// Return the calculated quantity
    	return quantity;
	}

	public int getMaxBooks() {
		// TODO Auto-generated method stub
		return 100;
	}
}

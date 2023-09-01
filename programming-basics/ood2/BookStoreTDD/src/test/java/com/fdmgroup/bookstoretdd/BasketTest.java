package com.fdmgroup.bookstoretdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class BasketTest {

    private Basket basket; // Declare a Basket instance

    @BeforeEach
    public void setUp() {
        // Create an empty book list and initialize the basket before each test
        ArrayList<Book> books = new ArrayList<>();
        basket = new Basket(books);
    }

    @Test
    public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded() {
        // åWhen no books have been added, the book list in the basket should be empty.
        ArrayList<Book> booksInBasket = basket.getBooksInBasket();
        assertTrue(booksInBasket.isEmpty());
    }

    @Test
    public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
        // After adding one book to the basket, the book list should have a length of one.
        Book book = new Book();
        basket.addBook(book);
        ArrayList<Book> booksInBasket = basket.getBooksInBasket();
        assertEquals(1, booksInBasket.size());
    }

    @Test
    public void test_GetBooksInBasket_ReturnsArrayOfLengthTwo_AfterAddBookMethodIsCalledTwice() {
        // After adding the same book twice to the basket, the book list should have a length of two.
        Book book = new Book();
        basket.addBook(book);
        basket.addBook(book);
        ArrayList<Book> booksInBasket = basket.getBooksInBasket();
        assertEquals(2, booksInBasket.size());
    }

    @Test
    public void test_AddingSameBookMultipleTimes_IncreasesQuantityInBasket() {
        // Adding the same book multiple times should increase its quantity in the basket.
        Book book = new Book();
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        int quantity = basket.getQuantity(book);
        assertEquals(3, quantity);
    }

    @Test
    public void test_RemoveBookFromBasket_UpdatesQuantity() {
        // Removing a book from the basket should update its quantity.
        Book book = new Book();
        basket.addBook(book);
        basket.addBook(book);
        basket.removeBook(book);
        int quantity = basket.getQuantity(book);
        assertEquals(1, quantity);
    }

    @Test
    public void test_RemoveLastBookFromBasket_RemovesBookFromList() {
        // Removing the last book from the basket should result in an empty book list.
        Book book = new Book();
        basket.addBook(book);
        basket.removeBook(book);
        int quantity = basket.getQuantity(book);
        assertEquals(0, quantity);
    }

    @Test
    public void test_AddMaxNumberOfBooksToBasket_BehavesAsExpected() {
        int maxBooks = basket.getMaxBooks();
        Book book = new Book();
        
        // Add the maximum number of books to the basket
        for (int i = 0; i < maxBooks; i++) {
            basket.addBook(book);
        }

        // Verify that the basket size matches the maximum book count
        assertEquals(maxBooks, basket.getBooksInBasket().size());

        // Verify that adding one more book throws an exception
        assertThrows(IllegalArgumentException.class, () -> basket.addBook(book));
    }
    
    @Test
    public void test_AddInvalidBookToBasket_ThrowsException() {
        // Adding an invalid or null book to the basket should throw an exception.
        // You need to implement this test case based on how your system handles invalid inputs.
        Book invalidBook = null;

        // Verify that adding an invalid book throws an exception
        assertThrows(IllegalArgumentException.class, () -> basket.addBook(invalidBook));
    }
    @Test
    public void test_GetQuantityForNonExistingBook_ReturnsZero() {
        // Getting the quantity of a book that doesn't exist in the basket should return zero.
        Book book = new Book();
        int quantity = basket.getQuantity(book);
        assertEquals(0, quantity);
    }

    @Test
    public void test_RemoveNonExistingBook_DoesNotThrowException() {
        // Removing a book that doesn't exist in the basket should not throw an exception.
        Book book = new Book();
        assertDoesNotThrow(() -> basket.removeBook(book));
    }
}

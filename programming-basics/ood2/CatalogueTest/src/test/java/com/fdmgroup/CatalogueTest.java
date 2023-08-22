package com.fdmgroup;

//Import necessary libraries and annotations
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Apply the Mockito extension to set up the test environment
@ExtendWith(MockitoExtension.class)
public class CatalogueTest {
	private Catalogue catalogue;

	// Create a mock instance of ReadItemCommand
	@Mock
	private ReadItemCommand read;

	// Create a mock instance of Book
	@Mock
	private Book mockBook;

	// Create an empty list to simulate the book catalog
	private ArrayList<Book> bookList;
 
	// Create a mock instance of WriteItemCommand
	@Mock
	private WriteItemCommand write;

	// Set up the test environment before each test method
	@BeforeEach
	public void beforeEach() throws Exception {
		// Initialize the mock objects and fields
		MockitoAnnotations.openMocks(this);

		// Create an empty list of books
		this.bookList = new ArrayList<>();
     
		// Instantiate the Catalogue object with the mock ReadItemCommand and the empty bookList
		this.catalogue = new Catalogue(bookList, read, write);
	}

	// Test Case 1: Ensure getAllBooks() returns an empty list if no books are in the catalog
	@Test
	public void getAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue() {
		// Stub the readAll() method of mock ReadItemCommand to return an empty list
		when(read.readAll()).thenReturn(new ArrayList<>());

		// Call the method being tested
		ArrayList<Book> returnedBooks = catalogue.getAllBooks();

		// Assert that the returned list is empty
		assertEquals(0, returnedBooks.size());
	}

	// Test Case 2: Verify that getAllBooks() calls the readAll() method of ReadItemCommand
	@Test
	public void getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled() {
		// Call the method being tested
		catalogue.getAllBooks();

		// Verify that the readAll() method is called exactly once
		verify(read, times(1)).readAll();
	}

	// Test Case 3: Ensure getAllBooks() returns the list of books from readAll() method
	@Test
	public void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled() {
		// Arrange: Create a list of mockBook instances
		List<Book> expectedBooks = createExpectedBooksList(mockBook, mockBook);

		// Stub the readAll() method of mock ReadItemCommand to return the expectedBooks list
		when(read.readAll()).thenReturn((ArrayList<Book>) expectedBooks);

		// Act: Call the method being tested
		ArrayList<Book> returnedBooks = catalogue.getAllBooks();

		// Assert: Verify that the returned list matches the expectedBooks list
		assertEquals(expectedBooks, returnedBooks);
	}

	// Helper method: Create a list of books from varargs
	private ArrayList<Book> createExpectedBooksList(Book... books) {
		return new ArrayList<>(Arrays.asList(books));
	}
	
	/* Test Case 4: addBook method of Catalogue should pass the book 
	it is given to the insertItem method of WriteItemCommand */
	@Test
	public void addBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled() {
		// Arrange: Create a mock Book instance
		Book mockBook = mock(Book.class);
		
		// Arrange: Create a mock instance of WriteItemCommand
		WriteItemCommand write = mock(WriteItemCommand.class);
		
		// Arrange: Update the Catalogue with the mock WriteItemCommand
		catalogue = new Catalogue(bookList, read, write);
		// Act: Call the method being tested
		catalogue.addBook(mockBook);
		// Assert: Verify that the insertItem method is called with the mock Book
		verify(write, times(1)).insertItem(mockBook);
	}
	
	// Test Case 5: addBooks method should call insertItem method for each book
	@Test
	public void addBook_CallsInsertItemMethodForAllBooks_WhenCalled() {
		
		// Arrange: Create a list of mock Book instances
	    ArrayList<Book> mockBooks = new ArrayList<>(Arrays.asList(mock(Book.class), mock(Book.class), mock(Book.class)));
	    
	    // Arrange: Create a mock instance of WriteItemCommand
	    WriteItemCommand write = mock(WriteItemCommand.class);
	    
	    // Update the Catalogue with the mock WriteItemCommand
	    catalogue = new Catalogue(bookList, read, write);
	    
	    // Act: Call the method being tested
	    catalogue.addBooks(mockBooks);

	    // Assert: Verify that the insertItem method is called for each mock Book
	    for (Book mockBook : mockBooks) {
	        verify(write, times(1)).insertItem(mockBook);
	    }
	}
	
	/* Test Case 6: getBook(String isbn) method should call getItem(String id) to
	return book with the same ISBN as the one requested */
	@Test
	public void getBook_ReturnsBookWithMatchingISBN_WhenCalled() {
		// Arrange: Create a mock Book instance
	    Book mockBook = mock(Book.class);
	    String requestedISBN = "9780262033848"; 
	    
	    // Stub the getItem() method of mock ReadItemCommand to return the mockBook
	    when(read.getItem(requestedISBN)).thenReturn(mockBook);
	    
	    // Act: Call the method being tested
	    Book returnedBook = catalogue.getBook(requestedISBN);
	    
	    // Assert: Verify that the returned book matches the mockBook
	    assertEquals(mockBook, returnedBook);
	}

	// Test Case 7: deleteBook method should call deleteItem method for the provided book
	@Test
	public void deleteBook_CallsDeleteItemMethod_WhenCalled() {
	    // Arrange: Create a mock Book instance
	    Book mockBook = mock(Book.class);

	    // Act: Call the method being tested
	    catalogue.deleteBook(mockBook);

	    // Assert: Verify that the deleteItem method is called with the mock Book
	    verify(write, times(1)).deleteItem(mockBook);
	}
	
	// Test Case 8: deleteAllBooks method should call readAll method and then deleteItem method for each book
	@Test
	public void deleteAllBooks_CallsReadAllAndDeleteItemMethods_WhenCalled() {
	    // Arrange: Create a list of mock Book instances
	    ArrayList<Book> mockBooks = new ArrayList<>(Arrays.asList(mock(Book.class), mock(Book.class), mock(Book.class)));

	    // Stub the readAll method of mock ReadItemCommand to return the mockBooks list
	    when(read.readAll()).thenReturn(mockBooks);

	    // Act: Call the method being tested
	    catalogue.deleteBooks(mockBooks);

	    // Assert: Verify that the readAll method is called exactly once
	    verify(read, times(1)).readAll();

	    // Verify that the deleteItem method is called for each mock Book
	    for (Book mockBook : mockBooks) {
	        verify(write, times(1)).deleteItem(mockBook);
	    }
	}
}
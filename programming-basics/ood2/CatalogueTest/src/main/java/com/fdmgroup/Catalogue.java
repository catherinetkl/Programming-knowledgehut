package com.fdmgroup;

import java.util.ArrayList;

public class Catalogue {
    private ArrayList<Book> bookList;
    private ReadItemCommand readItemCommand;
    private WriteItemCommand writeItemCommand;

    public Catalogue(ArrayList<Book> bookList, ReadItemCommand readItemCommand, WriteItemCommand writeItemCommand) {
        this.bookList = bookList;
        this.readItemCommand = readItemCommand;
        this.writeItemCommand = writeItemCommand;
    }

    public ArrayList<Book> getAllBooks() {
        if (readItemCommand != null) {
            return readItemCommand.readAll();
        } else {
            return bookList;
        }
    }
    public void addBook(Book book) {
    	writeItemCommand.insertItem(book);
    }
    
    public void addBooks(ArrayList<Book> books) {
    	for (Book book : books) {
    		writeItemCommand.insertItem(book);
    	}
    }
    
    public Book getBook(String isbn) {
    	return readItemCommand.getItem(isbn);
    }
    
    public void deleteBook(Book book) {
    	writeItemCommand.deleteItem(book);
    }
    
    public void deleteBooks(ArrayList<Book> books) {
    	bookList = readItemCommand.readAll();
    	for (Book book: bookList) {
    		writeItemCommand.deleteItem(book);
    	}
    }
}


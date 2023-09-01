package com.fdmgroup;

//Entity class - POJO Plain old Java object
public class Book {
	private String isbn;

	public Book(String isbn) {
		super();
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

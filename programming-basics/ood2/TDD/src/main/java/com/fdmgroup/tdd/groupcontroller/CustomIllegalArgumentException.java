package com.fdmgroup.tdd.groupcontroller;

//Custom exception class for invalid arguments
@SuppressWarnings("serial")
public class CustomIllegalArgumentException extends IllegalArgumentException {
	// Constructor to set the exception message
	public CustomIllegalArgumentException(String message) {
		super(message);
	}
}
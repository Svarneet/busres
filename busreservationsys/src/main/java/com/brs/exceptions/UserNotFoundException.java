package com.brs.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		System.out.println("Route not found");
	}
}
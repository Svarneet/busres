package com.brs.exceptions;

@SuppressWarnings("serial")
public class AdminNotFoundException extends Exception {
	public AdminNotFoundException() {
		System.out.println("Admin id not found");

	}

}
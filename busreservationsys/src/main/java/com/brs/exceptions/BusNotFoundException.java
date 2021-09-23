package com.brs.exceptions;

@SuppressWarnings("serial")
public class BusNotFoundException extends Exception {
	public BusNotFoundException() {
		System.out.println("bus id not found");

	}
}
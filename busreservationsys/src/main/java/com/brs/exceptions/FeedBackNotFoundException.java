package com.brs.exceptions;

@SuppressWarnings("serial")
public class FeedBackNotFoundException extends Exception {
	public FeedBackNotFoundException() {
		System.out.println("Route not found");
	}
}

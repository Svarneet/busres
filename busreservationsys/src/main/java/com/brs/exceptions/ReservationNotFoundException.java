package com.brs.exceptions;

@SuppressWarnings("serial")
public class ReservationNotFoundException extends Exception {
	public ReservationNotFoundException() {
		System.out.println("Reservation not found for given id");
	}
}

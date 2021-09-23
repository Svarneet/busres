
package com.brs.exceptions;

@SuppressWarnings("serial")
public class RouteNotFoundException extends Exception {
	public RouteNotFoundException() {
		System.out.println("Route not found");
	}
}
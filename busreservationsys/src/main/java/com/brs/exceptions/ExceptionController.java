package com.brs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleBusNotFoundException(BusNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(ReservationNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleReservationNotFoundException(ReservationNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleRouteNotFoundException(RouteNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error, HttpStatus.OK);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(FeedBackNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleFeedBackNotFoundException(FeedBackNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error, HttpStatus.OK);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error, HttpStatus.OK);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
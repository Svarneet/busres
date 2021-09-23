package com.brs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Reservation;
import com.brs.service.IBusService;
import com.brs.service.IReservationService;

/**
 * Description:This is ReservationController Layer
 **/
@RestController
@RequestMapping("rest/api")

public class ReservationController {
	Logger log = Logger.getLogger("ReservationController");
	@Autowired
	IReservationService reservationService;

	@Autowired
	IBusService customerService;

	/**
	 * Description :To update feedback details into the database Return Value
	 * :feedback object of the feedback been fetched
	 **/

	@GetMapping("/reservations/{id}")
	public ResponseEntity<Reservation> viewReservation(@PathVariable("id") int id) {
		log.info("viewreservation method");
		return new ResponseEntity<>(reservationService.viewReservation(id), HttpStatus.OK);
	}

	/**
	 * Description :To add reservation details into the database Return Value
	 * :reservation object of the reservation been fetched
	 **/

	@PostMapping("/reservations")
	public ResponseEntity<Reservation> addReservation(@Valid @RequestBody Reservation reservation) {
		log.info("addreservation method");
		Reservation newVal = reservationService.addReservation(reservation);
		return new ResponseEntity<>(newVal, HttpStatus.OK);
	}

	/**
	 * Description :To update reservation details into the database Return Value
	 * :reservation object of the reservation been fetched
	 **/
	@PutMapping("/reservations/update")
	public ResponseEntity<Reservation> updateReservation(@Valid @RequestBody Reservation reservation) {
		log.info("updatereservation method");
		Reservation newVal = reservationService.updateReservation(reservation);
		return new ResponseEntity<>(newVal, HttpStatus.OK);
	}

	/**
	 * Description :To view all reservation details in the database Return Value
	 * :list of reservation objects of the reservation been fetched
	 **/
	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> viewAllReservation() {
		log.info("viewallreservation method");
		List<Reservation> lstReservation = reservationService.viewAllReservation();
		return new ResponseEntity<List<Reservation>>(lstReservation, HttpStatus.OK);
	}

	/**
	 * Description :To delete reservation details by id in the database Return Value
	 * :reservation object of the reservation deleted been fetched
	 **/

	@DeleteMapping("/reservations/{id}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Long id) {
		log.info("deletereservation method");
		Reservation deleted = reservationService.deleteReservation(id);
		return new ResponseEntity<Reservation>(deleted, HttpStatus.OK);

	}

}

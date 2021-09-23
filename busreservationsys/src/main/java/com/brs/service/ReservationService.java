package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Reservation;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.repository.IReservationRepository;

/**
 * Description:This is Reservation Service Class that provides the services to
 * add a Reservation, remove a Reservation, update a Reservation and view a
 * Reservation
 **/

@Service
@Transactional
public class ReservationService implements IReservationService {

	@Autowired
	private IReservationRepository reservationRepo;

	@Override
	/**
	 * Description :To add Reservation to the database Input Params : Reservation
	 * object to be added to the database Return Value : Reservation Object
	 **/
	public Reservation addReservation(Reservation reservation) {
		Reservation newReservation = reservationRepo.save(reservation);
		System.out.println(newReservation + "****************");
		return newReservation;

	}

	/**
	 * Description :To update Reservation in the database Input Params : Reservation
	 * object to be added to the database Return Value : Reservation Object
	 * Exception : Reservation NotFoundException-raised when Reservation Id not
	 * found
	 **/

	@Override
	public Reservation updateReservation(Reservation reservation) throws NullPointerException {

		Reservation retrievedReservation = null;
		try {
			retrievedReservation = reservationRepo.findById(reservation.getReservationId())
					.orElseThrow(ReservationNotFoundException::new);
		} catch (Exception e) {
			e.printStackTrace();
		}
		retrievedReservation.setReservationId(reservation.getReservationId());
		retrievedReservation.setReservationStatus(reservation.getReservationStatus());
		retrievedReservation.setReservationDate(reservation.getReservationDate());
		retrievedReservation.setReservationTime(reservation.getReservationTime());
		retrievedReservation.setSource(reservation.getSource());
		retrievedReservation.setDestination(reservation.getDestination());
		retrievedReservation.setReservationType(reservation.getReservationType());

		return reservationRepo.save(retrievedReservation);

	}

	/**
	 * Description :To view Reservation in the database Input Params : Reservation
	 * id whose Reservation object should be viewed in the database Return Value :
	 * Reservation Object Exception : Reservation NotFoundException-raised when
	 * Reservation Id not found
	 **/

	@Override
	public Reservation viewReservation(long id) {

		Reservation retVal = null;
		try {
			retVal = reservationRepo.findById(id).orElseThrow(ReservationNotFoundException::new);
		} catch (ReservationNotFoundException e) {
			e.printStackTrace();
		}
		return retVal;

	}

	/**
	 * Description :To delete Reservation from the database Input Params :
	 * Reservation object to be deleted from the database Return Value : Reservation
	 * Object Exception : Reservation NotFoundException-raised when Reservation Id
	 * not found
	 **/

	@Override
	public Reservation deleteReservation(Long id) {

		Reservation retrVal = null;
		try {
			retrVal = reservationRepo.findById(id).orElseThrow(ReservationNotFoundException::new);
			reservationRepo.deleteById(id);

		} catch (ReservationNotFoundException e) {

			e.printStackTrace();
		}
		return retrVal;

	}

	/**
	 * Description :To view all the Reservation in the database Return Value :list
	 * of Reservation Objects
	 **/

	@Override
	public List<Reservation> viewAllReservation() {
		List<Reservation> retVal = null;
		retVal = reservationRepo.findAll();
		return retVal;
	}

}

package com.brs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Reservation;

@Service
@Transactional
public interface IReservationService {
	public Reservation addReservation(Reservation reservation);

	public Reservation updateReservation(Reservation reservation);

	public Reservation viewReservation(long id);

	public Reservation deleteReservation(Long id);

	public List<Reservation> viewAllReservation();
}

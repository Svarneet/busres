package com.brs.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("deprecation")
@Entity
public class Reservation {
	/*
	 * Entity Name : Reservation Used Annotation
	 * : @Entity, @Id, @NotNull,@NotBlank,@OnetoOne,@Coulmn,@Pattern validation :
	 * Bean validation is done Description : Entity class for Reservation
	 */
	@Id
	@ForeignKey(name = "tripId")
	@NotNull(message = "Id cannot be null")
	@Column(name = "reservationId", nullable = false, unique = true, length = 20)
	private @NotNull(message = "Id cannot be null") Long reservationId;
	// Bean validation to check The status.
	@Column(name = "reservationStatus", nullable = false, length = 20)
	@NotBlank(message = "status cannot be blank")
	@Pattern(regexp = "accepted|cancelled", message = "reservation type should be either accepted or cancelled")
	private String reservationStatus;
	// Bean validation to check The type.
	@Column(name = "reservationType", nullable = false, length = 20)
	@NotBlank(message = "type cannot be blank")
	@Pattern(regexp = "cornerseat|middleseat", message = "reservation type should be either cornerseat or middleseat")
	private String reservationType;
	@Column(name = "reservationDate", nullable = false, length = 20)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate reservationDate;
	@Column(name = "reservationTime", nullable = false, length = 20)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime reservationTime;
	// Bean validation for a valid source
	@Column(name = "source", nullable = false, length = 20)
	@NotBlank(message = "source cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "source must only be alphabets and whitespaces from 3 to 20 characters")
	private String source;
	// Bean validation for a valid destination
	@Column(name = "destination", nullable = false, length = 20)
	@NotBlank(message = "destination cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "destination must only be alphabets and whitespaces from 3 to 20 characters")
	private String destination;
	@OneToOne(targetEntity = Bus.class)
	private Bus bus;
	@OneToOne(targetEntity = User.class)
	private User users;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public LocalTime getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reservationId == null) ? 0 : reservationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (reservationId == null) {
			if (other.reservationId != null)
				return false;
		} else if (!reservationId.equals(other.reservationId))
			return false;
		return true;
	}

	public Reservation(@NotNull(message = "Id cannot be null") long id,
			@NotBlank(message = "status cannot be blank") @Pattern(regexp = "accepted|cancelled", message = "reservation type should be either accepted or cancelled") String reservationStatus,
			@NotBlank(message = "type cannot be blank") @Pattern(regexp = "cornerseat|middleseat", message = "reservation type should be either cornerseat or middleseat") String reservationType,
			LocalDate reservationDate, LocalTime reservationTime,
			@NotBlank(message = "source cannot be blank") @Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "source must only be alphabets and whitespaces from 3 to 20 characters") String source,
			@NotBlank(message = "destination cannot be blank") @Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "destination must only be alphabets and whitespaces from 3 to 20 characters") String destination,
			Bus bus, User users) {
		super();
		this.reservationId = id;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
		this.users = users;
	}

	public Reservation() {
		super();
	}

}
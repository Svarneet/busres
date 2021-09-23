package com.brs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Users")
public class User {
	/*
	 * Entity Name : User Used Annotation
	 * : @Entity, @Id, @NotNull,@NotBlank,@Coulmn,@Pattern validation : Bean
	 * validation is done Description : Entity class for User
	 */

	@Id
	@Column(name = "userLoginId", nullable = false, unique = true, length = 50)
	private long userLoginId;
	@Column(name = "userName", nullable = false, length = 50)
	@NotBlank(message = "username cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,15}$", message = "username must only be alphabets from 3 to 15 characters")
	// Bean validation to check The userName.
	private String userName;
	@Column(name = "password", nullable = false, length = 50)
	@NotBlank(message = "password cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,15}$", message = "password must only be alphabets from 3 to 15 characters")
	// Bean validation to check The password.
	private String password;
	@Column(name = "firstName", nullable = false, length = 50)
	@NotBlank(message = "firstname cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,15}$", message = "firstname must only be alphabets from 3 to 15 characters")
	// Bean validation to check The firstName.
	private String firstName;
	@Column(name = "lastName", nullable = false, length = 50)
	@NotBlank(message = "lastname cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,15}$", message = "lastname must only be alphabets from 3 to 15 characters")
	// Bean validation to check The lastName.
	private String lastName;
	@Column(name = "contact", nullable = false, length = 50)
	@NotBlank(message = "contact cannot be blank")
	@Pattern(regexp = "([7-9][0-9]{9})", message = "contact should start from 7/8/9 and contain 10 digits ")
	// Bean validation to check The contact.
	private String contact;
	@Column(name = "email", nullable = false, length = 50)
	@NotBlank(message = "email cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email must have character/number/./- befor & after @")
	// Bean validation to check The email.
	private String email;

	@OneToOne(targetEntity = Reservation.class)
	private Reservation reservation;
	@OneToOne(targetEntity = FeedBack.class)
	private FeedBack feedback;

	public long getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(long userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userLoginId ^ (userLoginId >>> 32));
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
		User other = (User) obj;
		if (userLoginId != other.userLoginId)
			return false;
		return true;
	}

	public User(int userLoginId, String userName, String password, String firstName, String lastName, String contact,
			String email) {

	}

	public User() {
		super();
	}

}
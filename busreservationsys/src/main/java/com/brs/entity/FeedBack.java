package com.brs.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FeedBack {
	/*
	 * Entity Name : FeedBack Used Annotation
	 * : @Entity, @Id, @NotNull,@NotBlank, @OneToOne, @JoinCoulmn,@Pattern
	 * validation : Bean validation is done Description : Entity class for FeedBack
	 */
	@Id

	private int feedBackId;
	@NotNull(message = "driver rating cannot be null")
	@Column(name = "driverRating", nullable = false, unique = true, length = 20)

	private int driverRating;
	@NotNull(message = "service rating cannot be null")
	@Column(name = "serviceRating", nullable = false, unique = true, length = 20)

	private int serviceRating;
	@NotNull(message = "overall rating cannot be null")
	@Column(name = "overallRating", nullable = false, unique = true, length = 20)

	private int overallRating;
	@Column(name = "comments", nullable = false, length = 20)
	@NotBlank(message = "comments cannot be blank")
	@Pattern(regexp = "^([A-Za-z]{3,20})$", message = "comments must only be alphabets and whitespaces from 3 to 20 characters")
	private String comments;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Column(name = "feedbackdate", nullable = false, unique = true, length = 20)
	private LocalDate feedbackdate;
	@OneToOne(targetEntity = User.class)
	private User users;
	@OneToOne(targetEntity = Bus.class)
	private Bus bus;

	public FeedBack(int i, int j, int k, int l, String string, LocalDate date, User user1, Bus bus1) {
	}

	public int getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}

	public int getDriverRating() {
		return driverRating;
	}

	public void setDriverRating(int driverRating) {
		this.driverRating = driverRating;
	}

	public int getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(int serviceRating) {
		this.serviceRating = serviceRating;
	}

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getFeedbackdate() {
		return feedbackdate;
	}

	public void setFeedbackdate(LocalDate feedbackdate) {
		this.feedbackdate = feedbackdate;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
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
		result = prime * result + feedBackId;
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
		FeedBack other = (FeedBack) obj;
		if (feedBackId != other.feedBackId)
			return false;
		return true;
	}

	public FeedBack() {
		super();
	}

}
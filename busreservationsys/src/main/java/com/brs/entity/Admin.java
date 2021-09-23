package com.brs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Admin {
	/*
	 * Entity Name : Admin Used Annotation : @Entity, @Id Description : Entity class
	 * for Admin
	 */

	@Id
	@Column(name = "adminId", nullable = false, unique = true, length = 20)
	@NotNull(message = "Id cannot be null")
	private int adminId;
	@Column(name = "adminUsername", nullable = false, length = 20)
	private String adminUsername;
	@Column(name = "password", nullable = false, unique = true, length = 20)
	private String adminPassword;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Admin(int adminId, String adminUsername, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public Admin() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result + ((adminPassword == null) ? 0 : adminPassword.hashCode());
		result = prime * result + ((adminUsername == null) ? 0 : adminUsername.hashCode());
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
		Admin other = (Admin) obj;
		if (adminId != other.adminId)
			return false;
		if (adminPassword == null) {
			if (other.adminPassword != null)
				return false;
		} else if (!adminPassword.equals(other.adminPassword))
			return false;
		if (adminUsername == null) {
			if (other.adminUsername != null)
				return false;
		} else if (!adminUsername.equals(other.adminUsername))
			return false;
		return true;
	}

}
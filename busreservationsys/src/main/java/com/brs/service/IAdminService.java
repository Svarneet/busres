package com.brs.service;

import com.brs.entity.Admin;
import com.brs.exceptions.AdminNotFoundException;

public interface IAdminService {
	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(Admin admin);

	public Admin deleteAdmin(int adminId) throws AdminNotFoundException;

	public Admin viewAdmin(int adminId) throws AdminNotFoundException;

}
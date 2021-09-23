package com.brs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Admin;
import com.brs.exceptions.AdminNotFoundException;
import com.brs.repository.IAdminRepository;

/**
 * Description:This is Admin Service Class that provides the services to add an
 * admin, remove an admin, update an admin and view an admin
 **/
@Service
@Transactional
public class AdminService implements IAdminService {
	@Autowired
	IAdminRepository adminrepo;

	/**
	 * Description :To add admin to the database Input Params :admin object to be
	 * added to the database Return Value :admin Object
	 **/
	@Override
	public Admin addAdmin(Admin admin) {
		return adminrepo.save(admin);
	}

	/**
	 * Description :To update Admin in the database Input Params :Admin object to be
	 * added to the database Return Value :Admin Object Exception
	 * :AdminNotFoundException-raised when Admin Id not found
	 **/
	@Override
	public Admin updateAdmin(Admin admin) {
		Admin updateAdmin = null;
		try {
			updateAdmin = adminrepo.findById((int) admin.getAdminId()).orElseThrow(AdminNotFoundException::new);

		} catch (AdminNotFoundException e) {

			e.printStackTrace();
		}
		updateAdmin.setAdminId(admin.getAdminId());
		updateAdmin.setAdminUsername(admin.getAdminUsername());
		updateAdmin.setAdminPassword(admin.getAdminPassword());
		return adminrepo.save(updateAdmin);
	}

	/**
	 * Description :To delete Admin from the database Input Params :admin object to
	 * be deleted from the database Return Value :admin Object Exception
	 * :adminNotFoundException-raised when admin Id not found
	 **/
	@Override
	public Admin deleteAdmin(int adminId) {
		Admin admin = null;
		try {
			admin = adminrepo.findById(adminId).orElseThrow(AdminNotFoundException::new);
			adminrepo.delete(admin);
		} catch (AdminNotFoundException e) {
			e.printStackTrace();
		}
		return admin;
	}

	/**
	 * Description :To view admin in the database Input Params :admin id whose admin
	 * object should be viewed in the database Return Value :admin Object Exception
	 * :adminNotFoundException-raised when admin Id not found
	 **/
	@Override
	public Admin viewAdmin(int adminId) throws AdminNotFoundException {
		Admin a = null;
		try {
			a = adminrepo.findById(adminId).orElseThrow(AdminNotFoundException::new);
		} catch (AdminNotFoundException e) {
			e.printStackTrace();
		}
		return a;
	}
}
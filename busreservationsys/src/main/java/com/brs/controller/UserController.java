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
import org.springframework.web.bind.annotation.RestController;
import com.brs.entity.User;
import com.brs.exceptions.UserNotFoundException;
import com.brs.service.IUserService;

/**
 * Description:This is UserController Layer
 **/
@RestController
public class UserController {
	Logger log = Logger.getLogger("UserController");
	@Autowired
	private IUserService userservice;

	/**
	 * Description :To add user details into the database Return Value :user object
	 * of the user been fetched
	 **/
	@PostMapping("addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		log.info("adduser method");
		return new ResponseEntity<User>(userservice.addUser(user), HttpStatus.OK);
	}

	/**
	 * Description :To update user details into the database Return Value :user
	 * object of the user been fetched
	 **/
	@PutMapping("updateUser")
	public ResponseEntity<User> updateuser(@Valid @RequestBody User user) {
		log.info("update user method");
		return new ResponseEntity<User>(userservice.updateUser(user), HttpStatus.OK);
	}

	/**
	 * Description :To delete user details from the database Return Value :user
	 * object of the user been fetched
	 **/
	@DeleteMapping("deleteUser/{Userid}")
	public ResponseEntity<User> deleteUser(@PathVariable("Userloginid") int userLoginId) {
		log.info("deleteuser method");
		return new ResponseEntity<User>(userservice.deleteUser(userLoginId), HttpStatus.OK);

	}

	/**
	 * Description :To view user details in the database Return Value :user object
	 * of the user been fetched
	 **/
	@GetMapping("view/{Userid}")
	public ResponseEntity<User> getUserById(@PathVariable("Userloginid") int userLoginId) throws UserNotFoundException {
		log.info("viewuser by id method");
		return new ResponseEntity<User>(userservice.viewUser((long) userLoginId), HttpStatus.OK);
	}

	/**
	 * Description :To view all user details in the database Return Value :user
	 * object of the user been fetched
	 **/
	@GetMapping("alluser")
	public ResponseEntity<List<User>> getAllUser() {
		log.info("viewalluser method");
		return new ResponseEntity<List<User>>(userservice.viewAllUser(), HttpStatus.OK);
	}
}
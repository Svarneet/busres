package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brs.exceptions.UserNotFoundException;
import com.brs.entity.User;
import com.brs.repository.IUserRepository;

@Service
@Transactional
/**
 * Description:This is User Service Class that provides the services to add a
 * User, remove a User, update a User and view a User
 **/
public class UserService implements IUserService {
	@Autowired
	private IUserRepository userrepo;

	/**
	 * Description :To add User to the database Input Params :User object to be
	 * added to the database Return Value :User Object
	 **/
	@Override
	public User addUser(User user) {
		return userrepo.save(user);

	}

	/**
	 * Description :To update User in the database Input Params :User object to be
	 * added to the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 **/

	@Override
	public User updateUser(User user) {
		User updateUser = null;
		try {
			updateUser = userrepo.findById(user.getUserLoginId()).orElseThrow(UserNotFoundException::new);

		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		updateUser.setUserLoginId(user.getUserLoginId());
		updateUser.setUserName(user.getUserName());
		updateUser.setPassword(user.getPassword());
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setContact(user.getContact());
		updateUser.setEmail(user.getEmail());

		return userrepo.save(updateUser);

	}

	/**
	 * Description :To delete User from the database Input Params :User object to be
	 * deleted from the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 **/
	@Override
	public User deleteUser(int userId) {
		User user = null;
		try {
			user = userrepo.findById((long) userId).orElseThrow(UserNotFoundException::new);
			userrepo.delete(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Description :To view User in the database Input Params :User id whose User
	 * object should be viewed in the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 **/

	@Override
	public User viewUser(Long userId) throws UserNotFoundException {
		User b = null;
		try {
			b = userrepo.findById(userId).orElseThrow(UserNotFoundException::new);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Description :To view all the User in the database Return Value :list of User
	 * Objects
	 **/

	@Override
	public List<User> viewAllUser() {

		return userrepo.findAll();
	}

}

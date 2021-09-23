package com.brs.service;

import java.util.List;

import com.brs.entity.User;
import com.brs.exceptions.UserNotFoundException;

public interface IUserService {

	User addUser(User user);

	User updateUser(User user);

	User deleteUser(int userId);

	User viewUser(Long userId) throws UserNotFoundException;

	List<User> viewAllUser();

}

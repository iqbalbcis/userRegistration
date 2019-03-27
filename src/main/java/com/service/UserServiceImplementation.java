package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDaoImplementation;
import com.model.User;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserDaoImplementation userDaoImplementation;

	@Override
	public void insertData(User user) {
		
		userDaoImplementation.save(user);
	}

	@Override
	public User getUser(String username, String password) {

		User user = userDaoImplementation.getUser(username, password);

		if (user != null) {
			return user; // a user was found
		}

		// if no user was found we throw an exception
		throw new IllegalArgumentException("Invalid credentials");

	}

	@Override
	public User find(long userId) {

		return userDaoImplementation.find(userId);
	}
	
	@Override
	public boolean authenticate(String username, String password) {

		return userDaoImplementation.getUser(username, password) !=null;
	}

	@Override
	public boolean exists(String username) {

		return userDaoImplementation.exists(username);
	}

	@Override
	public List<User> getAllUsers() {

		return userDaoImplementation.getAllUsers();
	}

	@Override
	public void deleteUser(long id) {

		userDaoImplementation.deleteUser(id);
	}

	@Override
	public void updateUser(User e) {

		userDaoImplementation.updateUser(e);
	}

	@Override
	public List<User> getEmployeeByName(String fName) {
		
		return userDaoImplementation.getEmployeeByName(fName);
	}
}

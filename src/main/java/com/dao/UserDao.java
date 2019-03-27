package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	
	void save(User user);

    /*
      Retrieve a user from the database with the given username and password.
     */
    User getUser(String username, String password);

    /*
     * Retrieve a user from the database with the given userId.
     */
    User find(long userId);

    /*
     * Does a user with the given username exist on the database.
     * @return true if a user with this username already exists, otherwise false
     */
    boolean exists(String username);
    
    //--get all user from database
    List<User> getAllUsers();
    
    //for specific user
    List<User> getEmployeeByName(String fName);
    
    //--delete specific user---
    void deleteUser(long id);
    
    //--update specific user---
    void updateUser(User e);
    
}

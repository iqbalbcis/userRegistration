package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	void insertData(User user);
	
    User getUser(String username, String password);
    
    User find(long userId);  
    
    boolean authenticate(String username, String password);
    
    boolean exists(String username);
    
    //for specific user
    List<User> getEmployeeByName(String fName);
    
    //--get all user from database
    List<User> getAllUsers();
    
    //--delete specific user---
    void deleteUser(long id);
    
    //--update specific user---
    void updateUser(User e);
}

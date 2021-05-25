package com.revature.service;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	
	User loginUser(String userName, String password);

	User getUserById(int id);
	User getUserByUserName(String uName);
	List<User> getAllUsers();
	List<User> getAllEmployees();
	List<User> getAllManagers();
	
	boolean addUser(User user);
	
	boolean changeUserInfo(User user);
	
	void modifyUser(User user, String fName, String lName, String password, String email);
	
	boolean removeUser(int id);
	
	boolean checkIfNewUser(String userName);
	//Encrpyt password
	
}

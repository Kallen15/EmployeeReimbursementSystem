package com.revature.repository;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {

	User selectUserById(int id);
	User selectUserByUserName(String uName);
	List<User> selectAllUsers();
	List<User> selectAllEmployees();
	List<User> selectAllManagers();
	
	boolean insertUser(User user);
	
	boolean updateUserInfo(User user);
	
	boolean deleteUser(int id);
}

package com.revature.service;

import java.util.List;

import com.revature.models.User;
import com.revature.repository.UserDAO;

public class UserServiceImpl implements UserService{
	
	private UserDAO ud;

	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserDAO ud) {
		this.ud = ud;
	}
	
	public User loginUser(String userName, String password) {
		User loginUser = null;
		boolean passwordMatch;
		
		loginUser = getUserByUserName(userName);
		
		if(loginUser != null) {
			passwordMatch = loginUser.getPassword().compareTo(password) == 0;
			if(passwordMatch) {
				return loginUser;
			}
		}
			
		return null;
	}

	@Override
	public User getUserById(int id) {
		return ud.selectUserById(id);
	}

	@Override
	public User getUserByUserName(String uName) {
		return ud.selectUserByUserName(uName);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> uList = ud.selectAllUsers();
		
		return uList;
	}

	@Override
	public List<User> getAllEmployees() {
		List<User> empList = ud.selectAllEmployees();
		return empList;
	}

	@Override
	public List<User> getAllManagers() {
		List<User> manaList = ud.selectAllManagers();
		return manaList;
	}

	@Override
	public boolean addUser(User user) {
		return ud.insertUser(user);
	}

	@Override
	public boolean changeUserInfo(User user) {
		return ud.updateUserInfo(user);
	}

	@Override
	public boolean removeUser(int id) {
		return ud.deleteUser(id);
	}

	@Override
	public void modifyUser(User user, String firstName, String lastName, String password, String email) {
		if(firstName.compareTo(user.getFirstName()) != 0 && firstName.compareTo("") != 0) {
			user.setFirstName(firstName);
		}
		
		if(lastName.compareTo(user.getLastName()) != 0 && lastName.compareTo("") != 0) {
			user.setLastName(lastName);
		}
		
		if(password.compareTo(user.getPassword()) != 0 && password.compareTo("") != 0) {
			user.setPassword(password);
		}
		
		if(email.compareTo(user.getEmail()) != 0 && email.compareTo("") != 0) {
			user.setEmail(email);
		}
		
	}

	@Override
	public boolean checkIfNewUser(String userName) {
		List<User> userList = getAllUsers();
		
		for(User u: userList) {
			if(userName.compareTo(u.getUserName()) == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
}

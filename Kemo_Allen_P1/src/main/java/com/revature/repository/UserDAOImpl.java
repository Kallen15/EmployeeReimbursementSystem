package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ERSConnection;

public class UserDAOImpl implements UserDAO{
	
	private final Logger LOG = Logger.getLogger(UserDAOImpl.class);
	//private static Connection conn = ERSConnection.getConnection();
	
	public UserDAOImpl() {
		super();
	}

	@Override
	public User selectUserById(int id) {
		User user = null;
		
		String sql = "SELECT * FROM ers_users WHERE ers_user_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User(rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getInt(7));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when selecting a user.");
		}
		
		return user;
	}

	@Override
	public User selectUserByUserName(String uName) {
		User user = null;
		
		String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uName);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User(rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getInt(7));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when selecting a user.");
		}
		
		return user;
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> userList = new LinkedList<>();
		
		String sql = "SELECT * from ers_users";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userList.add(new User(rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getInt(7)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting multiple users.");
		}
		return userList;
	}

	@Override
	public List<User> selectAllEmployees() {
		List<User> empList = new LinkedList<>();
		int roleId = 1; //Employee ID
		
		String sql = "SELECT * from ers_users WHERE user_role_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				empList.add(new User(rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getInt(7)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting multiple users.");
		}
		return empList;
	}

	@Override
	public List<User> selectAllManagers() {
		List<User> manaList = new LinkedList<>();
		int roleId = 2; //Manager ID
		
		String sql = "SELECT * from ers_users WHERE user_role_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				manaList.add(new User(rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getInt(7)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting multiple users.");
		}
		return manaList;
	}

	@Override
	public boolean insertUser(User user) {
		boolean success = false;
		String sql = "INSERT INTO ers_users "
				+ "(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) "
				+ "VALUES (?,?,?,?,?,?)";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getUserRole());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when inserting a user.");
		}
		return success;
	}

	@Override
	public boolean updateUserInfo(User user) {
		boolean success = false;
		String sql = "UPDATE ers_users SET ers_password=?, user_first_name=?, user_last_name=?, user_email=? "
				+ "WHERE ers_user_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when updating a user.");
		}
		return success;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean success = false;
		String sql = "DELETE FROM ers_users WHERE ers_user_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when deleting a user.");
		}
		return success;
	}
	
}

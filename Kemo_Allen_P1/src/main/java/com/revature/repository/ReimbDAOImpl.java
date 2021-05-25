package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.util.ERSConnection;

public class ReimbDAOImpl implements ReimbursementDAO{

	private final Logger LOG = Logger.getLogger(ReimbDAOImpl.class);
	//private static ERSConnection conn = new ERSConnection();
	
	public ReimbDAOImpl() {
		super();
	}

	@Override
	public Reimbursement selectReimbursementById(int id) {
		Reimbursement reimb = null;
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimb = new Reimbursement(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getDouble(5),
						rs.getBytes(6),
						rs.getObject(7, LocalDateTime.class),
						rs.getObject(8, LocalDateTime.class),
						rs.getInt(9),
						rs.getString(10));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting a reimbursement.");
		}
		return reimb;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByAuthor(int id) {
		List<Reimbursement> reimbList = new LinkedList<>();
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbList.add(new Reimbursement(rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getDouble(5),
								rs.getBytes(6),
								rs.getObject(7, LocalDateTime.class),
								rs.getObject(8, LocalDateTime.class),
								rs.getInt(9),
								rs.getString(10)));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting multiple reimbursements.");
		}
		return reimbList;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByResolver(int id) {
		List<Reimbursement> reimbList = new LinkedList<>();
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_resolver = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbList.add(new Reimbursement(rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getDouble(5),
								rs.getBytes(6),
								rs.getObject(7, LocalDateTime.class),
								rs.getObject(8, LocalDateTime.class),
								rs.getInt(9),
								rs.getString(10)));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting multiple reimbursements.");
		}
		return reimbList;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByStatus(int status) {
		List<Reimbursement> reimbList = new LinkedList<>();
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbList.add(new Reimbursement(rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getDouble(5),
								rs.getBytes(6),
								rs.getObject(7, LocalDateTime.class),
								rs.getObject(8, LocalDateTime.class),
								rs.getInt(9),
								rs.getString(10)));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting multiple reimbursements.");
		}
		return reimbList;
	}
	
	@Override
	public List<Reimbursement> selectReimbursementsByType(int type){
		List<Reimbursement> reimbList = new LinkedList<>();
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_type_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, type);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbList.add(new Reimbursement(rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getDouble(5),
								rs.getBytes(6),
								rs.getObject(7, LocalDateTime.class),
								rs.getObject(8, LocalDateTime.class),
								rs.getInt(9),
								rs.getString(10)));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting multiple reimbursements.");
		}
		return reimbList;
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		List<Reimbursement> reimbList = new LinkedList<>();
		String sql = "SELECT * FROM ers_reimbursement";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbList.add(new Reimbursement(rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getDouble(5),
								rs.getBytes(6),
								rs.getObject(7, LocalDateTime.class),
								rs.getObject(8, LocalDateTime.class),
								rs.getInt(9),
								rs.getString(10)));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when getting multiple reimbursements.");
		}
		return reimbList;
	}

	@Override
	public boolean insertReimbursement(Reimbursement reimb) {
		boolean success = false;
		String sql = "INSERT INTO ers_reimbursement (reimb_author, reimb_status_id, "
				+ "reimb_amount, reimb_receipt, reimb_submitted, reimb_type_id, "
				+ "reimb_description) VALUES(?,?,?,?,?,?,?)";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimb.getAuthorId());
			ps.setInt(2, reimb.getReimbStatus());
			ps.setDouble(3, reimb.getReimbAmount());
			ps.setBytes(4, reimb.getReimbReceipt());
			ps.setObject(5, reimb.getReimbSubmitted());
			ps.setInt(6, reimb.getReimbType());
			ps.setString(7, reimb.getReimbDescription());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when adding a reimbursement.");
		}
		return success;
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimb) {
		boolean success = false;
		String sql = "UPDATE ers_reimbursement SET reimb_resolver = ?, reimb_status_id = ?, "
				+ "reimb_resolved = ? WHERE reimb_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimb.getResolverId());
			ps.setInt(2, reimb.getReimbStatus());
			ps.setObject(3, reimb.getReimbResolved());
			ps.setInt(4, reimb.getId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when updating a reimbursement.");
		}
		return success;
	}

	@Override
	public boolean deleteReimbursementById(int id) {
		boolean success = false;
		String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
		
		try(Connection conn = ERSConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.info("There was an issue when deleting a reimbursement.");
		}
		return success;
	}
}

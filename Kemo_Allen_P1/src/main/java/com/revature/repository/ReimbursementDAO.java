package com.revature.repository;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement selectReimbursementById(int id);
	List<Reimbursement> selectReimbursementsByAuthor(int id);
	List<Reimbursement> selectReimbursementsByResolver(int id);
	List<Reimbursement> selectReimbursementsByStatus(int status);
	List<Reimbursement> selectReimbursementsByType(int type);
	List<Reimbursement> selectAllReimbursements();
	
	boolean insertReimbursement(Reimbursement reimb);
	
	boolean updateReimbursement(Reimbursement reimb);
	
	boolean deleteReimbursementById(int id);

}

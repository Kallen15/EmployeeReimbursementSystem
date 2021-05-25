package com.revature.service;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementService {

	Reimbursement getReimbursementById(int id);
	List<Reimbursement> getReimbursementsByAuthor(int id);
	List<Reimbursement> getReimbursementsByResolver(int id);
	List<Reimbursement> getReimbursementsByStatus(int status);
	List<Reimbursement> getReimbursementsByType(int type);
	List<Reimbursement> getAllReimbursements();
	List<Reimbursement> getReimbursementsByAuthorAndStatus(int id, int status);
	List<Reimbursement> getResolvedReimbursements();
	List<Reimbursement> getUserResolvedReimbursements(int id);
	
	boolean addReimbursement(Reimbursement reimb);
	
	boolean changeReimbursement(Reimbursement reimb);
	
	boolean removeReimbursementById(int id);
	
	boolean checkIfUnresolved(int id);
}

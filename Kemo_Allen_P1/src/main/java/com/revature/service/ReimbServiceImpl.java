package com.revature.service;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.models.Reimbursement;
import com.revature.repository.ReimbursementDAO;

public class ReimbServiceImpl implements ReimbursementService{
	
	private ReimbursementDAO rd;

	public ReimbServiceImpl() {
		super();
	}
	
	public ReimbServiceImpl(ReimbursementDAO rd) {
		this.rd = rd;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		return rd.selectReimbursementById(id);
	}

	@Override
	public List<Reimbursement> getReimbursementsByAuthor(int id) {
		List<Reimbursement> reimbList = rd.selectReimbursementsByAuthor(id);
		return reimbList;
	}

	@Override
	public List<Reimbursement> getReimbursementsByResolver(int id) {
		List<Reimbursement> reimbList = rd.selectReimbursementsByResolver(id);
		return reimbList;
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(int status) {
		List<Reimbursement> reimbList = rd.selectReimbursementsByStatus(status);
		return reimbList;
	}
	
	@Override
	public List<Reimbursement> getReimbursementsByType(int type){
		List<Reimbursement> reimbList = rd.selectReimbursementsByType(type);
		return reimbList;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbList = rd.selectAllReimbursements();
		return reimbList;
	}

	@Override
	public boolean addReimbursement(Reimbursement reimb) {
		return rd.insertReimbursement(reimb);
	}

	@Override
	public boolean changeReimbursement(Reimbursement reimb) {
		return rd.updateReimbursement(reimb);
	}

	@Override
	public boolean removeReimbursementById(int id) {
		return rd.deleteReimbursementById(id);
	}

	@Override
	public List<Reimbursement> getReimbursementsByAuthorAndStatus(int id, int status) {
		List<Reimbursement> reimbList = rd.selectReimbursementsByAuthor(id);
		return reimbList.stream().filter(x -> x.getReimbStatus() == status).collect(Collectors.toList());
	}
	
	@Override
	public List<Reimbursement> getResolvedReimbursements(){
		List<Reimbursement> reimbList = getAllReimbursements();
		return reimbList.stream().filter(x -> x.getReimbStatus() != 0).collect(Collectors.toList());
	}
	
	@Override
	public List<Reimbursement> getUserResolvedReimbursements(int id){
		List<Reimbursement> reimbList = getReimbursementsByAuthor(id);
		return reimbList.stream().filter(x -> x.getReimbStatus() != 0).collect(Collectors.toList());
	}

	@Override
	public boolean checkIfUnresolved(int id) {
		List<Reimbursement> reimbList = getReimbursementsByStatus(0);
		
		for(Reimbursement r: reimbList) {
			if(r.getId() == id) {
				return true;
			}
		}
		
		return false;
	}

}

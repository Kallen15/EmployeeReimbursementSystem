package com.revature.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Reimbursement implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer authorId; //Employee
	private Integer resolverId; //Manager
	private Integer reimbStatus; //0 - no action / 2 rejected / 1 accepted
	private Double reimbAmount;
	private byte[] reimbReceipt;
	private LocalDateTime reimbSubmitted; //Time sent
	private LocalDateTime reimbResolved; //Time resolved //Use DateTime in sql
	private Integer reimbType; // 1 - LODGING / 2 - FOOD ....
	private String reimbDescription; // Details of reimbType
	//receipt
	
	public Reimbursement() {
		super();
		
	}
	
	public Reimbursement(Integer id, Integer authorId, Integer resolverId, Integer reimbStatus, Double reimbAmount,
			byte[] reimbReceipt, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved, Integer reimbType,
			String reimbDescription) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.reimbStatus = reimbStatus;
		this.reimbAmount = reimbAmount;
		this.reimbReceipt = reimbReceipt;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbType = reimbType;
		this.reimbDescription = reimbDescription;
	}
	
	

	public Reimbursement(Integer id, Integer authorId, Integer resolverId, Integer reimbStatus, Double reimbAmount,
			byte[] reimbReceipt, Integer reimbType, String reimbDescription) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.reimbStatus = reimbStatus;
		this.reimbAmount = reimbAmount;
		this.reimbReceipt = reimbReceipt;
		this.reimbType = reimbType;
		this.reimbDescription = reimbDescription;
	}

	public byte[] getReimbReceipt() {
		return reimbReceipt;
	}
	public void setReimbReceipt(byte[] reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public Integer getResolverId() {
		return resolverId;
	}
	public void setResolverId(Integer resolverId) {
		this.resolverId = resolverId;
	}
	public Integer getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(Integer reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public Double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(Double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public LocalDateTime getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(LocalDateTime reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public LocalDateTime getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(LocalDateTime reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public Integer getReimbType() {
		return reimbType;
	}
	public void setReimbType(Integer reimbType) {
		this.reimbType = reimbType;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reimbAmount == null) ? 0 : reimbAmount.hashCode());
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + Arrays.hashCode(reimbReceipt);
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + ((resolverId == null) ? 0 : resolverId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reimbAmount == null) {
			if (other.reimbAmount != null)
				return false;
		} else if (!reimbAmount.equals(other.reimbAmount))
			return false;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (!Arrays.equals(reimbReceipt, other.reimbReceipt))
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (resolverId == null) {
			if (other.resolverId != null)
				return false;
		} else if (!resolverId.equals(other.resolverId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", authorId=" + authorId + ", resolverId=" + resolverId + ", reimbStatus="
				+ reimbStatus + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbType=" + reimbType + ", reimbDescription="
				+ reimbDescription + "]";
	}
	
}

package com.ymba.beans;



public class CurrentRequest {
	private int employee_id;
	private int event_id;
	private String date;
	private String status;
	private String empComments;
	private String denialReason;
	private double amountApproval;
	private int supeID;
	private String supeApprovalDate;
	private int headID;
	private String headApprovalDate;
	private int bencoID;
	private String bencoApprovalDate;
	
	public CurrentRequest() {
		
	}
	public CurrentRequest (int event_id,String date,String status,String empComments,String denialReason, double amountApproval,int supeID, String supeApprovalDate,int headID,String headApprovalDate,int bencoID,String bencoApprovalDate) {
		this.event_id= event_id;
		this.date=date;
		this.status=status;
		this.empComments=empComments;
		this.denialReason=denialReason;
		this.amountApproval=amountApproval;
		this.supeID=supeID;
		this.supeApprovalDate=supeApprovalDate;
		this.headID=headID;
		this.headApprovalDate=headApprovalDate;
		this.bencoID=bencoID;
		this.bencoApprovalDate=bencoApprovalDate;
	}

	

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmpComments() {
		return empComments;
	}

	public void setEmpComments(String empComments) {
		this.empComments = empComments;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public double getAmountApproval() {
		return amountApproval;
	}

	public void setAmountApproval(double amountApproval) {
		this.amountApproval = amountApproval;
	}

	public int getSupeID() {
		return supeID;
	}

	public void setSupeID(int supeID) {
		this.supeID = supeID;
	}

	public String getSupeApprovalDate() {
		return supeApprovalDate;
	}

	public void setSupeApprovalDate(String supeApprovalDate) {
		this.supeApprovalDate = supeApprovalDate;
	}

	public int getHeadID() {
		return headID;
	}

	public void setHeadID(int headID) {
		this.headID = headID;
	}

	public String getHeadApprovalDate() {
		return headApprovalDate;
	}

	public void setHeadApprovalDate(String headApprovalDate) {
		this.headApprovalDate = headApprovalDate;
	}

	public int getBencoID() {
		return bencoID;
	}

	public void setBencoID(int bencoID) {
		this.bencoID = bencoID;
	}

	public String getBencoApprovalDate() {
		return bencoApprovalDate;
	}

	public void setBencoApprovalDate(String bencoApprovalDate) {
		this.bencoApprovalDate = bencoApprovalDate;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [employee_id=" + employee_id + ", event_id=" + event_id + ", date=" + date
				+ ", status=" + status + ", empComments=" + empComments + ", denialReason=" + denialReason
				+ ", amountApproval=" + amountApproval + ", supeID=" + supeID + ", supeApprovalDate=" + supeApprovalDate
				+ ", headID=" + headID + ", headApprovalDate=" + headApprovalDate + ", bencoID=" + bencoID
				+ ", bencoApprovalDate=" + bencoApprovalDate + "]";
	}

	
}

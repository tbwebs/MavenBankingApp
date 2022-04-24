package com.revature.project0.models;

// this class holds data to link status to account database, either pending/open/closed
public class Status {

	private int statusId;
	private String status;
	
	public Status() { super(); }
	
	public Status(int statusId, String status) {
		this.statusId = statusId;
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AccountStatus [statusId=" + statusId + ", status=" + status + "]";
	}
	
	
	
}

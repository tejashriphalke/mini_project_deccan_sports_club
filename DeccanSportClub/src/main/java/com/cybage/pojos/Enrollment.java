package com.cybage.pojos;

import java.sql.Date;

public class Enrollment {

	private int enrollId;
	private String username;
	private int batchId;
	private Date startDate ;
	private Date endDate;
	private String mStatus;
	public Enrollment() {
		super();
	}
	public Enrollment(int enrollId, String username, int batchId, Date startDate, Date endDate, String mStatus) {
		super();
		this.enrollId = enrollId;
		this.username = username;
		this.batchId = batchId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mStatus = mStatus;
	}
	public int getEnrollId() {
		return enrollId;
	}
	public void setEnrollId(int enrollId) {
		this.enrollId = enrollId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	@Override
	public String toString() {
		return "Enrollment [enrollId=" + enrollId + ", username=" + username + ", batchId=" + batchId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", mStatus=" + mStatus + "]";
	}
	




}

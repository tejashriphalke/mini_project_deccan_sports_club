package com.cybage.pojos;

import java.sql.Date;

public class Batch {
	private int batchId ;
	private Date startDate;
	private Date endDate ;
	private int batchSize;
	private int sportId;
	private int planId;
	public Batch() {
		super();
	}
	public Batch(int batchId, Date startDate, Date endDate, int batchSize, int sportId, int planId) {
		super();
		this.batchId = batchId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.batchSize = batchSize;
		this.sportId = sportId;
		this.planId = planId;
	}
	public Batch(Date startDate, Date endDate, int batchSize, int sportId, int planId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.batchSize = batchSize;
		this.sportId = sportId;
		this.planId = planId;
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
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public int getSportId() {
		return sportId;
	}
	public void setSportId(int sportId) {
		this.sportId = sportId;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", startDate=" + startDate + ", endDate=" + endDate + ", batchSize="
				+ batchSize + ", sportId=" + sportId + ", planId=" + planId + "]";
	}
	


}

package com.cybage.services;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.cybage.dao.ManagerDaoI;
import com.cybage.dao.ManagerDaoImpl;
import com.cybage.pojos.Users;
import com.cybage.pojos.AllBatchInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Sports;

public class ManagerServiceImpl implements ManagerServiceI{
	//Manager Dao obj is created
	ManagerDaoI manager=new ManagerDaoImpl();

	//code for date manipulation it converts Date in string format to date into Date.sql format
	public java.sql.Date getDate(String date) {			
		return Date.valueOf(date);  
	}	
	//adding record into Batch table
	public int addBatch(Batch batch) throws Exception {		
		return manager.addBatch(batch);
	}
	//removing record from Batch table
	public int removeBatch(int batchId) throws Exception {
		return manager.removeBatch(batchId);
	}
	//getting single record from a batch
	public Batch getBatch(int batchId) throws Exception{
		return manager.getBatch(batchId);
	}
	//updating record from Batch table
	public int updateBatch(Batch batch) throws Exception {		
		return manager.updateBatch(batch);
	}
	//getting list of all the batches
	public List<AllBatchInfo> getAllBatches() throws Exception {
		return manager.getAllBatches();	
	}
	//geeting manager by username
	public Users getManager(String username) throws Exception {		
		return manager.getManager(username);
	}
	//getting list of all the enrolled members
	public List<AllBatchInfo> getAllEnrolledMembers() throws Exception {
		return manager.getAllEnrolledMembers();
	}
	public List<AllBatchInfo> getActionedMembers() throws Exception
	{
		return manager.getActionedMembers();
	}
	//approve the emembership
	public int approveEnrollment(Enrollment enrlmnt)throws Exception{
		return manager.approveEnrollment(enrlmnt);
	}
	//reject enrollment so he cant get enrolled into membership
	public int rejectEnrollment(Enrollment enrlmnt)throws Exception{
		return manager.rejectEnrollment(enrlmnt);
	}
	//update the batchsize after member get enrolled i.e decrease the count by one
	public int updateBatchSize(int enrollId,int batchSize)throws Exception{
		return manager.updateBatchSize(enrollId, batchSize);
	}	
	//add plans	
	public int addPlan(Plans plan) throws Exception {
		return manager.addPlan(plan);
	}
	//remove plans
	public int removePlan(int planId) throws Exception {
		return manager.removePlan(planId);
	}
	//update plans
	public int updatePlan(Plans plan) throws Exception {
		return manager.updatePlan(plan);
	}
	//get list of all the plans
	public List<Plans> getAllPlans() throws Exception {
		return manager.getAllPlans();
	}
	//get plan by plan id
	public Plans getPlan(int planId) throws Exception {
		return manager.getPlan(planId);
	}
	//get plan by name
	public Plans getPlanByName(String planName) throws Exception {		
		return manager.getPlanByName(planName);
	}
}
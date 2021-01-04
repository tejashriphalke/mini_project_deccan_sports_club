package com.cybage.services;



import java.sql.Date;
import java.util.List;

import com.cybage.pojos.Users;
import com.cybage.pojos.AllBatchInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Sports;

public interface ManagerServiceI {	
	//functions for performing opertaions on Batch Tables
	public Batch getBatch(int batchId) throws Exception;
	public int addBatch(Batch batch) throws Exception;
	public Date getDate(String date);
	public int removeBatch(int batchId)throws Exception;
	public int updateBatch(Batch batch) throws Exception;		
	//Funtions for performing operations on Users table
	public Users getManager(String username)throws Exception;
	//Funtions for DTO AllBatchInfo
	public List<AllBatchInfo> getAllBatches()throws Exception;
	public List<AllBatchInfo> getAllEnrolledMembers() throws Exception;
	public List<AllBatchInfo> getActionedMembers() throws Exception;
	//functions for performing operations on Enrollment table
	public int approveEnrollment(Enrollment enrlmnt)throws Exception;
	public int rejectEnrollment(Enrollment enrlmnt)throws Exception ;
	public int updateBatchSize(int enrollId,int batchSize)throws Exception;
	
	//functions for performing operations on Plan Tbale
	public List<Plans> getAllPlans()throws Exception;
	public Plans getPlan(int planId) throws Exception;
	public int addPlan(Plans plan)throws Exception;
	public int removePlan(int planId)throws Exception;
	public int updatePlan(Plans plan)throws Exception;
	public Plans getPlanByName(String planName) throws Exception;


}





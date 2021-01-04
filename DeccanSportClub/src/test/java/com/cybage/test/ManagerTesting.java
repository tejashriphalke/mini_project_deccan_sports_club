package com.cybage.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.services.ManagerServiceI;
import com.cybage.services.ManagerServiceImpl;

class ManagerTesting {

	

	ManagerServiceI service= new ManagerServiceImpl();	
	// adding batch testing
	@Test
	void testAddBatch()throws Exception {
		Batch batch=new Batch(Date.valueOf("2020-9-9"),Date.valueOf("2020-10-10"),55,2,4);		
		service.addBatch(batch);
		assertNotNull(service.getBatch(batch.getBatchId()));//		
	}
	@Test
	void testGetDate() {
		assertNotNull(service.getDate("1995-10-10"));
	}
	
	//getting single batch record testing
	@Test
	void testGetBatch()throws Exception
	{		
		assertNotNull(service.getBatch(4));
	}
	//update batch testing
	@Test
	void testUpdateBatch() throws Exception{
		Batch batch=new Batch(13,Date.valueOf("2020-2-2"),Date.valueOf("2020-3-3"),555,3,1);
		assertEquals(1, service.updateBatch(batch));
	}
	
	//removing batch testing
		@Test
		void testRemoveBatch() throws Exception {	
			service.removeBatch(13);
			assertNull(service.getBatch(13));		
		}
	//getting list of batches
	@Test
	void testGetAllBatches()throws Exception{
		assertNotNull( service.getAllBatches());
	}
	//getting single record of manager
	@Test
	void testGetManager() throws Exception{
		assertNotNull(service.getManager("shubham"));
	}
	//getting list of all enrolled members
	@Test
	void testGetAllEnrolledMembers() throws Exception{
		assertNotNull(service.getAllEnrolledMembers());
	}
	//approving status
	@Test
	void testApproveEnrollment()throws Exception {
		Enrollment enrollment=new Enrollment(1, "manager", 4, Date.valueOf("2020-02-02"), Date.valueOf("2020-02-02"), "Approved");
		assertEquals(1,service.approveEnrollment(enrollment));
	}
	//reject enrollment
	@Test
	void testRejectEnrollment() throws Exception{
		Enrollment enrollment=new Enrollment(1, "manager", 4, Date.valueOf("2020-02-02"), Date.valueOf("2020-02-02"), "Approved");
		assertEquals(1,service.rejectEnrollment(enrollment));
	}
	Plans plan=new Plans(101, "plan testing", 12300, 7);	
	
	@Test
	void testAddPlan() throws Exception {
		service.addPlan(plan);
		assertNotNull(service.getPlanByName("plan testing"));
	}


	@Test
	void testUpdatePlan() throws Exception {
		plan.setPlanName("plan updated");
		plan.setFees(6578);
		plan.setDuration(6);
		assertEquals(1, service.updatePlan(service.getPlanByName("plan testing")));
	}

	@Test
	void testGetAllPlans() throws Exception {
		assertNotNull(service.getAllPlans());
	}

	@Test
	void testGetPlan() throws Exception {
		assertNotNull(service.getPlan(service.getPlanByName("plan testing").getPlanId()));		
	}
	
	@Test
	void testRemovePlan() throws Exception {
		assertEquals(1,service.removePlan(service.getPlanByName("plan testing").getPlanId()));
	}




}

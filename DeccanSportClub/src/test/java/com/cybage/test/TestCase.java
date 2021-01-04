package com.cybage.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cybage.pojos.Batch;
import com.cybage.services.ManagerServiceI;
import com.cybage.services.ManagerServiceImpl;

class TestCase {

	ManagerServiceI service =new ManagerServiceImpl();
		
	

	@Test
	void testAddBatch() throws Exception {
		Batch batch=new Batch();
		batch.setStartDate(service.getDate("2020-9-9"));
		batch.setEndDate(service.getDate("2020-9-9"));
		batch.setPlanId(1);
		batch.setSportId(3);
		
		service.addBatch(batch);
		assertNotNull(service.getBatch(batch.getBatchId()));
		}

	

}

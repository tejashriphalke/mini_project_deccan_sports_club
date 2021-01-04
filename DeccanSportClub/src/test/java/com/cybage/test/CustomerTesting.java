package com.cybage.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.cybage.pojos.Users;
import com.cybage.services.CustomerServiceImpl;

class CustomerTesting {
CustomerServiceImpl customer = new CustomerServiceImpl();
@Test
	void testAdduser() throws SQLException, Exception {
	Users user = new Users("Som","som","member","Pune","1234567891","sp@sp.com");
	customer.adduser("Som","som","Pune","1234567891","sp@sp.com");
	assertNotNull(customer.getuser("Som"));
	}

	@Test
	void testGetSports() throws Exception {
		assertNotNull(customer.getSports());
	}

	@Test
	void testGetplans() throws SQLException, Exception {
		assertNotNull(customer.getplans());
	}

	@Test
	void testGetbatches() throws SQLException, Exception {
		assertNotNull(customer.getbatches());
	}

	@Test
	void testGetuser() throws SQLException, Exception {
		assertNotNull(customer.getuser("Som"));
	}

	@Test
	void testEnrolluser() throws SQLException, Exception {
		assertNotNull(customer.getenrollments());
	}

}

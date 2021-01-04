package com.cybage.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.RequestDispatcher;

import org.junit.jupiter.api.Test;

import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;
import com.cybage.services.AdminServiceI;
import com.cybage.services.AdminServiceImpl;

class AdminTesting {
	//AdminSe4rvice obj
	AdminServiceI adminServiceObg=new AdminServiceImpl();

	//method testing getManager
	@Test
	void testGetManagers() throws Exception {
		assertNotNull(adminServiceObg.getManagers());
	}

	//testing Add managers
	@Test 
	void testAddManager() throws Exception
	{
		//you will have to change username and email as they are unique
		//String username="U" +Math.random()*10000;
		// String email= Math.random()+"@gmail.com";
		Users user=new Users();
		user.setUsername("userTest");
		user.setEmail("userTest@gmail.com");
		user.setPassword("test1");
		user.setPhone("77777777");
		user.setAddress("fbdhdg");
		user.setRole("manager");
		adminServiceObg.addManager(user);
		assertNotNull(adminServiceObg.getManager(user.getUsername()));
	}


	//delete manager check
	@Test 
	void testDeleteManager() throws Exception
	{
		adminServiceObg.deleteManager("userTest");
		assertNull(adminServiceObg.getManager("userTest"));
	}

	//get manager checking
	@Test 
	void testGetManager() throws Exception {
		assertNotNull(adminServiceObg.getManager("shubham"));

	}		

//	//update manager checking
	@Test
	void testUpdateManager() throws Exception{
		Users user=new Users("man2","Man2","manager","mumbai","7485125747","email@gmail.com");
		assertEquals(1,adminServiceObg.updateManager(user));

	}


	//get Spoorts checking
	@Test
	void testGetSports() throws Exception 
	{
		assertNotNull(adminServiceObg.getSports());;
	}

	//addSports Checking
	@Test void testAddSport()
	{ 
		Sports sport=new Sports();
		sport.setSportName("testSport");
	}

	//deleteSport checks
	@Test
	void testDeleteSport() throws Exception
	{ 
		assertNotNull(adminServiceObg.deleteSport("testSport"));

	}

	//MyProfile checked
	@Test
	void testMyProfile() throws Exception
	{
		assertNotNull(adminServiceObg.myProfile("admin"));
	}



}


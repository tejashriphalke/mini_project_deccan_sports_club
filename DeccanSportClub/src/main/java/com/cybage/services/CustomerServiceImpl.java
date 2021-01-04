package com.cybage.services;

import java.sql.SQLException;
import java.util.List;

import com.cybage.dao.CustomerDao;
import com.cybage.dao.CustomerDaoImpl;
import com.cybage.pojos.Batch;
import com.cybage.pojos.BatchInfo;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public class CustomerServiceImpl implements CustomerServiceI{
	//Creating object of CustomerDaompl
	CustomerDaoImpl dao=new CustomerDaoImpl();
	//Method for adding user
	public void adduser(String username,String password,String address,
			   String phone,String email) throws   Exception 
	{
	   dao.adduser(username, password, address, phone, email);
	}
	//method for getting all sports

	public List<Sports> getSports() throws Exception {
		return dao.getsports();
	}
	//method for getting all plans
	
	public List<Plans> getplans() throws   Exception {
		return dao.getplans();
	}
	//method for getting all batches
	
	public List<BatchInfo> getbatches() throws   Exception {
		return dao.getbatches();
	}
	//method for getting all Enrolled batch info

	public List<BatchInfo> getbatchesbyId(int planId) throws   Exception {
		return dao.getbatchesbyId(planId);
	}
	
	public Users getuser(String userName) throws   Exception {
		return dao.getuser(userName);
	}
	//method for updating User

	public Users update(String userName, String address, String password, String phone, String email)
			throws   Exception {
		return dao.updateuser(userName,address,password,phone,email);
	}
	//method for enrolling user
	
	public void enrolluser(int batchId, String userName) throws   Exception {
		System.out.println("service::enroll user");
		dao.enrolluser(batchId,userName);
		
	}
	//method for getting all enrollments
	
	public List<Enrollment> getenrollments() throws   Exception {
		return dao.getenrollments();
	}
	//method for renewing the enrollment
	
	public List<Enrollment> renew(int enrollId) throws   Exception {
		return dao.renew(enrollId);
	}
	

}

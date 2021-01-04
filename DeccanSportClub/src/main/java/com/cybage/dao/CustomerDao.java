package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.pojos.Batch;
import com.cybage.pojos.BatchInfo;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public interface CustomerDao {
   public void adduser(String username,String password,String address,
		   String phone,String email) throws   Exception;
	public List<Sports> getsports() throws   Exception;
	public List<Plans> getplans() throws  Exception;
	public List<BatchInfo> getbatches()throws  Exception;
	public List<BatchInfo> getbatchesbyId(int planId)throws  Exception;
	public Users getuser(String userName)throws  Exception;
	public Users updateuser(String userName, String address, String password, String phone, String email)
			throws  Exception;
	public void enrolluser(int batchId, String userName)throws  Exception;
	public List<Enrollment> getenrollments()throws  Exception;
	public List<Enrollment> renew(int enrollId)throws  Exception;
	
}


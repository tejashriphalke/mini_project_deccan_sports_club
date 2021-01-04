package com.cybage.services;

import java.util.List;
import com.cybage.dao.AdminDaoI;
import com.cybage.dao.AdminDaoImpl;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public class AdminServiceImpl implements AdminServiceI {
	//AdminDaoI ref and AdminDaoImpl obj
	AdminDaoI adminDaoObj = new AdminDaoImpl();

	//get managers
	public List<Users> getManagers() throws Exception {
		return adminDaoObj.getAllManagers();
	}

	//add managers
	public int addManager(Users user) throws Exception {
	
		return adminDaoObj.addManager(user);
	}

	//delete Managers
	public int deleteManager(String username) throws Exception {
		return adminDaoObj.deleteManager(username);
		 
	}

	//get Single Manager
	public Users getManager(String username) throws Exception {
		// TODO Auto-generated method stub
		return adminDaoObj.getManager(username);
	}

	//update manager
	public int updateManager(Users user) throws Exception {
		// TODO Auto-generated method stub
		return  adminDaoObj.updateManager(user);
	}
	
	//List of Sports
	public List<Sports> getSports() throws Exception {
		// TODO Auto-generated method stub
		return adminDaoObj.getAllSports();
	}

	//add sport
	public int addSport(Sports sports) throws Exception {
		// TODO Auto-generated method stub
		return adminDaoObj.addSport(sports);
	}

	//delete Sport
	public int deleteSport(String sportName) throws Exception {
		// TODO Auto-generated method stub
		return adminDaoObj.deleteSport(sportName);
	}

	//show admin's profile
	public Users myProfile(String username) throws Exception {
		// TODO Auto-generated method stub
		return adminDaoObj.showMyProfile(username);
	}

	





}

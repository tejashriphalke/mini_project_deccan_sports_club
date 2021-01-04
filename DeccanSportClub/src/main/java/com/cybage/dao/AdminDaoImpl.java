package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cybage.dbutil.DbUtil;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

//admin Dao Implemented
public class AdminDaoImpl implements AdminDaoI {

	//method to get List of manager
	public List<Users> getAllManagers() throws Exception {
		String manager="manager";
		String sql = "select * from users where role=?";
		//get Connection
		Connection connection = DbUtil.getConnection();
		//prepared statement
		PreparedStatement ps = connection.prepareStatement(sql);
		//para set
		ps.setString(1, manager);
		//values to resultSet
		ResultSet rs = ps.executeQuery();
		//users obj
		List<Users> users = new ArrayList<Users>();
		//run till fetching all list of managers
		while(rs.next()) {
			users.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
		}
		//return List of users
		return users;
	}

	//add manager method
	public int addManager(Users user) throws Exception {
		//query String
		String sql = "insert into users(username,password,role,address,phone,email) values(?,?,?,?,?,?)";
		//connection
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);

		//parameters set
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getRole());
		ps.setString(4, user.getAddress());
		ps.setString(5, user.getPhone());
		ps.setString(6, user.getEmail());
		//return how many lines updated
		return ps.executeUpdate();
	}

	//delete manager
	public int deleteManager(String username) throws Exception {
		//query String
		String sql = "delete from users where username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);		
		//set String
		ps.setString(1, username);			
		return ps.executeUpdate();
	}
	
	//get manager by username
	public Users getManager(String username) throws Exception {
		String sql = "select * from users where username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Users  user = null;
		if(rs.next()) {
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		}
		return user;
	}

	//update  manager 
	public int updateManager(Users user) throws Exception {
		String sql = "update users set password = ?,role = ?,address=?,phone=?,email=? where username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getRole());
		ps.setString(3, user.getAddress());
		ps.setString(4, user.getPhone());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getUsername());
		//execute update return updated lines
		return ps.executeUpdate();
	}

	//**********Sports Crud*********
	
	//get all Sports
	public List<Sports> getAllSports() throws Exception {
		String sql = "select * from Sports ";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Sports> sports = new ArrayList<Sports>();
		while(rs.next()) {
			sports.add(new Sports(rs.getInt(1), rs.getString(2)));
		}
		return sports;
	}

	//add Sport
	public int addSport(Sports sport) throws Exception {
		String sql = "insert into Sports(sportName) values(?)";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, sport.getSportName());
		return ps.executeUpdate();
	}

	//delete Sport
	public int deleteSport(String sportName) throws Exception {
		String sql = "delete from Sports where sportName = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, sportName);			
		return ps.executeUpdate();
	}

	//Admins profile
	public Users showMyProfile(String username) throws Exception {
		String sql = "select * from users where username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Users  user = null;
		if(rs.next()) {
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		}
		return user;
	}
}
package com.cybage.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cybage.dbutil.DbUtil;
import com.cybage.pojos.BatchInfo;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public class CustomerDaoImpl implements CustomerDao {
	public static final Logger logger = LogManager.getLogger(CustomerDaoImpl.class.getName());

	// adduser method will add the user in users database.
	@Override
	public void adduser(String username, String password, String address, String phone, String email) throws Exception {
		PreparedStatement ps = null;
		String sql = "insert into users(userName,password,role,address,phone,email)values(?,?,?,?,?,?)";
		Connection con = DbUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, "member");
		ps.setString(4, address);
		ps.setString(5, phone);
		ps.setString(6, email);
		if (ps.executeUpdate() == 1) {
			System.out.println("record added");
		} else {
			System.out.println("not added");
			ps.close();
			con.close();
		}
		logger.info("Registration successful of user named as a:" + username);
	}

	// getsports method will return the list of sports to the servlet
	@Override
	public List<Sports> getsports() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Sports> sportlist = null;
		String sql = "select * from sports";
		Connection con = DbUtil.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		sportlist = new ArrayList<Sports>();
		while (rs.next()) {
			sportlist.add(new Sports(rs.getInt(1), rs.getString(2)));
		}
		ps.close();
		rs.close();
		con.close();
		return sportlist;
	}

	// getplans method will return the list of plans to the servlet
	@Override
	public List<Plans> getplans() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Plans> planslist = null;

		String sql = "select * from plans";
		Connection con = DbUtil.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		planslist = new ArrayList<Plans>();
		while (rs.next()) {
			planslist.add(new Plans(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
		}
		ps.close();
		rs.close();
		con.close();
		return planslist;
	}

	// getbatches method will return the list of batches to the servlet
	@Override
	public List<BatchInfo> getbatches() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BatchInfo> batcheslist = null;

		String sql = "SELECT batch.batchId, batch.startDate,batch.endDate,batch.batchSize,sports.sportName\r\n"
				+ "FROM batch\r\n" + "INNER JOIN sports ON batch.sportId=sports.sportId;";
		Connection con = DbUtil.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		batcheslist = new ArrayList<BatchInfo>();
		while (rs.next()) {
			batcheslist.add(new BatchInfo(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5)));
		}
		ps.close();
		rs.close();
		con.close();
		return batcheslist;
	}

	// getbatchesbyId method will return the list of batches of particular planId to
	// the servlet
	@Override
	public List<BatchInfo> getbatchesbyId(int planId) throws Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BatchInfo> batcheslist = null;
		String sql = "SELECT batch.batchId, batch.startDate,batch.endDate,batch.batchSize,sports.sportName\r\n"
				+ "FROM batch\r\n" + "INNER JOIN sports ON batch.sportId=sports.sportId where planId= ? ";
		Connection connection = DbUtil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setInt(1, planId);
		rs = ps.executeQuery();

		batcheslist = new ArrayList<BatchInfo>();
		while (rs.next()) {
			batcheslist.add(new BatchInfo(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5)));
		}
		ps.close();
		rs.close();
		connection.close();
		return batcheslist;
	}

	// getuser method will fetch the user by username and return the user object to
	// the servlet
	@Override
	public Users getuser(String userName) throws Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Users user = null;
		String sql = "select * from users where userName = ? ";
		Connection connection = DbUtil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setString(1, userName);
		rs = ps.executeQuery();
		while (rs.next()) {
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7));
			return user;
		}
		ps.close();
		rs.close();
		connection.close();
		return null;

	}

	// updateuser method will update the user in database and will return updated
	// user to the servlet
	@Override
	public Users updateuser(String userName, String address, String password, String phone, String email)
			throws Exception {

		PreparedStatement ps = null;
		String sql = "update users set username= ? ,address=?, password = ?,phone = ?,email = ? where username= ?";
		Connection connection = DbUtil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, address);
		ps.setString(3, password);
		ps.setString(4, phone);
		ps.setString(5, email);
		ps.setString(6, userName);
		if (ps.executeUpdate() == 1) {
			Users user = getuser(userName);
			return user;
		}
		ps.close();
		connection.close();
		return null;
	}

	// enrolluser method will enroll the user for particular batch and enrollment
	// record will get added in db.
	@Override
	public void enrolluser(int batchId, String userName) throws Exception {
        PreparedStatement ps = null;
		ResultSet rs = null;
        Date startdate = null;
		Date enddate = null;
		Connection connection = DbUtil.getConnection();
		
		String sql = "select * from batch where batchId= ?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, batchId);
		rs = ps.executeQuery();
		if (rs.next()) {                         //batch selected
			startdate = rs.getDate(2);
			enddate = rs.getDate(3);
		}
		
		//once batch selected insert data into the enrollment table
		String status = "PENDING";
		String sql1 = "insert into enrollment(batchId,startDate,endDate,mStatus,userName)values(?,?,?,?,?)";
		ps = connection.prepareStatement(sql1);
		ps.setInt(1, batchId);
		ps.setDate(2, startdate);
		ps.setDate(3, enddate);
		ps.setString(4, status);
		ps.setString(5, userName);
		System.out.println(userName);
		if (ps.executeUpdate() == 1) {
			System.out.println("record added in enrollment");
			ps.close();
			connection.close();
		} else {
			System.out.println("record not added in enrollment");
		}
		ps.close();
		rs.close();
		connection.close();
	}

	// getenrollments method will return the list of enrollments to the servlet
	@Override
	public List<Enrollment> getenrollments() throws Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Enrollment> enlist = null;
		String sql = "select * from enrollment";
		Connection connection = DbUtil.getConnection();
		ps = connection.prepareStatement(sql);
		rs = ps.executeQuery();
		enlist = new ArrayList<Enrollment>();
		while (rs.next()) {
			enlist.add(new Enrollment(rs.getInt(1), rs.getString(6), rs.getInt(2), rs.getDate(3), rs.getDate(4),
					rs.getString(5)));
		}
		ps.close();
		rs.close();
		connection.close();
		return enlist;
	}

	// renew method will renew the membership of user and updated enrollment list
	// will get sent to servlet.
	@Override
	public List<Enrollment> renew(int enrollId) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Enrollment> enlist = null;
		Date startDate;
		Date endDate;
		
		String sql = "select * from enrollment where enrollId= ?";
		Connection connection = DbUtil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setInt(1, enrollId);
		rs = ps.executeQuery();
		if (rs.next()) {                     //Enrollment record selected
			System.out.println("enrollment record selected...");
			startDate = rs.getDate(3);
			System.out.println("startdate:" + startDate);
			endDate = rs.getDate(4);
			System.out.println("enddate:" + endDate);
		}
		//once enrollment record found convert start date into todays date.
		LocalDate startd = java.time.LocalDate.now();
		Date sdate = Date.valueOf(startd);

		//and end date into the current end date+3 months
		LocalDate endd = startd.plusMonths(3);
		Date edate = Date.valueOf(endd);

		String sql1 = "update enrollment set startDate= ? , endDate = ? where enrollId= ?";
		ps = connection.prepareStatement(sql1);
		ps.setDate(1, sdate);
		ps.setDate(2, edate);
		ps.setInt(3, enrollId);
		if (ps.executeUpdate() == 1) {
			System.out.println("enrollment updated");
		}
		enlist = getenrollments();

		ps.close();
		rs.close();
		connection.close();
		return enlist;
	}
}
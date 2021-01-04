package com.cybage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cybage.pojos.AllBatchInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Users;
import com.cybage.dbutil.*;

public class ManagerDaoImpl implements ManagerDaoI{
	//Parameterless constructor
	public ManagerDaoImpl()
	{}
	//list of batches with respective details
	public List<AllBatchInfo> getAllBatches() throws Exception {
		//sql query on Batch.Sports,Plans Table
		String sql = "select b.batchId,b.startDate,b.endDate,b.batchSize,s.sportName, s.sportId ,b.planId,p.planName, p.fees, p.duration from batch b inner join Sports s on  s.sportId=b.sportId inner join plans p on b.planId=p.planId";
		//get the connection
		Connection con = DbUtil.getConnection();	
		//get statement
		PreparedStatement ps = con.prepareStatement(sql);
		//get list of AllBatchInfo Object
		List<AllBatchInfo>list=new ArrayList<AllBatchInfo>();
		//execute sql query and store the result into result set
		ResultSet rs= ps.executeQuery();
		//check if entries present into resultset
		while(rs.next()){	
			//add record into ArrayList
			list.add(new AllBatchInfo(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getDouble(9),rs.getInt(10)) );
		}
		//close PreparedStatement
		ps.close();
		//close connection
		con.close();
		//return list to service so can be accessed in ManagerServlet
		return list;	
	}
	//insert a record into batch table
	public int addBatch(Batch batch) throws Exception {
		//sql query to add record into batch table
		String sql = "insert into batch(startDate,endDate ,batchSize,sportId,planId) values(?,?,?,?,?)";
		//get connection
		Connection con = DbUtil.getConnection();
		//get prepared statement
		PreparedStatement ps = con.prepareStatement(sql);
		//set parameters
		ps.setDate(1, batch.getStartDate());
		ps.setDate(2, batch.getEndDate());
		ps.setInt(3, batch.getBatchSize());
		ps.setInt(4, batch.getSportId());
		ps.setInt(5, batch.getPlanId());
		//execute query
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			//close PreparedStatement	
			ps.close();
			//close connection
			con.close();
			return rowAffected;			
		}
		else {
			//close PreparedStatement	
			ps.close();
			//close PreparedStatement	
			con.close();
			throw new Exception("Could not insert record into batch");
		}
	}
	//to delete a record from Batch table
	public int removeBatch(int batchId) throws Exception {
		//sql query to delete a redord from bathc using batch id
		String sql = "delete from Batch where batchId= ?";
		//get connection
		Connection con = DbUtil.getConnection();
		//get statement
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, batchId);
		//execute query
		int rowAffected= ps.executeUpdate();		
		if(rowAffected==1)
		{	//close statement
			ps.close();
			//close connection
			con.close();
			//return resultinto service
			return rowAffected;		
		}
		else {
			//close statement
			ps.close();
			//close connection
			con.close();
			throw new Exception("Could not delete batch record");
		}
	}
	//fetch a record from Batch table so as to edit batch
	public Batch getBatch(int batchId) throws Exception{
		//sql query for single batch record
		String sql = "select * from batch where batchId = ?";
		//get connection
		Connection connection = DbUtil.getConnection();
		//create statement
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, batchId);
		//execute query
		ResultSet rs = ps.executeQuery();
		Batch  batch = null;
		//check if records are present 
		if(rs.next()) {
			batch = new Batch(rs.getInt(1), rs.getDate(2),rs.getDate(3), rs.getInt(4),rs.getInt(5),rs.getInt(6));
		}
		//close prepared statment
		ps.close();
		//close connection
		connection.close();
		//return a batch record to service 
		return batch;
	}

	///update record in Batch table
	public int updateBatch(Batch batch) throws Exception {
		//sql query to update a record in Batch table
		String sql = " update Batch SET startDate=? ,endDate=?,batchSize=?,sportId=?,planId=?  where batchId=?; ";
		//get connection
		Connection con = DbUtil.getConnection();	
		//get statement
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, batch.getStartDate());
		ps.setDate(2,batch.getEndDate() );
		ps.setInt(3, batch.getBatchSize());
		ps.setInt(4,batch.getSportId());
		ps.setInt(5, batch.getPlanId());
		ps.setInt(6,batch.getBatchId());
		//execute query
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			//close statement
			ps.close();
			//close connection
			con.close();
			return rowAffected;
		}
		else {
			//close statement
			ps.close();
			//close connection
			con.close();
			throw new Exception("Could not update Batch tables record");
		}
	}
	///to fetch a record of single manager
	public Users getManager(String username) throws Exception{
		//sql query to get manager record by username
		String sql = "select * from users where username=?";
		//get connection
		Connection connection = DbUtil.getConnection();
		//get statement
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		//execute query
		ResultSet rs = ps.executeQuery();
		Users user= null;
		//check if record exists 
		if(rs.next()) {
			//if exist get that record
			user = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		}
		//close statement
		ps.close();
		//close connection
		connection.close();
		//return users record to service
		return user;
	}
	//to fetch list of enrolled members
	public List<AllBatchInfo> getAllEnrolledMembers() throws Exception {
		//sql query on Batch,sports,plans,enrollment,users 
		String sql = "select b.batchId,b.startDate,b.endDate,b.batchSize,s.sportName, s.sportId ,b.planId,p.planName, p.fees, p.duration ,e.enrollId,e.mStatus,e.username from batch b inner join Sports s on  s.sportId=b.sportId inner join plans p on b.planId=p.planId inner join enrollment e on b.batchId=e.batchId inner join users u on e.username=u.username where e.mStatus= ?";
		//get connection
		Connection con = DbUtil.getConnection();	
		//get statment
		PreparedStatement ps = con.prepareStatement(sql);
		//create ArrayList of AllBatchiNFO oBJECTS
		ps.setString(1, "pending");
		List<AllBatchInfo>list=new ArrayList<AllBatchInfo>();
		//EXECUTE QUERY
		ResultSet rs= ps.executeQuery();
		//GET list if records exists
		while(rs.next()){		
			list.add(new AllBatchInfo(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getDouble(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13)) );
		}
		//close statement
		ps.close();
		//close connection
		con.close();
		//return list to service
		return list;	
	}
	public List<AllBatchInfo> getActionedMembers()throws Exception {
		//sql query on Batch,sports,plans,enrollment,users 
				String sql = "select b.batchId,b.startDate,b.endDate,b.batchSize,s.sportName, s.sportId ,b.planId,p.planName, p.fees, p.duration ,e.enrollId,e.mStatus,e.username from batch b inner join Sports s on  s.sportId=b.sportId inner join plans p on b.planId=p.planId inner join enrollment e on b.batchId=e.batchId inner join users u on e.username=u.username where e.mStatus= ? or e.mStatus= ? ";
				//get connection
				Connection con = DbUtil.getConnection();	
				//get statment
				PreparedStatement ps = con.prepareStatement(sql);
				//create ArrayList of AllBatchiNFO oBJECTS
				ps.setString(1, "approved");
				ps.setString(2, "rejected");
				List<AllBatchInfo>list=new ArrayList<AllBatchInfo>();
				//EXECUTE QUERY
				ResultSet rs= ps.executeQuery();
				//GET list if records exists
				while(rs.next()){		
					list.add(new AllBatchInfo(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getDouble(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13)) );
				}
				//close statement
				ps.close();
				//close connection
				con.close();
				//return list to service
				return list;
	}
	
	///to update batch size after enrolling user
	public int updateBatchSize(int enrollId,int batchSize)throws Exception
	{	//sql query to get selective enrollment 
		String sql = "select batchId  from enrollment where enrollId = ?";
		//get connection
		Connection connection = DbUtil.getConnection();
		//get prepared statement
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,enrollId);
		//execute query
		ResultSet rs = ps.executeQuery();
		Integer batchId=null;
		//check if record exists or not
		if(rs.next()) 
		{
			batchId=rs.getInt(1);
			//close statement
			ps.close();
			//close connection
			connection.close();
		}
		//sql query to update size of batch i.e decrement size by one 
		String sql1="update batch set batchSize=? where batchId=?";
		//get connection
		Connection connection1 = DbUtil.getConnection();
		//get statemnt
		PreparedStatement ps1 = connection1.prepareStatement(sql1);		
		//logic for decreasing size of batch
		batchSize=batchSize-1;
		ps1.setInt(1,batchSize);
		ps1.setInt(2, batchId);
		int rowAffected= ps1.executeUpdate();
		if(rowAffected==1)
		{	//close statementt
			ps1.close();
			//close connection
			connection1.close();
			//retuen result
			return rowAffected;
		}
		else 
		{
			throw new Exception("Could not update batch Size");
		}
	}
	//to enroll member into membership 
	public int approveEnrollment(Enrollment enrlmnt)throws Exception 
	{	//sql query to change status of enrolled user
		String sql = " update Enrollment SET mStatus=?  where enrollId=?; ";
		//get connection
		Connection con = DbUtil.getConnection();
		//get prepared statemnt
		PreparedStatement ps = con.prepareStatement(sql);
		//change status from Pending  to Approved
		ps.setString(1, "Approved");
		ps.setInt(2,enrlmnt.getEnrollId());
		//execute query
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{	//close statement
			ps.close();
			//close connection
			con.close();
			return rowAffected;
		}
		else {
			//close statement
			ps.close();
			//close connection
			con.close();
			throw new Exception("Could not Approve as no record found to be updated");
		}
	}
	//to reject enrollment
	public int rejectEnrollment(Enrollment enrlmnt)throws Exception 
	{	//sql query to change status of enrolled user
		String sql = " update Enrollment SET mStatus=?  where enrollId=?; ";
		//get connection
		Connection con = DbUtil.getConnection();
		//get prepared statemnt
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "Rejected");
		ps.setInt(2,enrlmnt.getEnrollId());
		//execute query
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{	//close statement
			ps.close();
			//close connection
			con.close();
			return rowAffected;
		}
		else {
			//close statement
			ps.close();
			//close connection
			con.close();
			throw new Exception("Reject not possible");
		}
	}
	//add plan 
	public int addPlan(Plans plan) throws Exception {

		String sql = "insert into plans(planName,fees,duration) values(?,?,?)";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, plan.getPlanName());
		ps.setDouble(2, plan.getFees());	
		ps.setInt(3, plan.getDuration());
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		else {

			throw new Exception("Could not insert plan record");
		}
	}
	public int removePlan(int planId) throws Exception {

		String sql = "delete from plans where planId= ?";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, planId);	
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not delete plans record");
		}
	}	
	public int updatePlan(Plans plan) throws Exception {

		String sql = "update plans SET planName=?,fees=?,duration=? where planId=?";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, plan.getPlanName());
		ps.setDouble(2, plan.getFees());
		ps.setInt(3, plan.getDuration());

		ps.setInt(4,plan.getPlanId());
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not update Plans tables record");
		}
	}
	public List<Plans> getAllPlans() throws Exception {

		String sql = "select * from plans";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		List<Plans>list=new ArrayList<Plans>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){

			list.add(new Plans(rs.getInt("planId"),rs.getString("planName"),rs.getDouble("fees"), rs.getInt("duration")));

		}
		return list;
	}	
	public Plans getPlan(int planId) throws Exception {
		String sql = "select * from plans where planId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, planId);
		ResultSet rs = ps.executeQuery();
		Plans plan= null;
		if(rs.next()) {
			plan= new Plans(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
		}
		return plan;
	}	
	public Plans getPlanByName(String planName) throws Exception {

		String sql = "select * from plans where planName = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, planName);
		ResultSet rs = ps.executeQuery();
		Plans plan= null;
		if(rs.next()) {
			plan= new Plans(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
		}
		return plan;
	}
	
	
}
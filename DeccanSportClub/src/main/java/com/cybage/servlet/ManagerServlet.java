package com.cybage.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cybage.pojos.Users;
import com.cybage.pojos.AllBatchInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.services.ManagerServiceI;
import com.cybage.services.ManagerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//access allowed only for manager role
@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"manager"}
				))
public class ManagerServlet extends HttpServlet {
	//managerSrevice object created through which  accessed dao layer
	ManagerServiceI manager=new ManagerServiceImpl();
	public static final Logger logger = LogManager.getLogger(ManagerServlet.class.getName());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		//displaying the list of all the batches
		if(path.equals("/listbatch")) {			
			try {
				//log has been created
				logger.info("Processing list of batches");
				List<AllBatchInfo> listbatch=manager.getAllBatches();
				//request scope set
				request.setAttribute("batches", listbatch);
				request.getRequestDispatcher("/manager/manager-batches.jsp").forward(request, response);;
				
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//adding batch 
		if(path.equals("/addbatch")) {			
			try {
				//log has been created
				logger.info("Adding a Batch");
				//batch obj is created
				Batch batchinfo= new Batch();
				//setters are called to set received parameters inside batch objects
				batchinfo.setStartDate(manager.getDate(request.getParameter("startDate")));
				batchinfo.setEndDate(manager.getDate(request.getParameter("endDate")));
				batchinfo.setBatchSize(Integer.parseInt(request.getParameter("batchSize")));
				batchinfo.setSportId(Integer.parseInt(request.getParameter("sportId")));
				batchinfo.setPlanId(Integer.parseInt(request.getParameter("planId")));
				//call to service addBatch method into which batchinfo object is passed
				manager.addBatch(batchinfo);
				//go to the page listbatch in the request
				response.sendRedirect("listbatch");							
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//deleting batch if not used
		if(path.equals("/deletebatch")) {			
			try {
				//log has been created
				logger.info("deleting a batch if not assigned to a batch");
				manager.removeBatch(Integer.parseInt(request.getParameter("batchId")));
				response.sendRedirect("listbatch");								
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//edit details of batch
		if(path.equals("/editbatch")) {			
			try {
				//log has been created
				logger.info("Editing Batch");
				//after clicking on particular batch using recived batchid-->batch record is fetched
				Batch batch=manager.getBatch(Integer.parseInt(request.getParameter("batchId")));
				//request scope set
				request.setAttribute("batches", batch);
				//request goes to update-batch,jsp page
				request.getRequestDispatcher("/manager/update-batch.jsp").forward(request, response);								
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//after editing details updating is done 
		if(path.equals("/updatebatch")) {			
			try {
				//log has been created
				logger.info("Updating edited batch information");
				//batch obj is created
				Batch batchinfo =new Batch();
				//edited details are now set into that object again
				batchinfo.setBatchId(Integer.parseInt(request.getParameter("batchId")));
				batchinfo.setStartDate(manager.getDate(request.getParameter("startDate")));
				batchinfo.setEndDate(manager.getDate(request.getParameter("endDate")));
				batchinfo.setBatchSize(Integer.parseInt(request.getParameter("batchSize")));
				batchinfo.setSportId(Integer.parseInt(request.getParameter("sportId")));
				batchinfo.setPlanId(Integer.parseInt(request.getParameter("planId")));
				//calling updateBatch method from service
				manager.updateBatch(batchinfo);
				//response has been sent to listbatch
				response.sendRedirect("listbatch");				
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//display's the profile of manager
		if(path.equals("/managerprofile")) {			
			try {
				//log has been created
				logger.info("Displaying profile of a perticular manager");
				HttpSession session =request.getSession(true);
				String username=(String)session.getAttribute("username");
				Users user=manager.getManager(username);
				System.out.println(user.toString());
				request.setAttribute("managerprofile", user);
				request.getRequestDispatcher("/manager/manager-profile.jsp").forward(request, response);
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//List of all the enrolled members
		if(path.equals("/listenrolledmembers")) {			
			try {
				//log has been created
				logger.info("Getting list of enrolled members");
				//list of enrolled members
				List<AllBatchInfo> enrolledbatch = manager.getAllEnrolledMembers();
				System.out.println( enrolledbatch.toString());
				request.setAttribute("enrolledbatches", enrolledbatch);
				request.getRequestDispatcher("/manager/enrolled-members.jsp").forward(request, response);
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//enroll the member for a batch
		if(path.equals("/approvemember")) {			
			try {				
				Enrollment enrlmnt=new Enrollment();
				//log has been created
				logger.info("Checking batch size");
				if(Integer.parseInt(request.getParameter("batchSize"))==0)
				{	//log created
					logger.info("No seat availabie");
					throw new Exception("No seat available");
				}
				logger.info("Enrolling the member into a batch");
				//here using enrollId --->batchId is obtained -->using that batchSize is decreased by one 
				manager.updateBatchSize(Integer.parseInt(request.getParameter("enrollId")),Integer.parseInt(request.getParameter("batchSize")));
				enrlmnt.setEnrollId(Integer.parseInt(request.getParameter("enrollId")));
				//calling function to change the status from pending to Approve
				manager.approveEnrollment(enrlmnt);
				response.sendRedirect("listenrolledmembers");										
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//reject the member
		if(path.equals("/rejectmember")) {			
			try {
				//log has been created
				logger.info("Rejecting a member from enrollment");
				//creating object of enrollment
				Enrollment enrlmnt=new Enrollment();
				enrlmnt.setEnrollId(Integer.parseInt(request.getParameter("enrollId")));
				manager.rejectEnrollment(enrlmnt);

				response.sendRedirect("listenrolledmembers");										
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		
		//List of approved and rejected members
				if(path.equals("/enrolledstatus")) {			
					try {
						//log has been created
						logger.info("Getting list of members");
						//list of enrolled members
						List<AllBatchInfo> enrolledbatch = manager.getActionedMembers();
						System.out.println( enrolledbatch.toString());
						request.setAttribute("enrolledbatches", enrolledbatch);
						request.getRequestDispatcher("/manager/actioned-members.jsp").forward(request, response);
					} catch (Exception e) {
						//printing error into logger file
						logger.info(e);
						//request scope set
						request.setAttribute("e", e);
						//error get printed on error-page.jsp and go to error-page.jsp in the same request
						request.getRequestDispatcher("/error-page.jsp").forward(request, response);
					}
				}

		//showing the plans list	
		if(path.equals("/listplan")) {			
			try {
				List<Plans> listplan=manager.getAllPlans();
				//log has been created
				logger.info("List All Plans...");
				request.setAttribute("plans", listplan);
				request.getRequestDispatcher("/manager/manager-plans.jsp").forward(request, response);
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}

		//adding new plans
		if(path.equals("/addplan")) {			
			try {
				Plans planinfo=new Plans();
				//log has been created
				logger.info("New Plan Added...");
				planinfo.setPlanName(request.getParameter("planName"));
				planinfo.setFees(Double.parseDouble(request.getParameter("fees")));
				planinfo.setDuration(Integer.parseInt(request.getParameter("duration")));

				manager.addPlan(planinfo);
				response.sendRedirect("listplan");								
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//deleting the plans
		if(path.equals("/deleteplan")) {			
			try {
				manager.removePlan(Integer.parseInt(request.getParameter("planId")));
				//log has been created
				logger.info("Desired plan removed");
				request.setAttribute("deletemsg", "Plan deleted successfully");
				response.sendRedirect("listplan");								
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}

		}
		//editing the plans
		if(path.equals("/editplan")) {			
			try {
				Plans plan=manager.getPlan(Integer.parseInt(request.getParameter("planId")));
				//log has been created
				logger.info("Selected the plan to be updated...");
				request.setAttribute("plans", plan);
				request.getRequestDispatcher("/manager/update-plan.jsp").forward(request, response);								
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//updating the plnas
		if(path.equals("/updateplan")) {			
			try {

				Plans planinfo=new Plans();
				//log has been created
				logger.info("Plan Updated, desired changes made...");
				planinfo.setPlanId(Integer.parseInt(request.getParameter("planId")));
				planinfo.setPlanName(request.getParameter("planName"));
				planinfo.setFees(Double.parseDouble(request.getParameter("fees")));
				planinfo.setDuration(Integer.parseInt(request.getParameter("duration")));				
				manager.updatePlan(planinfo);		
				response.sendRedirect("listplan");										
			} catch (Exception e) {
				//printing error into logger file
				logger.info(e);
				//request scope set
				request.setAttribute("e", e);
				//error get printed on error-page.jsp and go to error-page.jsp in the same request
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}



	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




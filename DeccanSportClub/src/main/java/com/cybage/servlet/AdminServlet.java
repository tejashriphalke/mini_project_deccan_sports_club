package com.cybage.servlet;
import java.io.*; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;
import com.cybage.services.AdminServiceI;
import com.cybage.services.AdminServiceImpl;

//access allowed only for admin role
@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"admin"}
				)
		)
public class AdminServlet extends HttpServlet {
	public static final Logger logger = LogManager.getLogger(AdminServlet.class.getName()); 
	
	//admin Service obj is created
	AdminServiceI adminServiceObj=new AdminServiceImpl();

	public AdminServlet() {
		super();
	}

    //will enter into this method when method="GET"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		//if is managerList will go into if condition
		if(path.equals("/managerList")) {			
			try {
				//getManager method is called on admins service obj
				//list is saved in manager obj
				List<Users> manager =  adminServiceObj.getManagers();
				//log been created
				logger.info("Getting all managers...");
				//manager obj is set in request Scope with key manager(left)
				request.setAttribute("manager", manager);
				//go to page managerList in same request
				request.getRequestDispatcher("/Admin/managerList.jsp").forward(request, response);
			} catch (Exception e) {
				//log create if anything bad happens
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		
		
		//enter into if condition if path is addManager
		if(path.equals("/addManager")) {			
			try {
				//user obj created
				Users user = new Users();
				// user obj values are set here
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("role"));
				user.setAddress(request.getParameter("address"));
				user.setPhone(request.getParameter("phone"));
				user.setEmail(request.getParameter("email"));
				//sent user obj to addManager method
				adminServiceObj.addManager(user);
				//log created
				logger.info("adding Manager : " + user.getUsername());
				response.sendRedirect("managerList");								
			} catch (Exception e) {
				//log created
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//check for path deleteManager 
		if(path.equals("/deleteManager")) {			
			try {
				//calling deleteManager
				//sending username to deleteManager from parameter
				//username is coming from url 
				adminServiceObj.deleteManager(request.getParameter("username"));
				//msg is set in request scope
				request.setAttribute("deletemsg", "User deleted successfully");
				//log created
				logger.info("manager deleted");
				//redirected to managerList
				response.sendRedirect("managerList");								
			} catch (Exception e) {
				//log created
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//check for path is editManager
		if(path.equals("/editManager")) {			
			try {
				//log created
				logger.info("manager called for updation");
				//getManager called and set username as parameter
				//value is coming from url
				Users manager = adminServiceObj.getManager(request.getParameter("username"));
				//manager value is set to request scope
				request.setAttribute("manager", manager);
				//go to updateMnager page with req and res 
				request.getRequestDispatcher("/Admin/updateManager.jsp").forward(request, response);								
			} catch (Exception e) {
				//log created
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//check path for updateManager
		if(path.equals("/updateManager")) {			
			try {
				//object created
				Users user = new Users();
				//values are set
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("role"));
				user.setAddress(request.getParameter("address"));
				user.setPhone(request.getParameter("phone"));
				user.setEmail(request.getParameter("email"));
				//user is passed to updateManager
				adminServiceObj.updateManager(user);
				//log created
				logger.info("manager updated");
				//redirected to managerList page
				response.sendRedirect("managerList");										
			} catch (Exception e) {
				//looger created
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//check for path login
		if(path.equals("/login")) {	
			logger.info("In Login page");
			//go to login page
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		//check for path myProfile
		if(path.equals("/myProfile")) {			
			try {
				//get value from current logged in user
				String username=request.getRemoteUser();
				//username passed to myProfile
				Users admin =  adminServiceObj.myProfile(username);
				logger.info("Show admins Profile");
				// set value to req scope
				request.setAttribute("admin", admin);
				request.getRequestDispatcher("/Admin/myProfile.jsp").forward(request, response);
			} catch (Exception e) {
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		
		
		//**********************************Sports**********
		//check for path sportsList
		if(path.equals("/sportsList")) {			
			try {
				List<Sports> sports =  adminServiceObj.getSports();
				logger.info("Getting all sports...");
				//request scope set
				request.setAttribute("sports", sports);
				request.getRequestDispatcher("/Admin/sportsList.jsp").forward(request, response);
			} catch (Exception e) {
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
				
				
			}
		}
		//check for path addSports
		if(path.equals("/addSport")) {			
			try {
				Sports sports=new Sports();
				sports.setSportName(request.getParameter("sportName"));
				//sports passed to addSport
				adminServiceObj.addSport(sports);
				//log created
				logger.info("adding S : " + sports.getSportId());
				response.sendRedirect("sportsList");								
			} catch (Exception e) {
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//check for path deleteSports
		if(path.equals("/deleteSport")) {			
			try {
				adminServiceObj.deleteSport(request.getParameter("sportName"));
				request.setAttribute("deletemsg", "Sport deleted successfully");
				logger.info("Sport deleted");
				response.sendRedirect("sportsList");								
			} catch (Exception e) {
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		//**************Sports Completed***************
		
		//***********Loogig show page************
		//check if path showLogs
		//NIO used for reading data
		if(path.equals("/showLogs")) {
			try {
				//path of log file
				Path reader =Paths.get("C:\\Users\\Administrator\\Desktop\\Deccan Sport Club\\DeccanSportClub1\\src\\main\\webapp\\log\\mylog.log");
				//data lines read from file
				List<String> data =Files.readAllLines(reader);
		        // System.out.println(data);
		        data.parallelStream().forEach(System.out::println);
		        //data added to req scope if wanna show in jsp page
		        //request.setAttribute("fileData", data);
		    	request.getRequestDispatcher("/Admin/showLogs.jsp").forward(request, response);
			}
			catch (Exception e) {
				logger.info(e);
				request.setAttribute("e", e);
				request.getRequestDispatcher("/error-page.jsp").forward(request, response);
			}
		}
		
		//*************
	}
	//any POST req comes send it to get method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("post method called");
		doGet(request, response);
	}



}

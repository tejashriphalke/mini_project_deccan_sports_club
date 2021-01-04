package com.cybage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//securities by security container
//jdbc requirements provided in server.xml
//here security container will only allow user who has following roles "admin", "manager", "member"
@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"admin", "manager", "member"}
				)
		)
public class AppServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//only enters who has role admin
		if(request.isUserInRole("admin")) {
			request.getRequestDispatcher("/Admin/adminHome.jsp").forward(request, response);
		}
		//only enters who has role manager
		if(request.isUserInRole("manager")) {
			request.getRequestDispatcher("/manager/manager-home.jsp").forward(request, response);
		}
		//only enters who has role member
		if(request.isUserInRole("member")) {
			request.getRequestDispatcher("/member/member-home.jsp").forward(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

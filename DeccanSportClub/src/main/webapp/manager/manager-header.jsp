<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>G-2 Project</title>
<link defer rel="stylesheet" href="assets/css/member-home.css">
<link defer rel="stylesheet" href="assets/css/form-style.css">
<link defer rel="stylesheet" href="assets/css/styles.css">
<style>
body {
	margin: 0;
	padding: 0;
	background-image: linear-gradient(rgb(12, 103, 145), rgb(163, 169, 223));
	height: 100vh;
	width: 100%;
}

ul {
	list-style-type: none;
	margin: 10px;
	padding: 10px;
	color: white;
}

li {
	display: inline;
}

li a, tr a {
	color: white;
	padding: 0.1em 1em;
}

nav {
	display: flex;
	background-image: linear-gradient(rgb(163, 169, 223), rgb(12, 103, 145));
	border-radius: 20px;
	margin: 17px;
	width: 100%;
}

li a {
	color: white;
	padding: 0.1em 1em;
}

#footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 2.5rem; /* Footer height */
}

.page-footer {
	background-image: linear-gradient(rgb(163, 169, 223), rgb(12, 103, 145));
	padding: 30px 30px;
	margin-top: 20px;
	color: #800040;
	text-align: center;
	border-radius: 20px;
}
</style>
</head>

<body id="body-main">

	<%HttpSession session1=request.getSession();
	session1.setAttribute("username",request.getRemoteUser());%>
	<nav class="navbar ">
		<ul>
				 <li><a href="<%=request.getContextPath()%>/AppServlet">Home</a></li> 
				<li><a href="<%=request.getContextPath()%>/ManagerServlet/listbatch">Batch management</a></li>
				<li><a href="<%=request.getContextPath()%>/ManagerServlet/managerprofile">View Profile</a></li>
				<li><a href="<%=request.getContextPath()%>/ManagerServlet/listenrolledmembers">Enroll Member</a></li>			
					<li><a href="<%=request.getContextPath()%>/ManagerServlet/enrolledstatus">Enrollment Status</a></li>			
			<li ><a href="<%=request.getContextPath()%>/ManagerServlet/listplan">Plan Management</a></li>
				<li><a href="<%=request.getContextPath()%>/logout.jsp">Logout</a></li>
			</ul>
	</nav>

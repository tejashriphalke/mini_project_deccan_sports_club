
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script defer src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script defer
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script defer
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="assets/css/member-home.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>G-2 Project</title>

</head>

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
tr th,tr td{
 text-align: center;
}

li.a {
	color: white;
}

nav {
	display: flex;
	background-image: linear-gradient(rgb(163, 169, 223), rgb(12, 103, 145));
	border-radius: 20px;
	margin: 17px;
	width: 100%;
	
}


li a, tr a {
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


	<nav class="navbar ml-auto">
		<ul>

			<li><a href="<%=request.getContextPath()%>/AppServlet">Home</a></li>
			<li><a
				href="<%=request.getContextPath()%>/AdminServlet/myProfile">My
					Profile</a></li>
			<li><a
				href="<%=request.getContextPath()%>/AdminServlet/managerList">Manager
					Functions</a></li>
			<li><a
				href="<%=request.getContextPath()%>/AdminServlet/sportsList">Sports
					Functions</a></li>
			<li><a href="<%=request.getContextPath()%>/logout.jsp">Logout</a></li>
		</ul>
	</nav>
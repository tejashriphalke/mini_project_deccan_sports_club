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
<link defer href="assets/css/form-style.css" rel="stylesheet">
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

      <div>

            <nav class="navbar ">
                  <ul>
                  <li><a href="<%=request.getContextPath()%>/AppServlet">Home</a></li>
                  <li><a
                        href="<%=request.getContextPath()%>/CustomerServlet/listplans">see
                              plans</a></li>
                  <li><a
                        href="<%=request.getContextPath()%>/CustomerServlet/listbatches">see
                              batches</a></li>
                  <li><a
                        href="<%=request.getContextPath()%>/CustomerServlet/viewprofile">View
                              Profile</a></li>
                  <li><a
                        href="<%=request.getContextPath()%>/CustomerServlet/viewenrollments">My
                              Enrollments</a></li>
                  <li><a href="<%=request.getContextPath()%>/logout.jsp">Logout</a></li>
            </ul>
            </nav>
      </div>

      <div id="login">

            <div class="container">
                  <div id="login-row"
                        class="row justify-content-center align-items-center">
                        <div id="login-column" class="col-md-6">
                              <div id="login-box" class="col-md-12">
                                    <form id="update-form" class="form"
                                          action="<%=request.getContextPath()%>/CustomerServlet/updateuser"
                                          method="post">

                                          <div class="form-group">
                                                <label for="username" class="text-info">Name</label> <input
                                                      type="text" name="username" id="username" class="form-control"
                                                  value="${user.username}"
                                                      readonly="readonly">
                                          </div>
                                          <div class="form-group">
                                                <label for="password" class="text-info">Password:</label>
                                                <input type="password" name="password" id="password"
                                                      class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}" required="required"
                                                      value="${user.password}">
                                          </div>

                                          <div class="form-group">
                                                <label for="role" class="text-info">Role:</label> <input
                                                      type="text" name="role" id="role" class="form-control"
                                                      required="required" value="member" readonly="readonly">
                                          </div>
                                          <div class="form-group">
                                                <label for="address" class="text-info">Address</label><br>
                                                <input type="text" name="address" id="address"
                                                      class="form-control" required="required"
                                                      value="${user.address}">
                                          </div>
                                          <div class="form-group">
                                                <label for="phone" class="text-info">Contact Number</label>
                                                <input type="text" id="phone" name="phone" class="form-control"
                                                      required="required" pattern="[0-9]{10}" value="${user.phone}">
                                          </div>
                                          <div class="form-group">
                                                <label for="email" class="text-info">Email</label> <input
                                                      type="email" name="email" id="email" class="form-control"
                                                      required="required" value="${user.email}">
                                          </div>
                                          <div class="form-group">
                                                <input type="submit" name="submit" class="btn btn-warning"
                                                      value="Update">
                                          </div>

                                    </form>
                              </div>
                        </div>
                  </div>
            </div>
      </div>


      <!-- CSS only -->
      <link rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
            crossorigin="anonymous">


      <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>


</body>

</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link defer href="assets/css/form-style.css" rel="stylesheet"> 
</head>
<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">Welcome User</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="<%=request.getContextPath()%>/CustomerServlet/adduser" method="post">
                            <h3 class="text-center text-info">Register</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Name</label><br>
                                <input type="text" name="username" id="username" class="form-control" required="required" > 
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}" type="password" name="password" id="password" class="form-control" required="required" placeholder="eg.Abc@123" >
                            </div>
                            <div class="form-group">
                                <label for="address" class="text-info">Address</label><br>
                                <input type="text" name="address" id="address" class="form-control" required="required"  placeholder="eg.Pune" >
                            </div>
                            <div class="form-group">
                                <label for="phone" class="text-info">Contact Number</label><br>
                                <input  type="tel" id="phone"  name="phone" class="form-control" pattern="[0-9]{10}"  required="required">
                            </div>
                             <div class="form-group">
                                <label for="email" class="text-info">Email</label><br>
                                <input  type="email" placeholder="eg.something11@some.com"  name="email" id="email" class="form-control" required="required">
                            </div>
                            <div class="form-group">                                
                                <input  type="submit" name="submit" class="btn btn-info btn-md" value="Register">                                
                                </div>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>









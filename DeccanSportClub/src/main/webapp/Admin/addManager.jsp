<%@include file="header.jsp"%>

	<div id="login">

		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form method="post"
							action="<%=request.getContextPath()%>/AdminServlet/addManager">
							<h3 class="text-center text-info">Add Manager</h3>
							<div class="form-group">
								<label for="username" class="text-info">Name</label><br> <input
									type="text" name="username" class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}" name="password" class="form-control">
							</div>
							<div class="form-group">
								<label for="role" class="text-info">Role:</label><br> <input
									type="text" name="role" value="manager" readonly="readonly"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="address" class="text-info">Address</label><br>
								<input type="text" name="address" id="address"
									class="form-control" required="required">
							</div>
							<div class="form-group">
								<label for="phone" class="text-info">Contact Number</label><br>
								<input type="tel" pattern="[0-9]{10}" id="phone" name="phone"
									class="form-control" required="required">
							</div>
							<div class="form-group">
								<label for="email" class="text-info">Email</label><br> <input
									type="email" name="email" id="email" class="form-control"
									required="required">
							</div>
							<div class="form-group">
								<input type="submit" name="submit" class="btn btn-info btn-md"
									value="Add Manager">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>










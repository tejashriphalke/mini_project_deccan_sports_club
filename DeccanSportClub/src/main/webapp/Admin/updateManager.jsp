<%@include file="header.jsp"%>

	<div id="login">

		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="update-form" class="form"
							action="<%=request.getContextPath()%>/AdminServlet/updateManager"
							method="post">

							<div class="form-group">
								<label for="username" class="text-info">Name</label><br> <input
									type="text" name="username" id="username" class="form-control"
									required="required" value="${manager.username}"
									readonly="readonly">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}"
									class="form-control" required="required"
									value="${manager.password}">
							</div>

							<div class="form-group">
								<label for="role" class="text-info">Role:</label><br> <input
									type="text" name="role" id="role" class="form-control"
									required="required" value="${manager.role}">
							</div>
							<div class="form-group">
								<label for="address" class="text-info">Address</label><br>
								<input type="text" name="address" id="address"
									class="form-control" required="required"
									value="${manager.address}">
							</div>
							<div class="form-group">
								<label for="phone" class="text-info">Contact Number</label><br>
								<input type="text" id="phone" name="phone" pattern="[0-9]{10}" class="form-control"
									required="required" value="${manager.phone}">
							</div>
							<div class="form-group">
								<label for="email" class="text-info">Email</label><br> <input
									type="email" name="email" id="email" class="form-control"
									required="required" value="${manager.email}">
							</div>
							<div class="form-group">
								<input type="submit" name="submit" class="btn btn-info btn-md"
									value="Update Manager">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>






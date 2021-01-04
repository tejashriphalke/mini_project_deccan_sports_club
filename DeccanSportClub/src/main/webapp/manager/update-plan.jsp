<%@include file="manager-header.jsp"%>
<div id="login">

	<div class="container">
		<div id="login-row"
			class="row justify-content-center align-items-center">
			<div id="login-column" class="col-md-6">
				<div id="login-box" class="col-md-12">
					<form id="update-form" class="form"
						action="<%=request.getContextPath()%>/ManagerServlet/updateplan"
						method="post">

						<div class="form-group">
							<label for="username" class="text-info">Plan Id</label><br>
							<input type="Number" name="planId" class="form-control"
								required="required" value="${plans.planId}" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="password" class="text-info">Plan Name</label><br>
							<input type="text" name="planName" class="form-control"
								required="required" value="${plans.planName}">
						</div>

						<div class="form-group">
							<label for="role" class="text-info">Fees</label><br> <input
								type="Number" name="fees" class="form-control"
								required="required" value="${plans.fees}">
						</div>
						<div class="form-group">
							<label for="address" class="text-info">Duration</label><br>
							<input type="number" name="duration" class="form-control"
								required="required" min="1" max="12" value="${plans.duration}">
						</div>

						<div class="form-group">
							<input type="submit" name="submit" class="btn btn-success"
								value="Update Plan">
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</div>





</body>

</html>

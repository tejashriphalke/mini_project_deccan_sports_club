<%@include file="manager-header.jsp"%>

<div id="login">

	<div class="container">
		<div id="login-row"
			class="row justify-content-center align-items-center">
			<div id="login-column" class="col-md-6">
				<div id="login-box" class="col-md-12">
					<form id="update-form" class="form"
						action="<%=request.getContextPath()%>/ManagerServlet/updatebatch"
						method="post">

						<div class="form-group">
							<label for="username" class="text-info">Start BatchId</label><br>
							<input type="text" name="batchId" class="form-control"
								required="required" value="${batches.batchId}"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="password" class="text-info">Start Date</label><br>
							<input type="date" name="startDate" class="form-control"
								required="required" value="${batches.startDate}">
						</div>

						<div class="form-group">
							<label for="role" class="text-info">End Date</label><br> <input
								type="date" name="endDate" class="form-control"
								required="required" value="${batches.endDate}">
						</div>
						<div class="form-group">
							<label for="address" class="text-info">Batch Size</label><br>
							<input type="text" name="batchSize" class="form-control"
								required="required" value="${batches.batchSize}">
						</div>
						<div class="form-group">
							<label for="phone" class="text-info">Sport Id</label><br> <input
								type="number" name="sportId" class="form-control"
								required="required" value="${batches.sportId}">
						</div>
						<div class="form-group">
							<label for="email" class="text-info">Plan Id</label><br> <input
								type="number" name="planId" class="form-control"
								required="required" value="${batches.planId}">
						</div>
						<div class="form-group">
							<input type="submit" name="submit" class="btn btn-success"
								value="Update Batch">
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</div>



<%@include file="manager-footer.jsp"%>


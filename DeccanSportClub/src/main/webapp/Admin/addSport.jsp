<%@include file="header.jsp"%>

	<div id="login">

		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form method="post"
							action="<%=request.getContextPath()%>/AdminServlet/addSport">
						
							<div class="form-group">
								<label for="username" class="text-info">Enter Sport Name</label><br> 
									<input type="text" name="sportName" class="form-control">
									
							</div>
							<div>
							<input type="submit" value="Add Sport"  class="btn btn-success">
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="footer.jsp"%>

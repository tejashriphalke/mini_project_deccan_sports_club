<%@include file="manager-header.jsp"%>	 
	<form method="post"
		action="<%=request.getContextPath()%>/ManagerServlet/addplan">
		<table class="table">
			<tr>
		    <th>Plan Name</th>
		    <td><input type="text" name="planName"></td>
		  	</tr>
		  	<tr>
		    <th>Fees</th>
		    <td><input type="Number" name="fees"></td>
		 	 </tr>
		  	<tr>
		    <th>Duration</th>
		    <td><input type="number" name="duration" min="1" max="12"></td>
		  	</tr>
		  	
	</table>
	
		<input type="submit" value="Add Plan" class="btn btn-success">
	</form>
</body>
	<%@include file="manager-footer.jsp"%>
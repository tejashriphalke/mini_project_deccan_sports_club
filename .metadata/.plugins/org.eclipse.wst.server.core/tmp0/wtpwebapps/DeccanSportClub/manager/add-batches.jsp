<%@include file="manager-header.jsp"%>	 
	<form method="post"
		action="<%=request.getContextPath()%>/ManagerServlet/addbatch">
		<table class="table">
			<tr>
		    <th>Start Date:</th>
		    <td><input type="date" name="startDate"></td>
		  	</tr>
		  	<tr>
		    <th>End Date:</th>
		    <td><input type="date" name="endDate"></td>
		 	 </tr>
		  	<tr>
		    <th>Batch Size:</th>
		    <td><input type="number" name="batchSize"></td>
		  	</tr>
		  	<tr>
		    <th>Sport id:</th>
		    <td><input type="number" name="sportId"></td>
		  	</tr>
		  	<tr>
		    <th>Plan id:</th>
		    <td><input type="number" name="planId"> </td>
		  	</tr>
	</table>
	
		<input type="submit" value="Add Batch" class="btn btn-success">
	</form>
</body>
	<%@include file="manager-footer.jsp"%>
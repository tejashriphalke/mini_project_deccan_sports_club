<%@include file="manager-header.jsp"%>
<li><a href="<%=request.getContextPath()%>/manager/add-batches.jsp">Add
		New Batch</a></li>
<br>
<br>

<!-- Table -->
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>BatchId</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Batch Size</th>
			<th>Sport Name</th>
			<th>planName</th>
			<th>Fees</th>
			<th>Duration</th>
			<th colspan="2">Actions</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="batch" items="${batches}">
			<tr>
				<!-- user.getUsername(); user.getUserrole() -->
				<td><c:out value="${batch.batchId}"></c:out></td>
				<td><c:out value="${batch.startDate}"></c:out></td>
				<td><c:out value="${batch.endDate}"></c:out></td>
				<td><c:out value="${batch.batchSize}"></c:out></td>
				<td><c:out value="${batch.sportName}"></c:out></td>
				<td><c:out value="${batch.planName}"></c:out></td>
				<td><c:out value="${batch.fees}"></c:out></td>
				<td><c:out value="${batch.duration}"></c:out></td>


				<td><a
					href="<%=request.getContextPath()%>/ManagerServlet/deletebatch?batchId=${batch.batchId}"
					class="btn btn-success">Delete</a></td>
				<td><a
					href="<%=request.getContextPath()%>/ManagerServlet/editbatch?batchId=${batch.batchId}"
					class="btn btn-success">Update</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@include file="manager-footer.jsp"%>
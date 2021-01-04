<%@include file="manager-header.jsp"%>
<li><a href="<%=request.getContextPath()%>/manager/add-plan.jsp"
	class="btn btn-info m-3" role="button">add plan</a></li>
<!-- Table -->
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>Plan Id</th>
			<th>Plan Name</th>
			<th>Fees</th>
			<th>Duration</th>
			<th colspan="2">Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="plans" items="${plans}">
			<tr>
				<!-- user.getUsername(); user.getUserrole() -->
				<td><c:out value="${plans.planId}"></c:out></td>
				<td><c:out value="${plans.planName}"></c:out></td>
				<td><c:out value="${plans.fees}"></c:out></td>
				<td><c:out value="${plans.duration}"></c:out></td>
				<td><a
					href="<%=request.getContextPath()%>/ManagerServlet/deleteplan?planId=${plans.planId}"
					class="btn btn-danger" role="button">Delete</a></td>
				<td><a
					href="<%=request.getContextPath()%>/ManagerServlet/editplan?planId=${plans.planId}"
					class="btn btn-warning" role="button">Update</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@include file="manager-footer.jsp"%>
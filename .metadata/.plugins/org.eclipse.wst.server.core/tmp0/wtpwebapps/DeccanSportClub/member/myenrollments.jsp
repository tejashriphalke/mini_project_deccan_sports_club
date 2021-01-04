<%@include file="member-header.jsp"%>
${msg}
<!-- Table -->
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>EnrollmentId</th>
			<th>BatchId</th>
			<th>StartDate</th>
			<th>EndDate</th>
			<th>Status</th>
			<th colspan="2">Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="en" items="${enrollments}">
			<tr>
				<!-- user.getUsername(); user.getUserrole() -->
				<td><c:out value="${en.enrollId}"></c:out></td>
				<td><c:out value="${en.batchId}"></c:out></td>
				<td><c:out value="${en.startDate}"></c:out></td>
				<td><c:out value="${en.endDate}"></c:out></td>
				<td><c:out value="${en.mStatus}"></c:out></td>
				<td><a
					href="<%=request.getContextPath()%>/CustomerServlet/renew?enrollId=${en.enrollId}" class="btn btn-success">RENEW</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@include file="member-footer.jsp"%>
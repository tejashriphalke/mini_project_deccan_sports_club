<%@include file="member-header.jsp"%>

	<!-- Table -->
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Plan Name</th>
				<th>Fees</th>
				<th>Duration</th>
				<th colspan="2">Action</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="plan" items="${plans}">
				<tr>
					<!-- user.getUsername(); user.getUserrole() -->
					<td><c:out value="${plan.planName}"></c:out></td>
					<td><c:out value="${plan.fees}"></c:out></td>
					<td><c:out value="${plan.duration}"></c:out></td>
					<td><a
						href="<%=request.getContextPath()%>/CustomerServlet/listbatches1?planId=${plan.planId}" class="btn btn-success">seebatches</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@include file="member-footer.jsp"%>
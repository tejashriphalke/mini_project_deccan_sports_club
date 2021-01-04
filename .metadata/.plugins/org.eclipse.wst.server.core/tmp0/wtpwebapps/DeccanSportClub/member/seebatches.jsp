<%@include file="member-header.jsp"%>
<!-- Table -->
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>Batch Id</th>
			<th>start Date</th>
			<th>end Date</th>
			<th>batch size</th>
			<th>sport Name</th>
			<th colspan="2">Action</th>
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
				<td><a
					href="<%=request.getContextPath()%>/CustomerServlet/enrolluser?batchId=${batch.batchId}"
					class="btn btn-success">Enroll</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@include file="member-footer.jsp"%>
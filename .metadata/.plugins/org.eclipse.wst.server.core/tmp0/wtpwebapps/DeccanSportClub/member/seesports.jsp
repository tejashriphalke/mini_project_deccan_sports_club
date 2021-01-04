<%@include file="member-header.jsp"%>
<!-- Table -->
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Sport Id</th>
			<th scope="col">Sport Name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="sports" items="${sports}">
			<tr>
				<!-- user.getUsername(); user.getUserrole() -->
				<td><c:out value="${sports.sportId}"></c:out></td>
				<td><c:out value="${sports.sportName}"></c:out></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@include file="member-footer.jsp"%>
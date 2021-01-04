<%@include file="header.jsp"%>
<body>

	<form method="post">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<!-- 	<th>ID</th> -->
					<th>Name</th>
					<th>Password</th>
					<th>Role</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Email</th>
				</tr>

			</thead>
			<tbody>

				<tr>
					<!-- user.getUsername(); user.getUserrole() -->
					<%-- <td><c:out value="${admin.userId}"></c:out></td> --%>
					<td><c:out value="${admin.username}"></c:out></td>
					<td><c:out value="${admin.password}"></c:out></td>
					<td><c:out value="${admin.role}"></c:out></td>
					<td><c:out value="${admin.address}"></c:out></td>
					<td><c:out value="${admin.phone}"></c:out></td>
					<td><c:out value="${admin.email}"></c:out></td>

				</tr>

			</tbody>
		</table>

	</form>
</body>
<%@include file="footer.jsp"%>



















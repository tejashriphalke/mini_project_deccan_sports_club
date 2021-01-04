<%@include file="manager-header.jsp"%>

<body>


	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Email</th>

			</tr>

		</thead>
		<tbody>

			<tr>
				<!-- user.getUsername(); user.getUserrole() -->
				<!-- user.getUsername(); user.getUserrole() -->
				<td><c:out value=" ${managerprofile.username}"></c:out></td>
				<td><c:out value="${managerprofile.address}"></c:out></td>
				<td><c:out value="${managerprofile.phone}"></c:out></td>
				<td><c:out value="${managerprofile.email}"></c:out></td>


			</tr>

		</tbody>
	</table>


	<%@include file="manager-footer.jsp"%>
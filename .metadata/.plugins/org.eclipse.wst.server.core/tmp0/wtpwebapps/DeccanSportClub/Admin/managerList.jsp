<%@include file="header.jsp"%>

	<li><a href="<%=request.getContextPath()%>/Admin/addManager.jsp" class="btn-success">Add Manager</a></li>
	<!-- Table -->
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Manager Id</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Role</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Email</th>
				<th colspan="2">Actions</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="manager" items="${manager}">
				<tr>
					<td><c:out value="${manager.userId}"></c:out></td>
					<td><c:out value="${manager.username}"></c:out></td>
					<td><c:out value="${manager.password}"></c:out></td>
					<td><c:out value="${manager.role}"></c:out></td>
					<td><c:out value="${manager.address}"></c:out></td>
					<td><c:out value="${manager.phone}"></c:out></td>
					<td><c:out value="${manager.email}"></c:out></td>

					<td><a
						href="<%=request.getContextPath()%>/AdminServlet/deleteManager?username=${manager.username}" class="btn-danger">Delete</a>
					</td>
					<td><a
						href="<%=request.getContextPath()%>/AdminServlet/editManager?username=${manager.username}" class="btn-success">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- FOOTER -->
	<%@include file="footer.jsp"%>
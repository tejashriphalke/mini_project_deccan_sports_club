<%@include file="header.jsp"%>


<li><a href="<%=request.getContextPath()%>/Admin/addSport.jsp" class="btn-success">Add
	Sport</a></li>
	<!-- Table -->
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>sportId</th>
				<th>sportName</th>
				<th colspan="2">Actions</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="sports" items="${sports}">
				<tr>
					<!-- user.getUsername(); user.getUserrole() -->
					<td><c:out value="${sports.sportId}"></c:out></td>
					<td><c:out value="${sports.sportName}"></c:out></td>


					<td><a
						href="<%=request.getContextPath()%>/AdminServlet/deleteSport?sportName=${sports.sportName}" class="btn-danger">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@include file="footer.jsp"%>
<%@include file="header.jsp"%>

<li>
	<h3 class="text-success">
		Welcome
		<%=request.getRemoteUser()%>,
	</h3>
	<br>
<br> <a
	href="<%=request.getContextPath()%>/AdminServlet/managerList">Manager
		Operations</a> <br> <a
	href="<%=request.getContextPath()%>/AdminServlet/sportsList">Sports
		Operations</a> <br> <a
	href="<%=request.getContextPath()%>/log/mylog.log">showLogs</a> <br>
</li>

<%@include file="footer.jsp"%>

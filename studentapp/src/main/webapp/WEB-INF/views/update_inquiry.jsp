<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Inquiries</title>
</head>
<body>
	<h2>Update Student Details</h2>
		<form action="updateInquiry" method="post">
			<pre>
				Email: <input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
				Mobile: <input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
				<input type="submit" value="update"/>
			</pre>
		</form>
		<p>
		</p>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
   <h2>Login here</h2>
   <form action="verifylogin" method="post">
	   Email<input type="email" name="email"/>
	   Password<input type="password" name="password"/>
	   <input type="submit" value="login"/>
   </form>
   <p>
   
	   <%
		   if(request.getAttribute("errorMessage")!=null)
			   out.println(request.getAttribute("errorMessage"));
	   %>
   </p>

</body>
</html>
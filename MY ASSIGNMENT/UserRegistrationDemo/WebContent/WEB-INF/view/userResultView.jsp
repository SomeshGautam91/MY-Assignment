<%@ page import="com.yash.training.model.Users" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Users user=(Users)request.getAttribute("User");
	if(user==null)
	{
		out.println("UserName or Password is Incorrect!!!");
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").include(request,response);
	}
	else
	{
		out.println("Welcome "+ user.getName());
	}




%>

</body>
</html>
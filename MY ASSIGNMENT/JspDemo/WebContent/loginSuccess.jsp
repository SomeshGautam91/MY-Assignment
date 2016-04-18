<%@ page import="com.yash.training.pojo.JspJavaBean" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
</head>
<body>
Welcome:
<% 
JspJavaBean jjb=(JspJavaBean) request.getAttribute("bean"); 
%>
<%= jjb.getName() %>
</body>
</html>
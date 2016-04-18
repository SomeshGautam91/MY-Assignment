<%@ page import="com.yash.training.pojo.JspJavaBean" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">





</script>
</head>
<body>

Welcome:
<% 
String name1=(String)request.getAttribute("name"); 
%>
<%=name1 %>

<form action="LOS" >
<input type="submit" value="Logout" id="Logout"/>
</form>

</body>
</html>
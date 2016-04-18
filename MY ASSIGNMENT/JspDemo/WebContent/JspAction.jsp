<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="object" class="com.yash.training.pojo.JspJavaBean"/>

<jsp:setProperty name="object" property="*"/>


Welcome:<br>
<jsp:getProperty name="object" property="name"/></br>
<jsp:getProperty name="object" property="email"/></br>
<jsp:getProperty name="object" property="password"/></br>
</body>
</html>
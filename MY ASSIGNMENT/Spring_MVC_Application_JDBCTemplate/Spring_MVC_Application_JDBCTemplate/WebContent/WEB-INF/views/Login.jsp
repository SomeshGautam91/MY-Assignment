<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:include page="/WEB-INF/views/Header.jsp" /> --%>
<jsp:include page="/WEB-INF/views/TopHeader.jsp"/>
<center>
	<form action="./Check.do" method="post">
	<fieldset style="width:300px; color:red; border-color:black ">
	<legend >User Login</legend>
	<table>
      <tr>
           <td style="color:red">User Name :</td>
           <td><input type="text" name="username" /></td>
           <td style="color: red"><s:errors path="user.username"  /></td>
      </tr>
      <tr>
           <td style="color:red">Password :</td>
           <td><input type="password" name="password" /></td>
           <td style="color: red"><s:errors  path="user.password"  /></td>
       </tr>
       <tr>
            <td colspan="2" style="color: red" >${msg}</td>
       </tr>
       <tr>
            <td colspan="2" ><input type="submit" value="Login" style="color:red"/></td>
       </tr>      
</table>

</center>
</fieldset>
</form>
</body>
</html>
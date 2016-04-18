<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/TopHeader.jsp"/>


<jsp:include page="/WEB-INF/views/Header.jsp" />
<center> 
<table border="1" style="margin-top:50px; ">
    <tr>
       <th style="color:red">Name</th>
       <th style="color:red">Contact</th>
       <th style="color:red">Email</th>
       <th style="color:red">Address</th>
       <th style="color:red">Operation</th>
    </tr>
    
        <c:forEach items="${list}" var="element">
        <tr>
          		<td><c:out value="${element.name}"/></td>
           		<td><c:out value="${element.contact}"/></td>
            	<td><c:out value="${element.email}"/></td>
             	<td><c:out value="${element.address}" /></td>
              	<td><a href="../Contact/Delete.do?contact_id=${element.contact_id}">Delete</a><a href="../Contact/Edit.do?contact_id=${element.contact_id}">Edit</a></td>
        </tr>
        </c:forEach>  
   



</table>

</center>
</body>
</html>
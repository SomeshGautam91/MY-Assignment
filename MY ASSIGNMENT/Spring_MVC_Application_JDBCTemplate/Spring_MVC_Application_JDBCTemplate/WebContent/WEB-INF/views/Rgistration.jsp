<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="S" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/TopHeader.jsp"/>
 <center>
            <form action="./Add.do" method="post">
                 <table>
                       <tr>
                          <td> Name</td>
                           <td><input type="text" name="name" ></td>
                           <td style="color: red"><S:errors path="user.name" /></td>
                       </tr>
                       <tr>
                           <td> Contact</td>
                           <td><input type="text" name="contact" ></td>
                           <td style="color: red"><S:errors path="user.contact" /></td>
                       </tr>
                        <tr>
                           <td> Email</td>
                           <td><input type="text" name="email" ></td>
                           <td style="color: red"><S:errors path="user.email" /></td>
                       </tr>
                        <tr>
                           <td> User Name</td>
                           <td><input type="text" name="username" ></td>
                           <td style="color: red"><S:errors path="user.username" /></td>
                       </tr>
                        <tr>
                           <td> Password</td>
                           <td><input type="password" name="password" ></td>
                           <td style="color: red"><S:errors path="user.password" /></td>
                       </tr>
                       <tr>
                          <td colspan="1"><input type="submit" value="Save" ></td>
                       </tr>


                 </table>


            </form>
    </center>
</body>
</html>
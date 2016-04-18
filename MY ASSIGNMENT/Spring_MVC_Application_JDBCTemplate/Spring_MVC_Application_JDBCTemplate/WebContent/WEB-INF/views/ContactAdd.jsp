<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="S"%> 
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/TopHeader.jsp"/>
<%-- <jsp:include page="/WEB-INF/views/Header.jsp" /> --%>
        <center>
            <form action="./Save.do" method="post">
            <fieldset style="width:400px; border-color:black">
            	<legend style="color:red">Add Contact</legend>
                 <table>
                  
                       <tr>
                          <td style="color:red"> Name</td>
                           <td><input type="text" name="name"  ></td>
<%--                            <td style="color: red"><S:errors path="contact.name" /></td> --%>
                       </tr>
                       <tr>
                           <td style="color:red"> Contact</td>
                           <td><input type="text" name="contact" ></td>
<%--                            <td style="color: red"><S:errors path="contact.contact" /></td> --%>
                       </tr>
                        <tr>
                           <td style="color:red"> Email</td>
                           <td><input type="text" name="email" ></td>
<%--                            <td style="color: red"><S:errors path="contact.email" /></td> --%>
                       </tr>
                       <tr>
                           <td style="color:red"> Address</td>
                           <td><textarea rows="" cols="" name="address" ></textarea></td>
<%--                            <td style="color: red"><S:errors path="contact.email" /></td> --%>
                       </tr>
                       
                       <tr>
                          <td colspan="2" ><input type="submit" value="Save" style="color:red" ></td>
                       </tr>

                  
                 </table>

			</fieldset>
            </form>
    </center>

</body>
</html>
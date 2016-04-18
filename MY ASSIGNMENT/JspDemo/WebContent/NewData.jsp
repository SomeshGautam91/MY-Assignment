<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	
   String fname = "";
   String lname = "";
   String mobile="";
   String email="";
   String q = request.getParameter("q");
   try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
        Statement smt = con.createStatement(); //Create Statement to interact
        ResultSet r = smt.executeQuery("select * from employeeinfo where(Id='" + q + "');");
        while (r.next()) {
          fname = r.getString("First_Name");
          lname = r.getString("Last_Name");
          mobile= r.getString("Mobile_No");
          email = r.getString("Email");
        }
        con.close();
   } catch (Exception e) {
        e.printStackTrace();
   }
%>
Name:<%out.print(fname+" "+lname);%>
<br>
Mobile_No:<%out.print(mobile);%>
<br>
Email:<%out.print(email);%>
</body>
</html>
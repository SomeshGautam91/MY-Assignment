<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="S" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#section{
 	height:50px;
 	width:1000px;
 	text-align:center;
 	color:white;
/*  	text-shadow:2px 2px #FF0000; */
/*  	background-color:#333300; */
 	
 }
 
#underSection
{

float:left;
margin-left: 110px;



} 
 
 
</style>


</head>
<body>
<h2 style="float:left;color:red">Welcome ${user1.name}</h2><br>
   
   <fieldset style="width:400px; border-color:black">
   <legend style="color:red">User Operation</legend>
   		<div id="section">
   	 		<div id="underSection">
     				<a href="../Contact/AddContact.do" style="color:red">Add Contact</a>
     				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     				<a href="../Contact/View.do"  style="color:red">View Contact</a>
    		 </div>
     		<form action="../Contact/View.do" method="post">
          			<input type="text" name="name">
          			<input type="submit" value="Search" style="color:red">
     		</form> 
  	    </div>
   </fieldset>

</body>
</html>
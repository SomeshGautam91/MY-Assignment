
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
 #div{
 	height:50px;
 	width:1000px;
 	color:white;
 	text-shadow:2px 2px #FF0000;
 	background-color:#333300;
 	
 }
 #newDiv
 {
 	float:right;
 
 
 }
</style>




</head>
<body>

<div id="div">
<h1>Welcome:${username}</h1>
</div>

<a href="../contact/showContact.htm"><input type="submit" value="ADD"/></a> 
<a href="../contact/contacts.htm"><input type="submit" value="LIST"/></a>
<div id="newDiv">
<form action="../contact/searchContact.htm">
	<input type="text" name="textsearch"/>
	<input type="submit" value="SEARCH"/></a>
</form>
</div>




</body>
</html>
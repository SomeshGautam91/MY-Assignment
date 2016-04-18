<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<body>
<spring:url var="searchCustomersLink" value="/web/SearchCustomers">
</spring:url>

<center>	
  <h1>Deere Standard framework for Java (DSFJ)<br>Sample Application</h1>
  <h2>Error</h2>
     Requested URL/Resource not found. 404 error code. 
     <br></br>
     Please try again with different URL or click following URL to go to home page
	 <A href="${searchCustomersLink}">JD Order</A>
</center>     
</body>

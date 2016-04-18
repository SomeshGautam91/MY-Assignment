<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>				
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<spring:url var="homepagecssUrl" value="/styles/main.css" />
<link href="${homepagecssUrl}" rel="stylesheet" type="text/css">

<form:form name="frm" method="post" modelAttribute="customer">
<form:errors path="*" cssClass="error" />
<input type="hidden" name="userAction" value="" >
<div class="row"> <!-- Page Title Row -->
	<div class="text-center" >
		<h1 class="pagesubheader"><spring:message code="ViewCustomer.pageSubHeader" /></h1>
	</div>
</div>	<!-- End of page title row -->
<div class="row col-md-8 col-md-offset-2 viewbox">
	<div class="row text-center" >
		<h3>${customer.name}</h3>
	</div>
	<div class="row viewDetailBox" >
		<div class="col-md-5" >
		   		<spring:url var="customerPhotoUrl" value="/web/ViewCustomer/Photo?customerNumber={number}" >
		   		   <spring:param name="number" value="${customer.number}" />		
		   		</spring:url>
		   		<a href="${customerPhotoUrl}" target="wndCustomer">
	           			<img src="${customerPhotoUrl}" class="img-rounded viewPhoto" />
	           	</a>
		</div>
		<div class="col-md-7" >
			<div class="row"><div class="col-xs-6 viewcustomerlabelpadding" ><label><strong><spring:message code="ViewCustomer.CustomerNumber" /></strong></label></div><div class="col-xs-6"><strong>${customer.number}</strong></div> </div>
			<div class="row"><div class="col-xs-6 viewcustomerlabelpadding" ><label><strong><spring:message code="ViewCustomer.Address" /></strong></label></div><div class="col-xs-6">${customer.address}</div> </div>
			<div class="row"><div class="col-xs-6 viewcustomerlabelpadding" ><label><strong><spring:message code="ViewCustomer.City" /></strong></label></div><div class="col-xs-6">${customer.city}</div> </div>
			<div class="row"><div class="col-xs-6 viewcustomerlabelpadding" ><label><strong><spring:message code="ViewCustomer.Country" /></strong></label></div><div class="col-xs-6">${customer.state.country.name}</div> </div>
			<div class="row"><div class="col-xs-6 viewcustomerlabelpadding" ><label><strong><spring:message code="ViewCustomer.State" /></strong></label></div><div class="col-xs-6">${customer.state.name}</div> </div>
			<div class="row"><div class="col-xs-6 viewcustomerlabelpadding" ><label><strong><spring:message code="ViewCustomer.ZipCode" /></strong></label></div><div class="col-xs-6">${customer.zip}</div> </div>
		</div>
		
	</div>
	
</div>
</form:form>
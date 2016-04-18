<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<div class="row"> <!-- Page Title Row -->
		<div class="text-center">
			<h1 class="pagesubheader"><spring:message code="EditCustomer.pageSubHeader" /></h1>
		</div>
	</div>	<!-- End of page title row -->
	<div class="row">
		<jsp:include page="Flash.jsp" flush="true"/>
	</div>
	
	<div class="row editcustomerformrowmargin" >
	
		<form:form class="form-horizontal col-md-8 col-md-offset-2 formData" method="post" modelAttribute="customerForm" enctype="multipart/form-data" name="frm">
				<input type="hidden" name="userAction" value="">
				<form:hidden path="number" />
			<div class="form-group">
    					<label for="number" class="col-sm-4 control-label"><spring:message code="EditCustomer.CustomerNumber" /></label>
    					<div class="col-sm-6">
       						<form:input type="text" class="form-control" id="customerNumber"  readonly="true" path="number"></form:input>
    					</div>
 					</div>
			<div class="form-group">
    					<label for="name" class="col-sm-4 control-label"><spring:message code="EditCustomer.Name" /></label>
    					<div class="col-sm-6">
       						<form:input type="text" class="form-control" id="name" path="name" ></form:input>
       						<form:errors path="name" cssClass="error" ></form:errors>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="address" class="col-sm-4 control-label"><spring:message code="EditCustomer.Address" /></label>
    					<div class="col-sm-6">
       						<form:input type="text" class="form-control" id="address" path="address"></form:input>
       						<form:errors path="address" cssClass="error"></form:errors>
    					</div>
 					</div>
			<div class="form-group">
    					<label for="city" class="col-sm-4 control-label"><spring:message code="EditCustomer.City" /></label>
    					<div class="col-sm-6">
       						<form:input type="text" class="form-control" id="city" path="city"></form:input>
       						<form:errors path="city" cssClass="error"></form:errors>
       						
    					</div>
 					</div>
        		<div class="form-group">
       				<label for="countrySelect"  class="col-sm-4 control-label">
          					<spring:message code="EditCustomer.Country" />
       				</label>
       				<div class="col-sm-6">
         				<form:select id="country" class="form-control" path="countryCode" size="1">
			  				<c:forEach var="country" items="${countries}">
			    				<form:option value="${country.code}">
			    					${country.name}
			    				</form:option>
			  				</c:forEach>
			  			</form:select>
			  			<form:errors path="countryCode" cssClass="error"></form:errors>
       				</div>
    				</div>
 					<div class="form-group">
    					<label for="state" class="col-sm-4 control-label"><spring:message code="EditCustomer.State" /></label>
    					<div class="col-sm-6">
         					<form:select id="state" class="form-control" path="stateCode" size="1">
							  <c:forEach var="state" items="${states}">
							    <form:option value="${state.code}">
							    	${state.name}
							    </form:option>
							  </c:forEach>
         					</form:select>
							<form:errors path="stateCode" cssClass="error"></form:errors>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="zipCode" class="col-sm-4 control-label"><spring:message code="EditCustomer.ZipCode" /></label>
    					<div class="col-sm-6">
       						<form:input type="text" class="form-control" id="zipCode" path="zip"></form:input>
       						<form:errors path="zip" cssClass="error"></form:errors>
    					</div>
 					</div>
 					<div class="form-group">
   						<label for="customerPhoto" class="col-sm-4 control-label"><spring:message code="EditCustomer.Photo" /></label>
						<div class="col-sm-6" >
								<spring:url var="customerPhotoUrl" value="/web/EditCustomer/Photo?customerNumber={number}" >
								   <spring:param name="number" value="${customerForm.number}" />		
								</spring:url>
								<a href="${customerPhotoUrl}" target="wndCustomer">
								<img src="${customerPhotoUrl}" class="img-rounded viewPhoto" />
							</a>
							<form:input type="file" id="inputfile" name="image" path=""></form:input>
						</div>
					</div>
					<div class="form-group text-center">
							<button type="button" class="btn btn-success " onclick="save()"><span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;<spring:message code="EditCustomer.Modify" /></button>
							<button type="button" class="btn btn-primary " onclick="cancel()"> <span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;<spring:message code="EditCustomer.Cancel" /></button>
					</div>
		</form:form>
	</div>

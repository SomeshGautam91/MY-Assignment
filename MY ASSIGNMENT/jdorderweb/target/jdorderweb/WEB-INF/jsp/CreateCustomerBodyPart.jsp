<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>				
	<div class="row"> <!-- Page Title Row -->
		<div class="text-center" >
			<h1 class="pagesubheader"><spring:message code="CreateCustomer.pageSubHeader" /></h1>
		</div>
	</div>	<!-- End of page title row -->
	<div class="row">
		<jsp:include page="Flash.jsp" flush="true"/>
		
	</div>
	<div class="row dataRow" >
	
		<form:form name="frm" class="form-horizontal col-md-8 col-md-offset-2 formData"  method="post" modelAttribute="customerForm">
		
			<input type="hidden" name="userAction" value="">
			<div class="form-group">
    					<label for="number" class="col-sm-4 control-label"><spring:message code="CreateCustomer.CustomerNumber" /></label>
    					<div class="col-sm-6">
       						<form:input type="text" path = "" class="form-control" id="customerNumber" readonly="true"></form:input>
    					</div>
 					</div>
			<div class="form-group">
    					<label for="name" class="col-sm-4 control-label"><spring:message code="CreateCustomer.Name" /></label>
    					<div class="col-sm-6">
	       					<form:input type="text" path="name" class="form-control" id="name" ></form:input>
	       					<form:errors path="name" cssClass="error" ></form:errors>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="address" class="col-sm-4 control-label"><spring:message code="CreateCustomer.Address" /></label>
    					<div class="col-sm-6">
	       					<form:input type="text" path="address" class="form-control" id="address" ></form:input>
	       					<form:errors path="address" cssClass="error"></form:errors>
    					</div>
    			</div>
 				<div class="form-group">
    					<label for="city" class="col-sm-4 control-label"><spring:message code="CreateCustomer.City" /></label>
    					<div class="col-sm-6">
       						<form:input type="text" path="city"  class="form-control" id="city" ></form:input>
       						<form:errors path="city" cssClass="error"></form:errors>
    					</div>
 					</div>
 			<div class="form-group">
       				<label for="countrySelect"  class="col-sm-4 control-label">
          					<spring:message code="CreateCustomer.Country" />
       				</label>
       				<div class="col-sm-6">
         					<form:select id="country" class="form-control" path="countryCode">
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
    					<label for="state" class="col-sm-4 control-label"><spring:message code="CreateCustomer.State" /></label>
    					<div class="col-sm-6">
         					<form:select id="state" path="stateCode" class="form-control">
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
    					<label for="zipCode" class="col-sm-4 control-label"><spring:message code="CreateCustomer.ZipCode" /></label>
    					<div class="col-sm-6">
       						<form:input type="text" path="zip" class="form-control" id="zipCode" ></form:input>
       						<form:errors path="zip" cssClass="error"></form:errors>
    					</div>
 					</div>
 					
 					<%-- <div class="form-group">
   						<label for="customerPhoto" class="col-sm-4 control-label"><spring:message code="CreateCustomer.Photo" /></label>
    					<div class="col-sm-6">
    						<!-- Below code doesnt work as it is a reported bug from spring mvc. Do not use type=file with form:input -->
    						<!--<form:input type="file" id="inputfile" name="image" path=""></form:input>-->
    						<input type="file" name="image"  size="30">
    					</div>
						</div>
 					 --%>
				<div class="form-group text-center">
						<button type="button" class="btn btn-success " onclick="save()">
							<span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;<spring:message code="CreateCustomer.Create" />
						</button>
						
				</div>
		</form:form>
	</div>

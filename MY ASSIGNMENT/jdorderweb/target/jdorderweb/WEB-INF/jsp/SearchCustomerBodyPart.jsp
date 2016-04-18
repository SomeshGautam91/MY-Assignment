
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>				
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<form:form name="frm" method="post" modelAttribute="searchCriteria">
	<input type="hidden" name="userAction" value="" >
				<div class="row"> <!-- Page Title Row -->
					<div class="text-center">
						<h1 class="pagesubheader"><spring:message code="SearchCustomer.pageSubHeader" /></h1>
					</div>
				</div>	<!-- End of page title row -->
				<div class="row">
					<jsp:include page="Flash.jsp" flush="true"/>
				
				</div>
				
				<div class="row">	
					<div>
						<form>
							<div class="col-md-8 col-md-offset-2 searchBox" >
								<div class="input-group">
									<form:input path="searchNameOrNumber" type="text" class="form-control input-lg" id="customerNumberOrName" placeholder="Enter Customer Number or Name"/>
										<span class="input-group-btn serachButtonGroup">
											<button type="button" class="btn btn-success input-lg"	onclick="search()">
												<span class="glyphicon glyphicon-search"></span>
											</button>
											<button type="button" class="btn btn-primary input-lg" onclick="resetForm()">
												<span class="glyphicon glyphicon-remove"></span>
											</button>
									   </span>
								</div>
							</div>
						</form>	
					</div>
				</div>	
				<form:errors path="*" cssClass="error" />
				<c:if test="${!empty customerList}">
				<div class="row">
					<div class="col-xs-10 col-md-offset-1  table-responsive searchResult" >
						<table class="table table-bordered table-striped text-center" id="customerTable">
							<thead>
									<tr>
										<th><spring:message code="SearchCustomer.CustomerNumber" /></th>
										<th><spring:message code="SearchCustomer.Name" /></th>
										<th><spring:message code="SearchCustomer.Address" /></th>
										<th><spring:message code="SearchCustomer.City" /></th>
										<th><spring:message code="SearchCustomer.State" /></th>
										<th><spring:message code="SearchCustomer.ZipCode" /></th>
										<th><spring:message code="SearchCustomer.Action" /></th>
									</tr>
							</thead>
							<tbody>
							<c:forEach items="${customerList}" var="customer">
								<tr>
									<td>
										<spring:url var="viewCustomerLink" value="/web/ViewCustomer?customerNumber={number}"> 
											<spring:param name="number" value="${customer.number}" />						
										</spring:url>
										<a href="${viewCustomerLink}">
										${customer.number}
										</a>
									</td>

									<td>${customer.name}</td>
									<td>${customer.address}</td>
									<td>${customer.city}</td>
									<%-- <td>${customer.state.code}</td> --%>
<%-- 									<td>${customer.zip}</td> --%>
									<td>
										<spring:url var="editCustomerLink" value="/web/EditCustomer?customerNumber={number}"> 
											<spring:param name="number" value="${customer.number}" />						
										</spring:url>
										<a href="${editCustomerLink}"><span class="glyphicon glyphicon-edit" title="Modify Customer">dfdasf</span></a>
									</td>
								</tr>
							
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>	
</form:form>
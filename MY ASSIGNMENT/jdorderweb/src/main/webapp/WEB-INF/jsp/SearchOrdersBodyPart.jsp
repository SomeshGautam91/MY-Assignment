<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>				
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<form:form name="frm" method="post" modelAttribute="orderSearchForm">
	<input type="hidden" name="userAction" value="" >
				<div class="row"> <!-- Page Title Row -->
					<div class="text-center">
						<h1 class="pagesubheader"><spring:message code="SearchOrders.pageSubHeader" /></h1>
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
									<form:input path="customerNumber" type="text" class="form-control input-lg" id="customerNumber"
										placeholder="Enter Customer Number"/>
										<span
										class="input-group-btn serachButtonGroup">
										<button type="button" class="btn btn-success input-lg"
											onclick="search()">
											<span class="glyphicon glyphicon-search"></span>
										</button>
										<button type="button" class="btn btn-primary input-lg"
											onclick="resetForm()"><span class="glyphicon glyphicon-remove"></span></button>
									</span>
								</div>
							</div>
						</form>	
					</div>
				</div>	
	<c:if test="${!empty orderList}">
		<!-- <div class="row col-md-8 col-md-offset-2"> -->
		<div class="row text-center pageinfo">
			<h3><spring:message code="SearchOrders.OrdersFor" />: <font color=blue>${customer.name}</font></h3>
		</div>
		<div class="row searchResult">
			<div class="col-xs-10 col-md-offset-1  table-responsive" >
				<table class="table table-bordered table-striped text-center" id="orderTable">
					<thead>
							<tr>
								<th><spring:message code="SearchOrders.ordernumber" /></th>
								<th><spring:message code="SearchOrders.duedate" /></th>
								<th><spring:message code="SearchOrders.orderstatus" /></th>
								<th><spring:message code="SearchOrders.description" /></th>
							</tr>
					</thead>
					<tbody>
					<c:forEach items="${orderList}" var="order">
						<tr>
							<td>
								<spring:url var="editOrderUrl" value="/web/EditOrder?orderNumber={number}" >
									<spring:param name="number" value="${order.orderNumber}" />
								</spring:url>
								<a href="${editOrderUrl}">
									${order.orderNumber}
								</a>
							</td>
							<td>${order.dueDate}</td>
							<td>
								<c:choose>
						          <c:when test="${order.orderStatus.description == 'Pending'}">
						            <c:set var="color" value="orange"/>
						          </c:when>
						          <c:when test="${order.orderStatus.description == 'Cancelled'}">
						            <c:set var="color" value="brown"/>
						          </c:when>
						          <c:when test="${order.orderStatus.description == 'Overdue'}">
						            <c:set var="color" value="red"/>
						          </c:when>
						          <c:otherwise>
						            <c:set var="color" value="green"/>
						          </c:otherwise>
						        </c:choose>
						         <font color=${color}><b>
	          							${order.orderStatus.description}
	        					</b></font>
							</td>
							<td>${order.description}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:if>
	
</form:form>
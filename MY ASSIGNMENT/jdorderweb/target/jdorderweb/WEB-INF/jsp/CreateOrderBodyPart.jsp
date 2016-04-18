<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>				

<div class="row"> <!-- Page Title Row -->
<div class="text-center pageTitle">
   <h1 class="pagesubheader"><spring:message code="CreateOrder.pageSubHeader" /></h1>
</div>
</div>	<!-- End of page title row -->
<div class="row">
	<jsp:include page="Flash.jsp" flush="true"/>
</div>
<div class="row dataRow">
<spring:url var="createOrderActionURL" value="/web/CreateOrder" />
<form:form class="form-horizontal col-md-8 col-md-offset-2 " name="frm" method="post" modelAttribute="orderForm" action="${createOrderActionURL}">
	<input type="hidden" name="userAction" value="">
	<!--<form:hidden path="customerNumber" /> -->
	<div class="row">	
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
<!-- 						<button type="button" class="btn btn-primary input-lg"
							onclick="resetForm()"><span class="glyphicon glyphicon-remove"></span></button> -->
					</span>
				</div>
			</div>
	</div>
	<c:if test="${customer != null}">
		<div class="row text-center pagedetails" style="margin-top: 20px;">
			<h3><spring:message code="CreateOrder.CreateOrderFor" />: <font color=blue>${customer.name}</font></h3>
		</div>
	
	<div id="row" class="formData" >	
    <div class="form-group">
        <label for="number" class="col-sm-4 control-label"><spring:message code="CreateOrder.ordernumber" /></label>
        <div class="col-sm-6">
            <form:input type="text" path = "" class="form-control" id="orderNumber" readonly="true" placeholder="(Auto-Generated)"></form:input>
        </div>
    </div>

    <div class="form-group">
        <label for="name" class="col-sm-4 control-label"><spring:message code="CreateOrder.description" /></label>
        <div class="col-sm-6">
            <form:input type="text" path="description" class="form-control" id="description" ></form:input>
            <form:errors path="description"  cssClass="error"></form:errors>
        </div>
    </div>
    
     <div class="form-group">
     	<label for="duedate" class="col-sm-4 control-label"><spring:message code="CreateOrder.duedate" /></label>
     	<div class="col-sm-6">
     	<form:input type="text" path="dueDate" class="form-control" id="datepicker"  ></form:input>
     	<form:errors path="dueDate" cssClass="error"></form:errors>
     		
     	</div>
     </div>
     
  	<div class="row"  >
			<div class="col-xs-10 col-md-offset-1  table-responsive" >
				<table class="table table-bordered table-striped text-center" >
					<thead>
						<tr>
							<th><spring:message code="CreateOrder.item" />#</th>
							<th><spring:message code="CreateOrder.description" /></th>
							<th><spring:message code="CreateOrder.unitprice" /></th>
							<th><spring:message code="CreateOrder.quantity" /></th>
							<th><spring:message code="CreateOrder.extendedprice" /></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!empty orderForm.lineItemFormList}">
	   						<c:forEach items="${orderForm.lineItemFormList}" var="lineItemForm" varStatus="status">
							   <tr>
								   <td>${lineItemForm.itemNumber}<form:hidden path="lineItemFormList[${status.index}].itemNumber" /></td>
								   <td>${lineItemForm.description}<form:hidden path="lineItemFormList[${status.index}].description" /></td>
								   <td>${lineItemForm.price}<form:hidden path="lineItemFormList[${status.index}].price" /></td>
								   <td>	<form:input  path="lineItemFormList[${status.index}].quantity" size="10" />	</td>
								   <td>${lineItemForm.extendedPrice}</td>
							   </tr>
							</c:forEach>    
						</c:if> 
					</tbody>		
  				</table>
  			</div>
  		</div>
  				
  
  

    <div class="form-group text-center" >
        <button type="button" class="btn btn-success" onclick="placeOrder()">
            <span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;<spring:message code="CreateOrder.placeorder" />
        </button>        
        &nbsp;&nbsp;
        <button type="button" class="btn btn-success" onclick="addLineItems()">
            <span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;<spring:message code="CreateOrder.addlineitems" />
        </button>
        &nbsp;&nbsp;        
        <button type="button" class="btn btn-primary" onclick="cancelOrder()"> 
            <span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;<spring:message code="CreateOrder.discardChanges" />
        </button>
    </div>
    </div>
    </c:if>
</form:form>
</div>
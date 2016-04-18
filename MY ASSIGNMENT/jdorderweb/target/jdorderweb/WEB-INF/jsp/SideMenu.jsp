<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:url var="createCustomerUrl" value="/web/CreateCustomer" />
<spring:url var="searchCustomersUrl" value="/web/SearchCustomers" />
<spring:url var="createOrderUrl" value="/web/CreateOrder" />
<spring:url var="searchOrderUrl" value="/web/SearchOrders" />
<spring:url var="searchOrderUrlSecured" value="/web/SearchOrdersSecured" />
<spring:url var="searchCustomersJmsUrl" value="/web/SearchCustomersUsingJMS" />
<spring:url var="searchCustomersJmsUrlSecured" value="/web/SearchCustomersUsingJMSSecured" />
<spring:url var="createInventoryrUrl" value="/web/CreateInventory" />

			<div class="col-md-2 sidemenu hidden-sm hidden-xs"
				 id="submenu">
				<div id="customerMenu">
					<ul id="sidebar" class="nav nav-stacked navbarFont">
						<li><a href="${createCustomerUrl}"><spring:message code="SideMenu.createCustomer" /></a></li>
						<li id="search"><a href="${searchCustomersUrl}"><spring:message code="SideMenu.searchCustomer" /></a></li>
						<li><a href="${searchCustomersJmsUrl}"><spring:message code="SideMenu.searchCustomerUsingJMS" /></a></li>
				         	<sec:authorize access="hasRole('ROLE_SEARCH_CUSTOMER')">
							<li><a href="${searchCustomersJmsUrlSecured}"><spring:message code="SideMenu.securedSearchCustomerUsingJMS" /></a></li>
						</sec:authorize>
						
					</ul>
				</div>
				<div id="orderMenu" style="display: none">
					<ul id="sidebar"
						class="nav nav-stacked navbarFont hidden-sm hidden-xs hidden-md"
						style="margin-top: 45px">
						<li><a href="${createOrderUrl}"><spring:message code="SideMenu.createOrder" /></a></li>
						<li><a href="${searchOrderUrl}"><spring:message code="SideMenu.searchOrder" /></a></li>
			         		<sec:authorize access="hasRole('ROLE_SEARCH_ORDER')">
							<li><a href="${searchOrderUrlSecured}"><spring:message code="SideMenu.securedSearchOrder" /></a></li>
						</sec:authorize>
					</ul>
				</div>
				<div id="inventoryMenu" style="display: none">
					<ul id="sidebar"
						class="nav nav-stacked navbarFont hidden-sm hidden-xs hidden-md"
						style="margin-top: 45px">
						<li><a href="${createInventoryrUrl}"><spring:message code="SideMenu.createInventory" /></a></li>
					</ul>
				</div>
			</div>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url var="createCustomerUrl" value="/web/CreateCustomer" />
<spring:url var="searchCustomersUrl" value="/web/SearchCustomers" />
<spring:url var="createOrderUrl" value="/web/CreateOrder" />
<spring:url var="searchOrderUrl" value="/web/SearchOrders" />
<spring:url var="searchCustomersJmsUrl" value="/web/SearchCustomersUsingJMS" />
<spring:url var="executeAsyncTaskUrl" value="/web/ExecuteAsyncTask" />
<spring:url var="createInventoryUrl" value="/web/CreateInventory" />

	<div class="row">
		<div>
			<nav role="navigation" class="navbar navbar-default navbarFont">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" data-target="#navbarCollapse"
					data-toggle="collapse" class="navbar-toggle">
					<span class="sr-only"><spring:message code="TopNavbar.toggleNavigation" /></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<!-- Collection of nav links and other content for toggling -->
			<div id="navbarCollapse" class="collapse navbar-collapse">
				<ul class="nav navbar-nav" id="topnav">
					<li   id="customertopmenu"><a href="${searchCustomersUrl} "
						onclick="displayCustomerMenu()"
						class="hidden-sm hidden-xs hidden-md"><spring:message code="TopNavbar.customer" /></a></li>
					<li id="ordertopmenu"><a href="${searchOrderUrl}" onclick="displayOrderMenu()"
						class="hidden-sm hidden-xs hidden-md"><spring:message code="TopNavbar.order" /></a></li>
					<li id="inventorytopmenu"><a href="${createInventoryUrl}" onclick="displayInventoryMenu()"
						class="hidden-sm hidden-xs hidden-md"><spring:message code="TopNavbar.inventory" /></a></li>

					<li class="dropdown hidden-lg"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><spring:message code="TopNavbar.customer" /><b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="${createCustomerUrl}"><spring:message code="TopNavbar.createCustomer" /></a></li>
							<li><a href="${searchCustomersUrl}"><spring:message code="TopNavbar.searchCustomer" /></a></li>
							<li><a href="${searchCustomersJmsUrl}"><spring:message code="TopNavbar.searchCustomerUsingJMS" /></a></li>
						</ul></li>
					<li class="dropdown hidden-lg">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<spring:message code="TopNavbar.order" /><b	class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li><a href="${createOrderUrl}"><spring:message code="TopNavbar.createOrder" /></a></li>
							<li><a href="${searchOrderUrl}"><spring:message code="TopNavbar.searchOrder" /></a></li>
						</ul>
					</li>

					<li class="dropdown hidden-lg"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><spring:message code="TopNavbar.inventory" /> <b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="${createInventoryUrl}"><spring:message code="TopNavbar.createInventory" /></a></li>
						</ul></li>
				</ul>
			</div>
			</nav>
		</div>
	</div>
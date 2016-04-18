<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:if test="${not empty flashError}">
	<!-- <div class="error">  -->
			<spring:message code="${flashError}" /> 
	<!-- </div>  -->
</c:if>


<c:if test="${not empty flashInfo}">
	<!-- <div class="error">  -->
			<spring:message code="${flashInfo}" /> 
	<!-- </div>  -->
</c:if>

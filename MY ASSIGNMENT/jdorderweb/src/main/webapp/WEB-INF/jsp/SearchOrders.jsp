<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>
	<spring:message code="SearchOrders.title" /> 
</title>

<spring:url var="bootStrapcssUrl" value="/components/bootstrap/css/bootstrap.min.css" />
<link href="${bootStrapcssUrl}" rel="stylesheet" type="text/css">

<spring:url var="homepagecssUrl" value="/styles/main.css" />
<link href="${homepagecssUrl}" rel="stylesheet" type="text/css">

<spring:url var="jquerycssUrl" value="/components/data-tables/css/jquery.dataTables.min.css" />
<link href="${jquerycssUrl}" rel="stylesheet" type="text/css">

<spring:url var="jqueryUrl" value="/components/jquery/jquery-1.11.1.min.js" />
<script type="text/javascript" src="${jqueryUrl}"></script>

<spring:url var="jquerydatatableUrl" value="/components/data-tables/js/jquery.dataTables.min.js" />
<script type="text/javascript" src="${jquerydatatableUrl}"></script>

<spring:url var="bootstrapUrl" value="/components/bootstrap/js/bootstrap.min.js" />
<script type="text/javascript" src="${bootstrapUrl}"></script>

<spring:url var="sidemenuurl" value="/scripts/sidemenu.js" />
<script type="text/javascript" src="${sidemenuurl}"></script>
<script type="text/javascript">
			
	function search(){
    	$("input[name='userAction']").val("search");
		$("form").submit();
	}
	
	function resetForm(){
		$("#customerNumber").val("");
		$("input[name='userAction']").val("reset");
		$("form").submit();
	}
	
	$(document).ready(function() {
    	$("#submenu").height( $("#bodycontent").height() );
    	$('#customerTable').dataTable({
	    	"bPaginate": false		
	    });
	});
		
	$(document).ready(function () {
    	$('a[href="' + this.location.pathname + '"]').parent().addClass('activecolor');
		$("#ordertopmenu").addClass('active');
		$("#customerMenu").css("display", "none");
		$("#orderMenu").css("display", "block");
		$("#inventoryMenu").css("display", "none");

	});

	$(document).ready(function () {
		var jqueryht = $("#bodycontent").outerHeight();
		$("#submenu").outerHeight(jqueryht);
	});

</script>

</head>
<body>
	<div class="container">
		<jsp:include page="Header.jsp" flush="true"/>
		<jsp:include page="TopNavbar.jsp" flush="true"/>
		<div class="row"> <!-- side and body menu starts -->
			<jsp:include page="SideMenu.jsp" flush="true"/>
			
			<div class="col-md-10 bodypart" id ="bodycontent">
				<jsp:include page="SearchOrdersBodyPart.jsp" flush="true"/>
			</div>
		</div> <!-- side and body menu ends -->
		<jsp:include page="Footer.jsp" flush="true"/>
	</div>
</body>
</html>
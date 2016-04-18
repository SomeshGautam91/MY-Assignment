<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>
	<spring:message code="EditCustomer.title" /> 
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

<spring:url var="sampleappcssUrl" value="/styles/SampleApp.css" />
<link href="${sampleappcssUrl}" rel="stylesheet" type="text/css">

<spring:url var="ajaxURL" value="/web/GetStatesForCountry" />

<script type="text/javascript">

	$(document).ready(function() {
		$("#submenu").height( $("#bodycontent").height() );
	});

	function save(){
		$("input[name='userAction']").val("save");
		$("form").submit();
	}

	function cancel(){
		$("input[name='userAction']").val("cancel");
		$("form").submit();
	}

	  $(function(){
  		$("select#country").change(function(){
  			$.getJSON('${ajaxURL}',{country: $(this).val()}, function(data){
				var options = '';
  			    for(key in data){
  			    	var state = data[key];
  			    	options += '<option value ="'+ state.code +'">' + state.name + '</option>';
  			    }
				$("select#state").html(options);  		
  			})  
	  	})
	  });

		$(document).ready(function () {
	    	$('a[href="' + this.location.pathname + '"]').parent().addClass('activecolor');
			$("#customertopmenu").addClass('active');
			$("#customerMenu").css("display", "block");
			$("#orderMenu").css("display", "none");
			$("#inventoryMenu").css("display", "none");

		});

		$(document).ready(function () {
			var jqueryht = $("#bodycontent").outerHeight();
			$("#submenu").outerHeight(jqueryht);
		});	</script>

</head>
<body >
<div class="container">
	<jsp:include page="Header.jsp" flush="true"/>
	<jsp:include page="TopNavbar.jsp" flush="true"/>
	<div class="row" > <!-- side and body menu starts -->
	<jsp:include page="SideMenu.jsp" flush="true"/>	
		<div class="col-md-10 bodypart" id="bodycontent">
			<jsp:include page="EditCustomerBodyPart.jsp" flush="true"/>
		</div>
	</div> <!-- side and body menu ends -->
	<jsp:include page="Footer.jsp" flush="true"/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
body {
	font-family: tahoma;
	color: teal;
	font-size: 12px;
}

.holder {
	padding: 28px;
	margin: 8px;
	text-align: center;
	border: 1px solid #c6c6c6;
	text-align: center;
}

.linkHolder {
	padding: 8px;
	margin: 8px;
	text-align: center;
	border: 1px solid #c6c6c6;
	width: 29%;
	float: left;
	background-color: silver;
}

.linkHolder:hover {
	padding: 8px;
	margin: 8px;
	text-align: center;
	border: 1px solid #c6c6c6;
	width: 29%;
	float: left;
	background-color: navy;
}

.clear {
	clear: both;
}

ul li {
	display: inline-block;
}

h1 {
	padding: 8px;
	margin: 8px;
}

a {
	margin: 16px;
	text-decoration: none;
	color: white;
	font-weight: bold;
	display: block;
}

a:hover {
	margin: 16px;
	text-decoration: underline;
	color: white;
	font-weight: bold;
	display: block;
}

a.linkbtn, a.linkbtn:link, a.linkbtn:visited {
	font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif;
	display: inline-block;
	color: teal;
	background-color: yellow;
	font-size: 15px;
	text-align: center;
	padding: 5px 16px;
	text-decoration: none;
	margin-left: 0;
	margin-top: 0px;
	margin-bottom: 5px;
	border: 1px solid #8AC007;
	white-space: nowrap;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

a.linkbtn:hover, a.linkbtn:active {
	background-color: yellow;
	color: #8AC007;
}
</style>


<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script>
	$(document).ready(function() {

		$(".linkbtn").click(function() {
			if (this.id == "jQueryAjax") {
				$("#action").val("listUser");
				$("#frmRedirect").submit();
			}
		});
	});
</script>
</head>
<body>
	<h1>AJAX Call To The Server</h1>
	<div class="holder">
		<form id="frmRedirect" method="get" action="EmployeeController">
			<input type="hidden" id="action" name="action" value="" />
			<ul>
				<li><a href="#" id="jQueryAjax" class="linkbtn"> jQuery	Based AJAX Call </a></li>
			</ul>
		</form>
	</div>
</body>
</html>
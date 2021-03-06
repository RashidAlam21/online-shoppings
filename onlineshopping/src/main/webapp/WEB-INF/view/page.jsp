<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<!-- Bootstrap core CSS -->
<!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap Lus Theme -->
<link href="${css}/bootstrap-lux-theme.css" rel="stylesheet">
<!-- Font Awosome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- <link -->
	<link href="${css}/jquery.dataTables.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">


<%-- <link href="${css}/myapp.css" rel="stylesheet"> --%>
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<script type="text/javascript">
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
	//window.alert(menu);
</script>

</head>

<body>
	<div class="wrapper">
		<%--     ${contextRoot} Says ${greeting} --%>
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<div class="pcontent">
			<!-- Page Content -->
			<!-- loading the home content  -->
			<c:if test="${userClickedHome==true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- loading only when user clicks About  -->
			<c:if test="${userClickedAbout==true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- loading only when user clicks Contact  -->
			<c:if test="${userClickedContact==true }">
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- loading only when user clicks AllProducts  -->
			<c:if
				test="${userClickedAllProducts==true or userClickedCategoryProducts==true}">
				<%@include file="listproduct.jsp"%>
			</c:if>
			<!-- loading only when user clicks singleProduct  -->
			<c:if test="${userClickedShowProduct==true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			<!-- loading only when user clicks Manage Products  -->
			<c:if test="${userClickManageProduct==true }">
				<%@include file="manageProduct.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<!-- 	<script src="vendor/jquery/jquery.min.js"></script> -->
		<script src="${js}/jquery.js"></script>
		<!-- 	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
		<!-- Bootstrap core javascript -->
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- Data table pluggins -->
		<script src="${js}/jquery.dataTables.js"></script>
        <!-- Data table BootStrap script -->
<%-- 			    <script src="${js}/dataTables.bootstrap4.js"></script> --%>
        <!-- Bootbox -->
        <script src="${js}/bootbox.min.js"></script>
		
		<!-- JQuery-Validator -->
        <script src="${js}/jquery.validate.js"></script>
		
		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>
</html>
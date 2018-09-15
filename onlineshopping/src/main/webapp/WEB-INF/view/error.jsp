<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" errorPage="throwExceptionIfNoHandlerFound" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url var="css" value="/resources/css" />
<%-- <spring:url var="js" value="/resources/js" /> --%>
<%-- <spring:url var="images" value="/resources/images" /> --%>

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
<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<!-- <script type="text/javascript"> -->
<%-- 	window.menu = '${title}'; --%>

<%--  	window.contextRoot = '${contextRoot}' --%>
<!--  	window.alert(menu); -->
<!-- </script> -->

</head>

<body>
	<div class="wrapper">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		  <div class="container">
		   <div class="nav-header">
		     <a class="navbar-brand" class="home1" href="${contextRoot}/home">Online Shopping</a>
		   </div>
		  </div>
		 </nav>
		 <div class="content">
		  <div class="container">
		   <div class="row">
		    <div class="col-sm-12">
		     <div class="jumbotron">
		      <h1>${errorTitle}</h1>
		      <hr/>
		      <blockquote style="word-wrap:break-word;">
		       ${errorDescription}
		      </blockquote>
		     </div>
		    </div>
		   </div>
		  </div>
		 </div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<!-- 	<script src="vendor/jquery/jquery.min.js"></script> -->
<%-- 		<script src="${js}/jquery.js"></script> --%>
		<!-- 	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
		<!-- Bootstrap core javascript -->
<%-- 		<script src="${js}/bootstrap.bundle.min.js"></script> --%>
<%-- 		<script src="${js}/bootstrap.min.js"></script> --%>
		<!-- Data table pluggins -->
<%-- 		<script src="${js}/jquery.dataTables.js"></script> --%>

		<!-- Data table BootStrap script -->
		<%-- 	    <script src="${js}/dataTables.bootstrap.js"></script> --%>

		<!-- Self coded javascript -->
<%-- 		<script src="${js}/myapp.js"></script> --%>

	</div>
</body>
</html>
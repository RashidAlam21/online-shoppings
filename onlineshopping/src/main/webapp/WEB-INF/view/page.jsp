<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url  var="css" value="/resources/css"/>
<spring:url  var="js" value="/resources/js"/>
<spring:url  var="images" value="/resources/images"/>

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

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<script type="text/javascript">
 window.menu='${title}';
 //window.alert(menu);
</script>

</head>

<body>
  <div class="wrapper">
    <%--     ${contextRoot} Says ${greeting} --%>
	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp" %>
	<div class="pcontent">
	  <!-- Page Content -->
	<!-- loading the home content  -->
	<c:if test="${userClickedHome==true }">
      <%@include file="home.jsp" %>
    </c:if>
    
    <!-- loading only when user clicks About  -->
	<c:if test="${userClickedAbout==true }">
      <%@include file="about.jsp" %>
    </c:if>
    
    <!-- loading only when user clicks Contact  -->
	<c:if test="${userClickedContact==true }">
      <%@include file="contact.jsp" %>
    </c:if>
    <!-- loading only when user clicks AllProducts  -->
	<c:if test="${userClickedAllProducts==true or userClickedCategoryProducts==true}">
      <%@include file="listproduct.jsp" %>
    </c:if>
	</div>
	<!-- Footer -->
	<%@include file="./shared/footer.jsp" %>
	
	<!-- Bootstrap core JavaScript -->
    <!-- 	<script src="vendor/jquery/jquery.min.js"></script> -->
	<script src="${js}/jquery.js"></script>
<!-- 	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
       	<script src="${js}/bootstrap.bundle.min.js"></script>
	    <script src="${js}/bootstrap.min.js"></script>
	    <script src="${js}/myapp.js"></script>
    
  </div>
</body>
</html>
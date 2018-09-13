<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1" isELIgnored="false"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br/>
<h4 class="lead">Category Name</h4>
<div class="list-group">
    <c:forEach items="${categories}" var="category">
     <a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
    </c:forEach>
	
<!-- 	<a href="#" class="list-group-item">Category 2</a> -->
<!-- 	<a href="#" class="list-group-item">Category 3</a> -->
<!-- 	<a href="#" class="list-group-item">Category 4</a> -->
</div>
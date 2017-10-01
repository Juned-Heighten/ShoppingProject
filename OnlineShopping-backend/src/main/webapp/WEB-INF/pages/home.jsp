<!DOCTYPE html>
<html lang="en">
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>
<spring:url var="popper" value="/resources/popper"></spring:url>


<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping ${title} </title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bstraptheme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<%@ include file="./shared/myNavigationBar.jsp"%>

	<!-- Page Content -->
	<c:if test="${userClickHome eq true}">
	<%@include file="homes.jsp" %>
	<!-- /.container -->
   </c:if>
   
   <!-- Load only when user click on contact us -->
   <c:if test="${cnt eq true}">
	  <%@include file="contact.jsp" %>
	<!-- /.container -->
   </c:if>
   
   <c:if test="${abt eq true}">
	<%@include file="about.jsp" %> 
	
	<!-- /.container -->
   </c:if>
	<!-- Footer -->
	 <%@include file="./shared/footer.jsp" %>
	

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>
	<script src="${popper}/popper.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	
	

</body>
  
</html>

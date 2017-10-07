<!DOCTYPE html>
<html lang="en">
<%@ page isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>
<spring:url var="popper" value="/resources/popper"></spring:url>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
  <c:set var="cr" value="${pageContext.request.contextPath}"/>
<title>Online Shopping ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap Theme CSS -->
<link href="${css}/bstraptheme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">
<script>
window.menu=${title}
window.ctx='${cr}';

</script>

</head>

<body>
<div class="row">
<div class="col-xs-12">
	  <div class="jumbotron">
	  <h1>${errorTitle}</h1>
	  <hr/>
	  <blockquote style="word-wrap:break-word">
	  ${errorDesc}
	  
	  </blockquote>
	  
	     
		
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>


		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${popper}/popper.min.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		
		<script src="${js}/datatables.min.js"></script>
		<!-- Data Table Bootstrap script -->
		
		
		<script src="${js}/myApp.js"></script>
		
		
</div>
</div>
</div>	
</body>

</html>

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
<c:set var="cr" value="${pageContext.request.contextPath}" />
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
	<div class="wrapper">

		<!-- Navigation -->
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${cr}/home">Online Shopping</a>
	            </div>
			</div>
		</nav>

		<!-- Page Content -->
		<div class="content">
		
		<div class="container">
	<!--This Div Will be dispalyed if credentials are worong  -->	
		<c:if test="${not empty message}">
		<div class="row">

		<div class="col-md-offset-3 col-md-6">
		<div class="alert alert-danger">
		    ${message}
		</div>
		</div>
		</div>
		
		</c:if>
		
		
		<!--This Div Will be dispalyed if User has logged out  -->	
		<c:if test="${not empty logout}">
		<div class="row">

		<div class="col-md-offset-3 col-md-6">
		<div class="alert alert-success">
		    ${logout}
		</div>
		</div>
		</div>
		
		</c:if>

			<div class="row">

				<div class="col-md-offset-3 col-md-6">

					<div class="panel panel-primary">

						<div class="panel-heading">
							<h4>Login</h4>
						</div>

						<div class="panel-body">
							<form action="${cr}/login" method="POST" class="form-horizontal"
								id="loginForm">
								<div class="form-group">
									<label for="username" class="col-md-4 control-label">Email:
									</label>
									<div class="col-md-8">
										<input type="text" name="username" id="username"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-md-4 control-label">Password:
									</label>
									<div class="col-md-8">
										<input type="password" name="password" id="password"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										 <input type="submit" value="Login"
											class="btn btn-primary" />
											
											<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</div>
								</div>
							</form>

						</div>
						</div>
						</div>
						</div>
						</div>
						</div>
						
						<!-- Footer -->
						<%--  <%@include file="./shared/footer.jsp"%>--%>


						<!-- Bootstrap core JavaScript -->
						<script src="${js}/jquery.min.js"></script>
						<script src="${js}/jquery.validate.min.js"></script>
						<script src="${popper}/popper.min.js"></script>
						<script src="${js}/bootstrap.min.js"></script>




						<script src="${js}/myApp.js"></script>

</div>
</body>
</html>

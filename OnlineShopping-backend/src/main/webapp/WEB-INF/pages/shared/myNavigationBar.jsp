
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Online Shopping</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/show/all/products">View Products</a>
					</li>
					
					<security:authorize access="hasAuthority('ADMIN')">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/manage/products">Manage Product</a>
					</li>
					</security:authorize>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
				<li id="register">
				<a href="${pageContext.request.contextPath}/register">Sign Up</a>
				</li>
				<li id="login">
				<a href="${pageContext.request.contextPath}/login">Login</a>
				</li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
				<li class="dropdown">
				   
				   <a href="javascript:void(0)"
				     class="btn btn-default dropdown-toggle"
				     id="dropdownmenu1"
				     data-toggle="dropdown">
				     ${userModel.fullName}
				     
				     <span class="caret"></span>
				     </a>
				     <ul class="dropdown-menu">
				     <security:authorize access="hasAuthority('USER')">
				     <li>
				     <a href="${pageContext.request.contextPath}/cart">
				     <span class="glyphicon glyphicon-shopping-cart"></span>
				     <span class="badge">${userModel.cart.cartLine}</span>
				     -&#8377;${userModel.cart.grandTotal}
				     </a>
				     </li>
				     
				     <li class="divider" role="separator">
				     </li>
				     </security:authorize>
				     <li>
				       <a href="${pageContext.request.contextPath}/perform-logout">Logout</a>
				     </li>
				     </ul>
		             
				</li>
				</security:authorize>
				</ul>
			</div>
		</div>
	</nav>


<script>
	
	window.userRole='${userModel.role}';
	
	</script>
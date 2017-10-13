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
					
					
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/manage/products">Manage Product</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li id="register">
				<a href="${pageContext.request.contextPath}/register">Sign Up</a>
				</li>
				<li id="login">
				<a href="${pageContext.request.contextPath}/login">Login</a>
				</li>
				
				</ul>
			</div>
		</div>
	</nav>
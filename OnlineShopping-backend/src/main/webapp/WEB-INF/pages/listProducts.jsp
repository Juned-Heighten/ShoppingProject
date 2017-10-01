<div class="container">

	<div class="row">

		<!-- First column Would be display sidebar -->

		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>


		</div>

		<!-- To dispaly the actual products -->

		<div class="col-md-9">

			<!-- Adding Breadcrumb Component -->
			<div class="row">

				<div class="col-lg-12">
				<c:if test="${sap}">
					<ol class="breadcrumb">

						<li><a href="${pageContext.request.contextPath}/home">Home</a>
						<li>All Products</li>




					</ol>

</c:if>


<c:if test="${scp}">
					<ol class="breadcrumb">

						<li><a href="${pageContext.request.contextPath}/home">Home</a>
						<li>Category</li>
						<li>${c.name}</li>




					</ol>

</c:if>
				</div>

			</div>

		</div>

	</div>



</div>
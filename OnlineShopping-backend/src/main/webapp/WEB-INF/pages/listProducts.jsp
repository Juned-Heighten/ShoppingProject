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
					<c:if test="${sap==true}">
					<script>
					window.categoryId='';
					</script>
						<ol class="breadcrumb">

							<li><a href="${pageContext.request.contextPath}/home">Home</a>
							<li>All Products</li>
						</ol>

					</c:if>


					<c:if test="${scp==true}">
					<script>
					window.categoryId='${c.id}';
					</script>
						<ol class="breadcrumb">

							<li><a href="${pageContext.request.contextPath}/home">Home</a>
							<li>Category</li>
							<li>${c.name}</li>




						</ol>

					</c:if>
				</div>

			</div>
                 <div class="row">
                 
                 <div class="col-xs-12">
                 
                 <table id="listProducts" class="table table-striped table-borderd">
                 
                 <thead>
                   <tr>
                     <th></th>
                     <th>Name</th>
                     <th>Brand</th>
                     <th>Unit Price</th>
                     <th>Quantity</th>
                     <th>Purchases</th>
                     <th>Views</th>
                     <th>Links</th>
                     
                   </tr>
                </thead>
                 <tfoot>
                     <tr>
                     <th></th>
                     <th>Name</th>
                     <th>Brand</th>
                     <th>Unit Price</th>
                     <th>Quantity</th>
                     <th>Purchases</th>
                     <th>Views</th>
                     <th>Links</th>
                   </tr>
                 </tfoot>
                 
                 </table>
                 
                 </div>
                 
                 </div>
		</div>

	</div>



</div>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">




	<div class="row">
		<div class="col-md-offset-2 col-md-8">

			<div class="panel-primary">
				<div class="panel-heading">
					<h4>Product management</h4>

				</div>
				<div class="panel-body">

					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product">
						<div class="form-group">
							<label class="control-label col-md-4" for="name"> Enter
								Product name </label>
						<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="product name" class="form-control" /> <em
									class="help-block">Please Enter Product name</em>


						</div>


				        </div>
				        
				        
				        
				        <div class="form-group">
							<label class="control-label col-md-4" for="name"> Enter
								Product Brand </label>
						<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="product brand" class="form-control" /> <em
									class="help-block">Please Enter Product Brand</em>


						</div>


				        </div>
				        
				         <div class="form-group">
							<label class="control-label col-md-4" for="description"> Enter
								Description </label>
						<div class="col-md-8">
								<sf:textarea path="description" id="description"
									placeholder="product brand" class="form-control" rows="4" cols="50"/> 
									
									
									
									<em class="help-block">Please Enter Product Description</em>


						</div>


				        </div>
				        
				         <div class="form-group">
							<label class="control-label col-md-4" for="unitprice"> 
								 UnitPrice </label>
						<div class="col-md-8">
								<sf:input type="number" path="unitprice" id="unitprice"
									placeholder="product unitprice" class="form-control" /> <em
									class="help-block">Please Enter Product Unitprice</em>


						</div>


				        </div>
				        
				     <div class="form-group">
							<label class="control-label col-md-4" for="quantity"> 
								Quantity </label>
						<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="product quantity" class="form-control" /> <em
									class="help-block">Please Enter Product Quantity</em>


						</div>


				        </div>   
				        
				        <div class="form-group">
							<label class="control-label col-md-4" for="cateory"> 
								Select Category </label>
						<div class="col-md-8">
								<sf:select class="form-control" path="categoryId"
								 id="categoryId"
								 items="${categories}"
								 itemLabel="name"
								 itemValue="id"/>
								
								
								

						</div>


				        </div>    
				        
				        
				         <div class="form-group">
							
						<div class="col-md-offset-4 col-md-8">
								
								
								<input type="submit" value="submit" class="btn btn-primary"/>
								<sf:hidden path="id"/>
                                <sf:hidden path="supplierId"/>
                                <sf:hidden path="views"/>
                                <sf:hidden path="purchases"/>
                                <sf:hidden path="code"/>
                                <sf:hidden path="active"/>
                               
                                
                                
						</div>


				        </div>   
				         



					</sf:form>

				</div>
			</div>

		</div>

	</div>


</div>
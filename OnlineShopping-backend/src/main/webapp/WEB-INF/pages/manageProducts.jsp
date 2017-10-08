<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">




	<div class="row"> 
	
	<c:if test="${not empty message}">
	     <div class="col-xs-12">
	     <div class="alert alert-success alert-dismissible">
	     
	     <button type="button" class="close" data-dismiss="alert">
	     &times;</button>
	     ${message}
	     
	     </div>
	     
	     
	     </div>
	</c:if>
		<div class="col-md-offset-2 col-md-8">

			<div class="panel-primary">
				<div class="panel-heading">
					<h4>Product management</h4>

				</div>
				<div class="panel-body">

					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product" 
					action="${cr}/manage/products"
					 method="post"
					 enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name"> Enter
								Product name </label>
						<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="product name" class="form-control" /> 
									<sf:errors path="name"
									cssClass="help-block"
									element="em"/>
									


						</div>


				        </div>
				        
				        
				        
				        <div class="form-group">
							<label class="control-label col-md-4" for="name"> Enter
								Product Brand </label>
						<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="product brand" class="form-control" /> 
									<sf:errors path="brand"
									cssClass="help-block"
									element="em"/>


						</div>


				        </div>
				        
				         <div class="form-group">
							<label class="control-label col-md-4" for="description"> Enter
								Description </label>
						<div class="col-md-8">
								<sf:textarea path="description" id="description"
									placeholder="product brand" class="form-control" rows="4" cols="50"/> 
									
									
									
		                        <sf:errors path="description"
									cssClass="help-block"
									element="em"/>


						</div>


				        </div>
				        
				         <div class="form-group">
							<label class="control-label col-md-4" for="unitprice"> 
								 UnitPrice </label>
						<div class="col-md-8">
								<sf:input type="number" path="unitprice" id="unitprice"
									placeholder="product unitprice" class="form-control" /> 
									
									<sf:errors path="description"
									cssClass="help-block"
									element="em"/>
									


						</div>


				        </div>
				         
				     <div class="form-group">
							<label class="control-label col-md-4" for="quantity"> 
								Quantity </label>
						<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="product quantity" class="form-control" /> 
									


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
								 itemValue="id"
								 />
								
								
								

						</div>
  

				        </div>    
				        
				        <div class="form-group">
							<label class="control-label col-md-4" for="name"> Select
								Image </label>
						<div class="col-md-8">
								<sf:input type="file" path="file" id="file"
									placeholder="product name" class="form-control" /> 
									<sf:errors path="file"
									cssClass="help-block"
									element="em"/>
									
									


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
	<hr/>
	
             
             <div class="row">
             <div class="col-xs-12">
             
             <h1>Display Available Product</h1>
             <hr/>
             </div>
             
             
             <table id="adminProducttable" class="table table-striped table-borderd">
             <thead>
             <tr>
                 <th>ID</th>
                 <th>&#160;</th>
                 <th>Name</th>
                 <th>Brand</th>
                 <th>Quantity</th>
                 <th>Unit</th> 
                 <th>Activate</th>
                 <th>Edit</th>
              </tr>   
             </thead>
     
             <tfoot>
                <tr>  
                 <th>ID</th>
                 <th>&#160;</th>
                 <th>Name</th>
                 <th>Brand</th>
                 <th>Quantity</th>
                 <th>Unit</th> 
                 <th>Activate</th>
                 <th>Edit</th>
              </tr>
             </tfoot>
             </table>
             </div>
             
             </div>
   
</div>

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
									
									
             <c:if test="${product.id==0}">
             <br/>
             <div class="text-right">
             <button type="button"
             data-toggle="modal"
             data-target="#myCategoryModal"
             class="btn btn-warning ">Add Category</button>
             </div>
             </c:if>

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
                <div class="modal fade" id="myCategoryModal" 
                role="dialog" tabindex="-1">
                
                <div class="modal-dialog" role="document">
                <div class="modal-content">
                
                <div class="modal-header">
                
                <button type="button"
                 class="close"
                data-dismiss="modal">
                <span>&tiems;</span>
                
                </button>
                <h4 class="modal-title">Add new Category</h4>
                </div>
                <div class="modal-body">
                <!-- Category Form -->
                <sf:form id ="categoryForm" modelAttribute="category"
                action="${cr}/manage/category"
                method="post"
                class="form-horizontal">
                <div class="form-group">
                <label for="category_name" class="control-label col-md-4">Add Category Name</label>
                <div class="col-md-8">
                <sf:input type="text" path="name" name="category_name" id="category_name" class="form-control"/>
                </div>
                </div>
                
                <div class="form-group">
                <label for="category_descriptsion" class="control-label col-md-4">Add Description</label>
                <div class="col-md-8">
                <sf:textarea cols="" rows="4" path="descriptsion" class="form-control"/>
                </div>
                </div>
                
                
                <div class="form-group">
               <div class="col-md-offset-4 col-md-8">
               <input type="submit" value="Add Category" class="btn btn-primary"/>
                </div>
                </div>
                </sf:form>
                
                </div>
                </div>
                
                </div>
                
                </div>
             </div>
   

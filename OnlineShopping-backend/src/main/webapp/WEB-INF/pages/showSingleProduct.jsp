<div class="container">

<!-- BreadCrumb Component -->
<div class="row">

<div class="col-xs-12">
   <ol class="breadcrumb">
   <li>
      <a href="${pageContext.request.contextPath}/home">Home</a>
   </li>
   <li>${product.name}</li>
  </ol>
</div>
</div>  
<div class="row">

<!-- Display Product Image -->
<div class="col-xs-12 col-sm-4">

<div class="thumbnail">

<img src="${images}/${product.code}.jpg" class="img img-responsive"/>

</div>
</div>
<div clas="col-xs-12 col-sm-8">
<h3>${product.name}</h3>
<hr/>
<p>${product.description}</p>
<hr/>
<h4>Price:<strong>&#8377; ${product.unitprice}</strong></h4>
<h4>Quantity Available: ${product.quantity}</h4>

<a href="${pageContext.request.contextPath}/show/all/products" class="btn btn-primary">
<span class="glyphicon glyphicon-eye-open"></span>Back</a>
<a href="http://localhost:8888/OnlineShopping-backend/cart/add/${product.categoryId}/products" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add To cart</a>
</div>
</div>
</div>
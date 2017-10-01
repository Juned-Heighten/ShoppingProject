<div class="list-group">
<p:forEach items="${listCat}" var="category">

	<a href="${pageContext.request.contextPath}/show/category/${category.id}/products" class="list-group-item">${category.name}</a>
	
	
	
	</p:forEach>
	
	 
</div>
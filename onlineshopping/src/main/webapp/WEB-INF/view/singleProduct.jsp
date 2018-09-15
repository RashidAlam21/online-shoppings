<div class="container">
	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-sm-12">

			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item">${products.name}</li>
			</ol>
		</div>
	</div>

	<div class="row">
		<!-- Display the product image -->
		<div class="col-sm-12 col-md-4">
			<div class="thumbnail">
				<img src="${images}/${products.code}.jpg" class="img img-fluid">
			</div>
		</div>

		<!-- Display the product Description -->
		<div class="col-sm-12 col-md-8">
			<h3>${products.name}</h3>
			<hr />
			<!--  -->
			<p>${products.description}</p>
			<hr />
			<h4>
				Price : <strong>&#8377;${products.unitPrice}/-</strong>
			</h4>
			<hr />
			
			<c:choose>
			 <c:when test="${products.quantity<1}">
			  <h6>Qty.. Available :<span style="color:red;"> out of stock!</span></h6>
			 </c:when>
			 <c:otherwise>
			   <h6>Qty.. Available : ${products.quantity}</h6>  
			 </c:otherwise>
			</c:choose>
			
			<c:choose>
			 <c:when test="${products.quantity<1}">
			  <a href="javascript:void(0)"
				class="btn btn-success disabled">
				<strike><span class="fa fa-shopping-cart"> Add to Cart</span></strike></a>
			 </c:when>
			 <c:otherwise>
			   <a href="${contextRoot}/cart/add/${products.id}/product"
				class="btn btn-success"><span class="fa fa-shopping-cart"> Add to Cart</span></a>  
			 </c:otherwise>
			</c:choose>
			&#160; <a href="${contextRoot}/show/all/products"
				class="btn btn-primary"><span class="fa fa-backward"
				>  Back</span></a>
		</div>
	</div>



</div>
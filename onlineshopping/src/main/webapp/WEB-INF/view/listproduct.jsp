

<div class="container">
	<div class="row">
		<!--  would be display sidebar  -->
		<div class="col-md-3">
		
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		<!--  to display the actual products ...  -->
		<div class="col-md-9">
			<!-- Added breadcrumb component -->
			<div class="row">
				<div class="col-md-12">

					<c:if test="${userClickedAllProducts==true}">
					    <script>
					     window.categoryId='';
					    </script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li  class="breadcrumb-item">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickedCategoryProducts ==true}">
					    <script>
					     window.categoryId='${category.id}';
					    </script>
						<ol class="breadcrumb">
							<li  class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li  class="breadcrumb-item">Category</li>
							<li  class="breadcrumb-item">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
		    <div class="row">
		      <div class="col-md-12">
		         <table id="productListTable" class="table table-striped table-bordered">
		          <thead>
		           <tr>
		           <th></th>
		            <th>Name</th>
		            <th>Brand</th>
		            <th>price</th>
		            <th>Qty. Available</th>
		            <th></th>
		           </tr>
		          </thead>
		          <tfoot>
		           <tr>
		            <th></th>
		            <th>Name</th>
		            <th>Brand</th>
		            <th>price</th>
		            <th>Qty. Available</th>
		            <th></th>
		           </tr>
		          </tfoot>
		         </table>
		      </div>		     
		    </div>
		</div>
	</div>
</div>
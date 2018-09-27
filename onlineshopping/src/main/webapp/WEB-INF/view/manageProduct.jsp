<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<div class="container">
	<div class="row">
	  <c:if test="${not empty message}">
	   <div class="col-sm-12">
	    <div class="alert alert-success alert-dismissible">
         <button type="button" class="close" data-dismiss="alert">&times;</button>
         <strong>${message}</strong> 
	      
	    </div>
	   </div>
	  </c:if>
		<div class="offset-md-2 col-md-8">
			<div class="card card bg-primary text-white">
				<div class="card-header">
				    <h4>Product Management</h4>
				</div>
			</div>
			<div class="card card">
				<div class="card-body">
				   <!-- Body -->
				    <sf:form action="${contextRoot}/manage/products" class="form-stocked" modelAttribute="product" method="POST" enctype="multipart/form-data">
				     <div class="form-group row">
				          <label class="control-label col-md-4" for="name">Enter product Name :</label>
				         <div class="col-md-8">
				           <sf:input type="text" path="name" id="name" class="form-control" placeholder="Product Name"/>
<!-- 				           <em class="help-block"> -->
<!-- 				            Please Enter Product Name  -->
<!-- 				           </em> -->
                               <sf:errors path="name" cssClass="help-block" element="em"/>
				         </div>
				     </div>
				     <div class="form-group row">
				       <label class="control-label col-md-4" for="brand">Enter Brand Name :  </label>
				       <div class="col-md-8">
				         <sf:input type="text" path="brand" id="brand" class="form-control" placeholder="Brand Name"/>
<!-- 				          <em class="help-block"> -->
<!-- 				            Please Enter Brand Name  -->
<!-- 				          </em> -->
                          <sf:errors path="brand" cssClass="help-block" element="em"/>
				        </div>
				       </div>
				       <div class="form-group row">
				         <label class="control-label col-md-4" for="description">Product Description :  </label>
				         <div class="col-md-8">
				          <sf:textarea path="description" id="description" class="form-control" rows="4" placeholder="Write a desription"/>
<!-- 				           <em class="help-block"> -->
<!-- 				             Please Enter Some Description  -->
<!-- 				           </em> -->
                          <sf:errors path="description" cssClass="help-block" element="em"/>
				         </div>
				       </div>
				       <div class="form-group row">
				         <label class="control-label col-md-4" for="unitPrice">Unit Price :  </label>
				         <div class="col-md-8">
				           <sf:input type="number" path="unitPrice" id="unitPrice" class="form-control"  placeholder="unitPrice in &$8377; "/>
				           <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
				         </div>
				       </div>
				       <div class="form-group row">
				          <label class="control-label col-md-4" for="quantity">Quantity Available :  </label>
				          <div class="col-md-8">
				           <sf:input type="number" path="quantity" id="quantity" class="form-control"  placeholder="Quantity Available "/>
				           <sf:errors path="quantity" cssClass="help-block" element="em"/>
				          </div>
				        </div>
				        <!-- MultiPart File Upload -->
				        <div class="form-group row">
				          <label class="control-label col-md-4" for="file">Select an Image:  </label>
				          <div class="col-md-8">
				           <sf:input type="file" path="file" id="file" class="form-control"/>
				           <sf:errors path="file" cssClass="help-block" element="em"/>
				          </div>
				        </div>
				        <div class="form-group row">
				          <label class="control-label col-md-4" for="categoryId">Select Categorty :  </label>
				          <div class="col-md-8">
				           <sf:select type="number" path="categoryId" id="categoryId" class="form-control"
				              items="${categories}"
				              itemLabel="name"
				              itemValue="id"
				           />
				          </div>
				        </div>
				     <div class="form-group">
				      <div class="offset-md-4 col-md-8">
				         
				         <c:if test="${product.id==0}">
<%-- 				            Product Id :${product.id} --%>
				            <div class="text-right">
				             <br/>
				            <button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-sm">Add Category</button>
				            </div>
				           </c:if>
				        <input type="submit" value="submit" class="btn btn-primary">
				        <!-- Hidden Fields -->
				        <sf:hidden path="id"/>
				        <sf:hidden path="code"/>
				        <sf:hidden path="supplierId"/>
				        <sf:hidden path="active"/>
				        <sf:hidden path="purchases"/>
				        <sf:hidden path="views"/>
				      </div>
				     </div>
				    </sf:form>
				</div>
				
			</div>

		</div>
	</div>
    <!-- Listing of Admin product  -->
   <div class="row">
    <div class="col-md-12">
     <h3>Available Product</h3>
     <hr/>
    </div>
    <div class="col-md-12">
     <div style="overflow:auto">
      <table id="adminProductTable" class="table table-striped table-bordered">
       <thead>
        <tr>
         <th>Id</th>
         <th>&#160;</th>
         <th>Name</th>
         <th>Brand</th>
         <th>Quantity</th>
         <th>Unit Price</th>
         <th>Active</th>
         <th>Edit</th>
        </tr>
       </thead>
       
       <tfoot>
        <tr>
         <th>Id</th>
         <th>&#160;</th>
         <th>Name</th>
         <th>Brand</th>
         <th>Quantity</th>
         <th>Unit Price</th>
         <th>Active</th>
         <th>Edit</th>
        </tr>
       </tfoot>
      </table>
     </div>
    </div>
   </div>
   <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
    <div class="modal-dialog" role="document">
     <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header" >
       <h4 class="modal-title">Add new category</h4>
       <button type="button"  class="close" data-dismiss="modal">
        <span>&times;</span>
       </button>										
      </div>
      <div class="modal-body">
        <h3>Welcome to modal</h3>
       <!-- Modal Body -->
        <sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" 
        method="POST" class="form-stocked">
         <div class="form-group row">
           <label for="category_name" class="control-label  col-md-4">Category Name</label>
          <div class="col-md-8">
           <sf:input type="text" path="name" id="category_name" class="form-control"/>
          </div>
         </div>
         <div class="form-group row">
           <label for="category_description" class="control-label col-md-4">Category Description</label>
          <div class="col-md-8">
           <sf:textarea cols="10" rows="4" path="description" id="category_decription" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
		  <div class="offset-md-4 col-md-8">
		   <input type="submit" value="Add Category" class="btn btn-primary"> 
		  </div>
		 </div>
        </sf:form>
      </div>
     </div>
    </div>
   </div>
</div>
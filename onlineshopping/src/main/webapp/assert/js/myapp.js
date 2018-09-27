
$(function() {
	// solving the active menu problem.
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break; 
	case 'Home':
	$('#home').addClass('active');	    
	break;
	
	 default : $('#listProducts').addClass('active');
	 $('#a_'+menu).addClass('active'); break; 
	}

	
	
	
	
	//code for JQuery Datatable
	//create a dataset
//	var products=[
//		['1','iPhone'],
//		['2','RedMi'],
//		['3','Vivo'],
//		['4','Oppo'],
//		['5','Micromax'],
//		['6','Lenevo'],
//		['7','Geoni'],
//		['8','RedMi'],
//		['9','Samsung'],
//		['10','Nokia']
//		
//	];
	/**
	 * Why using $ here i am 
	 * indicating  using jquery
	 *  element which wrap
	 *   arround jquery.I
	 *   need to fetch that table. 
	 */
	var $table=$('#productListTable');
	//execute the below code only where we have this table.This table only available in view Products.
	if($table.length){
		//console.log('Inside the table!');
		var jsonUrl='';
	//	alert(window.contextRoot);
		if(window.categoryId==''){
			jsonUrl=window.contextRoot +'/json/data/all/products';
		}else{
			jsonUrl=window.contextRoot +'/json/data/category/'+window.categoryId+'/products';
		}
		//alert(jsonUrl);
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
			pageLength:5,
//			data:products
			ajax:{
				type: "GET",
				url : jsonUrl,
				dataSrc : '',
				 contentType : 'application/json; charset=utf-16'
			},
			columns: [
				{
					data: 'code',
					mRender: function(data,type,row){
						var img='';
						img=window.contextRoot+'/resources/images/'+data;
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="img-fluid adminDataTableImg"/>';
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data,type,row){
						return '&#8377 '+data
					}
				},
				{
					data: 'quantity',
					mRender:function(data,type,row){
						if(data<1){
							return '<span style="color:red">Out of stock!</span>';
						}
						return data;	
					}
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data,type,row){
						var str= '';
						str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="fa fa-eye"></span></a> &#160';
						if(row.quantity<1){
							str+='<a href="javascript:void(0)" class="btn btn-success disabled"><span class="fa fa-shopping-cart"></span></a>';
						}else{
							str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="fa fa-shopping-cart"></span></a>';
						}
						
						//str += '<a href="'+window.contextRoot+'/show/'data+'/product">View</a>'
						//str+= '<a href="'+window.contextRoot+'/cart/add/'data+'/product"> Add to Cart</a>'
						return str;
					}
				}

		  ]
				
			
			
		});
	}
	

//dismissing the alert after 3 seconds.
$alert=$('.alert');

if($alert.length){
	setTimeout(function(){
		$alert.fadeOut('slow')
	},3000)
}

//----------------------------------------------------------------



    //----------------------------------------------------------------------------------------------------------------
   //data tables for admin
  //----------------------------------------------------------------------------------------------------------------

/**
 * Why using $ here i am 
 * indicating  using jquery
 *  element which wrap
 *   arround jquery.I
 *   need to fetch that table. 
 */
var $adminProductsTable=$('#adminProductTable');
//execute the below code only where we have this table.This table only available in view Products.
if($adminProductsTable.length){
	//console.log('Inside the table!');
	var jsonUrl= window.contextRoot + '/json/data/admin/all/products';
  //	alert(window.contextRoot);
	
	//alert(jsonUrl);
	$adminProductsTable.DataTable({
		lengthMenu:[[5,10,30,50,-1],['5 Records','10 Records','30 Records','50 Records','All Records']],
		pageLength:10,
//		data:products
		ajax:{
			type: "GET",
			url : jsonUrl,
			dataSrc : '',
			 contentType : 'application/json; charset=utf-16'
		},
		columns: [
			{
				data : 'id',
			}
			,
			{
				data: 'code',
				mRender: function(data,type,row){
					var img='';
					img=window.contextRoot+'/resources/images/'+data;
					return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="img-fluid adminDataTableImg"/>';
				}
			},
			{
				data: 'name'
			},
			{
				data: 'brand'
			},
			{
				data: 'quantity',
				mRender:function(data,type,row){
					if(data<1){
						return '<span style="color:red">Out of stock!</span>';
					}
					return data;	
				}
			},
			{
				data: 'unitPrice',
				mRender: function(data,type,row){
					return '&#8377 '+data
				}
			},
			{
				data: 'active',
				bSortable:false,
				mRender: function(data,type,row){
					var str='';
					
					str +='<label class="switch">';
					if(data){
						str += '<input type="checkbox"  checked="checked" value="'+row.id+'">';
					}
					else{
						str += '<input type="checkbox"  value="'+row.id+'">';
					}
			        
			        str +='<div class="slider"></div></label>';
			        return str;  
				}				
			},
			{
				data: 'id',
				bSortable:false,
				mRender: function(data,type,row){
					var str='';
					str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
			        str += '<span class="fa fa-pencil"></span></a>';
			        return str;
				}
				
			}

	  ],
	  initComplete:function(){
		  
		  var api=this.api();
		  api.$('.switch input[type="checkbox"]').on('change',function(){
				//get checked box element
				var checkbox=$(this);
				/*checked for the value that the checkedbox have.
				 * prop is the function. 
				 * It will return he value of the checked.*/
				var checked=checkbox.prop('checked');
				//It checkbox is checked assign first string value in dMsg or 2nd value.
				var dMsg=(checked)? 'You want to activate the product?':
						             'You want to deactive the product';
				//tha value return the pid
				var value=checkbox.prop('value');
				
				bootbox.confirm({
					size: 'medium',
					title:'Product Activation or Deactivation',
					message:dMsg,
					callback:function(confirmed){
						if(confirmed){
							console.log(value);
							var activationURL = window.contextRoot +'/manage/product/'+value+'/activation';
							$.post(activationURL,function(data){
								bootbox.alert({
									size:'medium',
									title:'Information',
									message:data
								});
							})
						}else{
							checkbox.prop('checked',!checked);
						}
					}
				});
				
			})

	  }
			
		
		
	});
}

 //----------------------------------------------------------------------------------------------------------------
//Validate code for category

var $categoryForm=$('#categoryForm');

if($categoryForm.length){ 
	
	$categoryForm.validate({
		
		rules : {
			
			name : {
				required :true,
				minlength :2
			},
			
			description : {
				required :true
			}
		},
		messages : {
			
			name : {
				required : 'Please add the category name!',
				minlength : 'The category name should not be less than 2 characters .'
			},
	    	description : {
	    		required : 'Please add the description for the category!'
		    }
		},
		errorElement : 'em',
		errorPlacement : function(error,element){
			//add the class of help-block.
			error.addClass('help-block');
			//add the error element after the input.
			error.insertAfter(element)
		}
	});
}


//-------------------------------------



});

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
	 * Why using $ herei  am 
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
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
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
});













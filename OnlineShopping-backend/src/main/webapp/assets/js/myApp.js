
	
var $table=$('#listProducts');
//execute the below code only when we have this table
if($table.length)
	{   
	    var jsonurl = '';
	    if(window.categoryId == '')
	    	{
	    	jsonurl='http://localhost:8888/OnlineShopping-backend/products';
	    	   console.log("inside if")
	    	   console.log(window.categoryId)
	    	   
	    	}
	    else
	    	{
	    	jsonurl='http://localhost:8888/OnlineShopping-backend/category/'+ window.categoryId +''; 
	    	}
	    
	    $table.DataTable({
	    	
	    	lengthMenu: [[3,5,10,-1],['3 records','5 Records',
	    		'10 Records','All records']],
	    pageLength:5,	
	    

    	ajax: {
    		url: jsonurl,
    		dataSrc: ''
    	},
    	columns: [
    		{
    			data:'code',
    				"mRender": function(data,type,row)
    				{
    					return '<img src="http://localhost:8888/OnlineShopping-backend/resources/images/'+data+'.jpg" class="dataTableImg"/ >';
    				}
    		},
    		
    		{
    			data:'name'
    		},
    		{
    			data:'brand'
    		},
    		{
    			data:'unitprice',
    			"mRender": function(data,type,row){
    				return '&#8377; ' + data
    			}
    				
    		},
    		{
    			data:'quantity',
    				"mRender": function(data,type,row){
    					if(data < 1)
    	 					{
    						   return '<span style="color:red"> Out Of Stock </span>'
    						}
    					return data
    				}
    		},  
    		{
    			data:'purchases'
    		},
    		{
    			data:'views'
    		},
    		{
    			data:'id',
    			"mRender": function(data,type,row){
    					var str='';
    					str+='<a href="http://localhost:8888/OnlineShopping-backend/show/'+data+'/products" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">View</a> &#168;'
								    					if (window.userRole == 'ADMIN') {
									str += '<a href="http://localhost:8888/OnlineShopping-backend/manage/'
											+ data
											+ '/products" class="btn btn-warning"><span class="glyphicon glyphicon-pencil">Edit</a>'
								} else {
									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart">Add To cart</a>'
									} else {

										str += '<a href="http://localhost:8888/OnlineShopping-backend/cart/add/'
												+ data
												+ '/products" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add To cart</a>'

									}
								}
								return str;
    					
    				}
    		},
    	]
	    	
	    });
	}

var $alert=$('.alert');
if($alert.length)
	{
	  setTimeout(function(){  
		  $alert.fadeOut('slow');
	  },3000 )
	}
     





//Admin data Table

var $aProducttable=$('#adminProducttable');
//execute the below code only when we have this table
if($aProducttable.length)
	{    
	   
	    var jsonurl = 'http://localhost:8888/OnlineShopping-backend/admin/all/products';
            
	     console.log(jsonurl);
	    $aProducttable.DataTable({
	    	
	    	lengthMenu : [[10,20,30,-1],['10 records','20 Records',
	    		         '30 Records','All records']],
	        pageLength : 20,	
	    

  	ajax: {
  		url: jsonurl,
  		dataSrc: ''
  	},
  	columns: [
  		{
  			data: 'id'
  		},
  		{
  			data:'code',
  				"mRender": function(data,type,row)
  				{
  					return '<img src="http://localhost:8888/OnlineShopping-backend/resources/images/'+data+'.jpg" class="adminDataTableImg"/ >';
  				}
  		},
  		
  		{
  			data:'name'
  		},
  		{
  			data:'brand'
  		},  
  		
  		{
  			data:'quantity',
  				"mRender": function(data,type,row){
  					if(data < 1)
  	 					{
  						   return '<span style="color:red"> Out Of Stock </span>'
  						}
  					return data
  				}
  		}, 
  		
  		{
  			data:'unitprice',
  			"mRender": function(data,type,row){
  				return '&#8377; ' + data
  			}
  				
  		},
  		
  		{
  			data:'active',
  			bSortable: false,
  			"mRender": function(data,type,row)
  			{
  				var str='';
  				 str+='<label class="switch">';
  				 if(data)
  					 {
  				 str+='<input type="checkbox" checked="checked" value="'+row.id+'"><span class="slider round"></span>';
  					 }
  				 else{
  					 str+='<input type="checkbox" value="'+row.id+'"><span class="slider round"></span>'; 
  				 }
  				 
  				 return str;
  			}
  		},
  		{
  			data:'id',
  			bSortable: false,
  			"mRender": function(data,type,row)
  			{
  				var str='';
  				str+='<a href="http://localhost:8888/OnlineShopping-backend/manage/'+data+'/products" class="btn btn-warning">';
                        
                str+= '<span class="glyphicon glyphicon-pencil"></span></a>';
                return str;
                   
  			}
  			
  		},
  	],
  	initComplete: function () {
		var api = this.api();
		api.$('.switch input[type="checkbox"]').on('change' , function() {							
			var dText = (this.checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
			var checked = this.checked;
			var checkbox = $(this);
			debugger;
		    bootbox.confirm({
		    	size: 'medium',
		    	title: 'Product Activation/Deactivation',
		    	message: dText,
		    	callback: function (confirmed) {
			        if (confirmed) {
			        	var activateUrl='http://localhost:8888/OnlineShopping-backend/manage/products/'+checkbox.prop('value')+'/activation';
			        	$.post(activateUrl,function(data){
			        		 bootbox.alert({
                                 size:'medium',
                                 title:'Information',
                                 message:data 
});   
			        	})
			           
			        }
			        else {							        	
			        	checkbox.prop('checked', !checked);
			        }
		    	}
		    });																											
		});
			

}
	    	
	    });  
	}


var $categoryForm=$('#categoryForm');
if($categoryForm.length)
	{
	$categoryForm.validate({
		rules:{
			name:{
				required:true,
				minLength:2
			},
			descriptsion:{
				required:true
			}
		},
		messages:{
			name:{
				required:'Please Add the category name',
				minLength:'The category name should not be less than 2'
			},
			descriptsion:{
				required:'Please add a description'
			}
				
		},
		errorElenet:'em',
		errorplacement:function(error,element)
		{
			error.addClass('help-block');
			error.insertAfter(element);
		}

		
	})
	}


//-----------------------------
// Login Form Jquery Validation
//-----------------------------

var $loginForm=$('#loginForm');
if($loginForm.length)
	{
	   $loginForm.validate({
		   rules: {
			   username:{
				   required:true,
				   email:true
			   },
			   password:{
				   required:true
			   }
		   },
		   messages:{
			   
			   username:{
				   required:"Please Enter the user name",
		           email: "Please Enter valid email address"
			   },
			   password:{
				   required:"please enter the password"
			   }
			   
		   },
		   errorElement:"em",
		   errorPlacement : function(error,element){
			   error.addClass('help-block');
			   //add the error elemet after the input field
			   error.insertAfter(element);
		   }
	   });
	}
		
//for handling CSRF token
var token = $('meta[name="_csrf"]').attr('content');
var header = $('meta[name="_csrf_header"]').attr('content');

if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
	// set the token header for the ajax request
	$(document).ajaxSend(function(e, xhr, options) {			
		xhr.setRequestHeader(header,token);			
	});				
}

//Handling the Click Event of refereshCart button
$('button[name="refreshCart"]').click(function(){
	var cartLineId = $(this).attr('value');
	var countField = $('#count_' + cartLineId);
	var originalCount = countField.attr('value');
	// do the checking only the count has changed
	if(countField.val() !== originalCount) {	
		
	}
	console.log('hiiiiiiiiiiii');
});		
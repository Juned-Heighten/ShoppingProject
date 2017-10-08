
	
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
    					if(row.quantity < 1)
    						{
    						str+='<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart">Add To cart</a>'
    						}
    					else{
    						
    					str+='<a href="http://localhost:8888/OnlineShopping-backend/cart/add/'+data+'/products" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add To cart</a>'
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
     
$('.switch input[type="checkbox"]').on('change', function(){
	var checkbox=$(this);
	var checked=checkbox.prop('checked');
	var dMsg=(checked)? 'You want to activate the Product?':
		'You want to Deactivate the Product?';
	var value=checkbox.prop('value');
	bootbox.confirm({
		size:'medium',
		title:'Product Activation & Deactivation',
		message:dMsg,
		callback: function(confirmed){
			if(confirmed)
				{
				   console.log(value);
				   bootbox.alert({
					   size:"medium",
					   title:"Information",
					   message:"You are going to perform Operation on Product"+value
				   });
				}
			else
				{
				  checkbox.prop('checked',!checked);
				}
		}
	});
	
});






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
  				str+='<a href="http://localhost:8888/OnlineShopping-backend/manage/'+data+'/products"class="btn btn-warning">';
                        
                str+= '<span class="glyphicon glyphicon-pencil"></span></a>';
                return str;
                   
  			}
  			
  		},
  	],
	    	
	    });  
	}





		
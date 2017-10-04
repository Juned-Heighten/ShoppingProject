
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
    					return '<img src="http://localhost:8888/OnlineShopping-backend/resources/images/'+data+'.jpg"/ class="dataTableImg">';
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
    			data:'quantity'
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
    					str+='<a href="http://localhost:8888/OnlineShopping-backend/cart/add/'+data+'/products" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add To cart</a>'
    					return str;
    					
    				}
    		},
    	]
	    	
	    });
	}
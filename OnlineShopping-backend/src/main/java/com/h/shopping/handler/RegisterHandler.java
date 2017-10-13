package com.h.shopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.h.dao.UserDao;
import com.h.dto.Address;
import com.h.dto.Cart;
import com.h.dto.User;
import com.h.shopping.model.RegisterModel;

@Component
public class RegisterHandler {
	@Autowired
	private UserDao dao;

      public RegisterModel init()
      {
    	  return  new RegisterModel();
      }
      
      public void addUser(RegisterModel registerModel,User user)
      {
    	  registerModel.setUser(user);
      }
      
      public void addBilling(RegisterModel registerModel,Address billing)
      {
    	  registerModel.setBilling(billing);
      }
      
      public String saveAll(RegisterModel model)
      {
    	  String transitionValue="success";
    	  User user=null;
    	  Cart cart=null;
    	  Address billing=null;
    	  //Fetch The User 
    	 user= model.getUser();
    	 /**
    	  * if this is normal User Not a supplier
    	  * Create a Cart For this particular user
    	  */
    	  if(user.getRole().equals("USER"))
    	  {
    		 cart=new Cart();
    		 //set cart to user
    		 cart.setUser(user);
    		 user.setCart(cart);
    		 
    	  }
    	  
    	  //Save The User
    	  dao.addUser(user);
    	  
    	  //get The Address
    	  billing=model.getBilling();
    	  billing.setUser(user);
    	  billing.setBilling(true);
    	  //Save The Address
    	  dao.addAddress(billing);
    	  
    	  
    	  return transitionValue;
      }
      
      public String validateUser(User user,MessageContext error)
      { 
    	 String transitionValue="success";
    	 //Checking whether password is match or not
    	 if(!(user.getPassword().equals(user.getConfirmPassword())))
    			 {
    		         transitionValue="failure";
    		         error.addMessage(new MessageBuilder()
    		        		 .error()
    		        		 .source("confirmPassword")
    		        		 .defaultText("Password does not match")
    		        		 .build());
        	 
    			 }
    	 //Checking uniqueness of the Email
    	 if(dao.getByEmail(user.getEmail())!=null)
    	 {
    		 transitionValue="failure";
    		 error.addMessage(new MessageBuilder()
	        		 .error()
	        		 .source("email")
	        		 .defaultText("Email Already Exist")
	        		 .build());
    	 }
		return transitionValue;
    	  
      }
      
}

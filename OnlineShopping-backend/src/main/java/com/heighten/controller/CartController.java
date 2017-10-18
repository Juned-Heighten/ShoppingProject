package com.heighten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.heighten.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
       @RequestMapping("/show")
       public ModelAndView showCart()
       {
    	   ModelAndView mv=null;
    	   mv=new ModelAndView("home");
    	   mv.addObject("title", "User cart");
    	   mv.addObject("userClickShowCart", true);
    	   mv.addObject("cartLines",cartService.getCartLine());
    	   System.out.println("======="+cartService.getCartLine());
    	   return mv;
    	   
       }
       
}

package com.heighten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h.dto.CartLine;
import com.heighten.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
       @RequestMapping("/show")
       public ModelAndView showCart()
       {   
    	   List<CartLine> listCartline;
    	   ModelAndView mv=null;
    	   mv=new ModelAndView("home");
    	   mv.addObject("title", "User cart");
    	   mv.addObject("userClickShowCart", true);
    	   listCartline=cartService.getCartLine();
    	   mv.addObject("cartLines",listCartline);
    	   System.out.println("======="+listCartline.size());
    	     for(CartLine c:listCartline)
    	     {   
    	    	 System.out.println(c.getBuyingPrice());
    	    	 System.out.println(c.getCartId());
    	    	 System.out.println(c.getProductCount());
    	    	 System.out.println(c.getTotal());
    	    	 System.out.println(c.getProductCount());
    	    	 System.out.println(c.getProduct().getName());
    	    	 System.out.println(c.getProduct().getBrand());
    	    	 System.out.println(c.getProduct().getCode());
    	    	 System.out.println(c.getProduct().getDescription());
    	     }
    	 
    	   return mv;
    	   
       }
       
}

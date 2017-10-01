package com.heighten.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.h.dao.CategoryDao;
import com.h.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDao dao;
	
	@RequestMapping("/home")
	public String showPage(ModelMap m)
	{   
		m.addAttribute("greeting", "Welcome To Online Shopping Project");
		m.addAttribute("title","Home");
		m.addAttribute("userClickHome",true);
		List<Category> listCat=dao.list();
		m.addAttribute("listCat", listCat);
		System.out.println("Itemsssssssssss" +listCat);
		return "home";
	}
	
	
	@RequestMapping(value="/contact")
	public String contact(ModelMap m)
	{   System.out.println("Contact Method");
		m.addAttribute("title", "Contact Us");
		m.addAttribute("cnt",true);
		return "home";
	}
	
	
	@RequestMapping(value="/about")
	public String about(ModelMap m)
	{   System.out.println("About Us method"); 
		m.addAttribute("title", "About Us");
		m.addAttribute("abt",true);
		return "home";
	}
	@RequestMapping("/test")
	public String showGreeting(@RequestParam(value="key",required=false) String v,ModelMap m)
	{    
		if(v==null)
		{
			v= "Default Value";
		}
				m.addAttribute("MSG", v);
		 
		return "home";
	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView showPath(@PathVariable("greeting") String v)
	{
		ModelAndView mv=null;
		mv=new ModelAndView("home");  
		mv.addObject("MSG",v);
		//mv.setViewName("home");
		return mv;
	}
	
	/**
	 * Show All Products
	 */
	@RequestMapping("/show/all/products")
	public String showAllProducts(ModelMap m)
	{   
		m.addAttribute("llistCat", dao.list());
		m.addAttribute("title", "All Products");
		m.addAttribute("sap", true);
		return "home";
	}   
	
	/**
	 * Load Products on the basis of Category
	 */
	
	@RequestMapping("/show/category/{id}/products")
	public String showCategoryProduct(@PathVariable("id") int id,ModelMap m)
	{   Category c=null;
		c=dao.get(id);
		m.addAttribute("c", c);
		m.addAttribute("listCat", dao.list());
		m.addAttribute("title", c.getName());
		m.addAttribute("scp", true);
		return "home";
	}
	

}

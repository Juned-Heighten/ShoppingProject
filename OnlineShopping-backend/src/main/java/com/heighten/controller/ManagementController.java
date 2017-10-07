package com.heighten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h.dao.CategoryDao;
import com.h.dto.Category;
import com.h.dto.Product;

@Controller  
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDao cDao;

	
	@RequestMapping("/products")
	public ModelAndView showManageProduct()
	{
		ModelAndView mv=null;
		Product np=null;
		mv=new ModelAndView("home");
		np=new Product();
		mv.addObject("title", "Product management");
		mv.addObject("userClickManageProduct", true);
		np.setSupplierId(1);
		np.setActive(true);
		mv.addObject("product", np);
		return mv;
	}
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return cDao.list();
	}
	
	
}

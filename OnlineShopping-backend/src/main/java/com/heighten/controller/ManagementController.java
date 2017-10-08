package com.heighten.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.h.dao.CategoryDao;
import com.h.dao.ProductDao;
import com.h.dto.Category;
import com.h.dto.Product;
import com.heighten.util.FileUploadUtility;
import com.heighten.validator.ProductValidator;

@Controller  
@RequestMapping("/manage")
public class ManagementController {
	@Autowired 
	private CategoryDao cDao;
	@Autowired  
	private ProductDao pDao;
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);

	
	@RequestMapping("/products")
	public ModelAndView showManageProduct(@RequestParam(name="operation",required=false) String operation)
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
		if(operation!=null)
			if(operation.equals("product"))
			{
				mv.addObject("message", "product added successfully");
			}
		return mv;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleFormSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult result,ModelMap m,HttpServletRequest req) {
		logger.info(mProduct.toString());
		//add product to db
		new ProductValidator().validate(mProduct, result);
		if(result.hasErrors())
		{   
			m.addAttribute("title", "Product management");
			m.addAttribute("userClickManageProduct", true);
			m.addAttribute("message","Product submission Fail");
			return "home"; //Here we are not performing redirect bcoz error message wont be display
		}
		pDao.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			//whether it is having some file or not
			FileUploadUtility.upload(req,mProduct.getFile(),mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
		
		
	}
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return cDao.list();
	}
	
	
}

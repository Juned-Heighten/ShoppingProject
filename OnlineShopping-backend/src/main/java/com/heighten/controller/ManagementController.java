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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
			else if(operation.equals("category"))
			{
				mv.addObject("message", "Category added successfully");
			}
		return mv;
	}
	  
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleFormSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult result,ModelMap m,HttpServletRequest req) {
		logger.info(mProduct.toString());
		//add product to db
		if(mProduct.getId()==0) {
			// product is new then only validate image
		new ProductValidator().validate(mProduct, result);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				// if it is not equal to empty string
				//means new image also added
				//so we need to check the image extension(.jpeg,.jpg,.gif)
				new ProductValidator().validate(mProduct, result);
			}
		}
		if(result.hasErrors())
		{   
			m.addAttribute("title", "Product management");
			m.addAttribute("userClickManageProduct", true);
			m.addAttribute("message","Product submission Fail");
			return "home"; //Here we are not performing redirect bcoz error message wont be display
		}
		     if(mProduct.getId()==0) {
		    	 //create/add a new product if id is zero
		    	 pDao.add(mProduct);
		     }
		     else {
		    	 //update the product if id is not zero
		    	 pDao.update(mProduct);
		     }
		
		
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
	
	@RequestMapping(value="/products/{id}/activation",method
			=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id)
	{   
		Product p=pDao.get(id);
		boolean isActive=p.isActive();
		//update product with status
		p.setActive(!p.isActive());
		//save updated product in db
		pDao.update(p);
		return (isActive)? "Your Product is Deactivated with id "+p.getId():
			"your product is activate with id " +p.getId();
	}
	
	@RequestMapping(value="/{id}/products",
			method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id)
	{
		ModelAndView mv=null;
		Product p=null;
		mv=new ModelAndView("home");
		
		mv.addObject("title", "Product management");
		mv.addObject("userClickManageProduct", true);
		//fetch from db on the basis of ui
		p=pDao.get(id);
		//send to UI
		mv.addObject("product",p);
		
		return mv;
	}
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}
	
@RequestMapping(value="/category", method=RequestMethod.POST)
public String handleAddCategoryFormSubmit(@ModelAttribute Category category)
{   
	
	cDao.add(category);
	return "redirect:/manage/products?operation=category";
}
  
	
	
	
}

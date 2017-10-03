package com.heighten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h.dao.ProductDao;
import com.h.dto.Product;

@Controller
public class JsonDataController {
	@Autowired
	private ProductDao dao;
	
	@RequestMapping("/products")
	
	public @ResponseBody List<Product> getAllProducts()
	{
		return dao.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}")
	@ResponseBody
	public List<Product> getAllProductsById(@PathVariable int id)
	{
		return dao.listActiveProductByCategory(id);
	}
	

}

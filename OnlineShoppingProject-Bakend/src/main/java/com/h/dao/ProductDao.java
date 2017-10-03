package com.h.dao;

import java.util.List;

import com.h.dto.Product;

public interface ProductDao {
	public Product get(int pid);
	public List<Product> list();
	public boolean delete(Product p);
	public boolean update(Product p);
	public boolean add(Product p);
	
	//Business Method
	public List<Product> listActiveProducts();
	public List<Product> listActiveProductByCategory(int cid);
	public List<Product> getLatestActiveProducts(int count); 
	

}

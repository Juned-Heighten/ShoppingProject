package com.h.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.h.dao.ProductDao;
import com.h.dto.Product;

public class ProductTestCase {
	
	static AnnotationConfigApplicationContext ctx;
	static ProductDao dao;
	Product p;
	@BeforeClass
	public static void init()
	{
		ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com");
		ctx.refresh();
		dao=ctx.getBean(ProductDao.class);
	}
	
	/*@Test
	public void productCrudTest()
	{
		p=new Product();
		p.setActive(true);
		p.setBrand("Sony");
		p.setName("Mobile");
		p.setQuantity(5);
		p.setCategoryId(2);
		p.setSupplierId(2);
		p.setDescription("This is one of the best Mobile");
		p.setUnitprice(333333333);
		p.setViews(4);
		p.setPurchases(22);
		
		//test add functionality
		//assertEquals("Success",true,dao.add(p));
		//test update functionality
		
		//p=dao.get(1);
		//p.setName("Lemon");
		//assertEquals("Failure",true,dao.update(p));
		//p=dao.get(1);
		//test delete
		//assertEquals("Failure",true,dao.delete(p));
		//test list
		//assertEquals("Failure",4,dao.list().size());
		
	}
	
	*/
	
	@Test
	public void testListActiveProduct() {
		assertEquals("Failure",3,dao.listActiveProducts().size());
	}
	
	@Test
	public void testListAtiveProductByCId()
	{
		assertEquals("Failure",0,dao.listActiveProductByCategory(1).size());
		assertEquals("Failure",3,dao.listActiveProductByCategory(2).size());
	}
	
	@Test
	public void getLatestActiveProduct()
	{
		assertEquals("Failure",3,dao.getLatestActiveProducts(5).size());
	}

}

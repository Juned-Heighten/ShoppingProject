package com.h.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.support.DaoSupport;

import com.h.dao.CategoryDao;
import com.h.daoimpl.CategoryDaoImpl;
import com.h.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext ctx;
	private static CategoryDao dao;
	private Category cat;
	@BeforeClass
	public static void init()
	{
		ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com");
		ctx.refresh();
		dao=(CategoryDao)ctx.getBean("catDao");
	}
	
	@Test
	public void testAddCategory()
	{
		cat=new Category();
		cat.setName("TV");
		cat.setImageUrl("Image url");
		cat.setDescriptsion("This is a sony TV");
		
		assertEquals("Success",true,dao.add(cat));
	}

}  

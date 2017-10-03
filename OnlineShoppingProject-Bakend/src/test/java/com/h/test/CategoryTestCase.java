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
	
/*	private static AnnotationConfigApplicationContext ctx;
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
	*/
/*	@Test
	public void testAddCategory()
	{
		cat=new Category();
		cat.setName("TV");
		cat.setImageUrl("Image url");
		cat.setDescriptsion("This is a sony TV");
		
		assertEquals("Success",true,dao.add(cat));
	}
*/
/*	@Test
	public void testGetCat()
	{   
		
		cat=dao.get(1);
		assertEquals("Success","TV",cat.getName());
	}
	*/

	/*@Test
	public void testUpdatetCat()
	{   
		
		cat=dao.get(2);
		cat.setName("Ice Cream");
		assertEquals("Success",true,dao.update(cat));
	}*/
	
	/*@Test
	public void testDeleteCat()
	
	{
		cat=dao.get(1);
		assertEquals("Success",true,dao.delete(cat));
	}*/
	
	/*@Test
	public void testListCat()
	{
		assertEquals("Success", 2,dao.list().size());
	}*/
	
	/*@Test
	public void testCrudAll()
	{   
		// ADD Category Test
		cat=new Category();
		cat.setName("Verna");
		cat.setImageUrl("Image url");
		cat.setDescriptsion("This is a sony TV");
		
		assertEquals("Success",true,dao.add(cat));
		
		//get Category Test
		cat=dao.get(1);
		assertEquals("Success","Vannila",cat.getName());
		
		//Update Cat Test
		cat=dao.get(2);
		cat.setName("Chicken");
		assertEquals("Success",true,dao.update(cat));
		
		//Delete Test
		
		cat=dao.get(3);
		assertEquals("Success",true,dao.delete(cat));
		
		assertEquals("Success", 4,dao.list().size());
	}*/
}  

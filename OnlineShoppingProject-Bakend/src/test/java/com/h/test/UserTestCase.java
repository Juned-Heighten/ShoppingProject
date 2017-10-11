package com.h.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.h.dao.UserDao;
import com.h.dto.Address;
import com.h.dto.Cart;
import com.h.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext ctx;
	private static UserDao dao;
	private User u;
	private Address a;
	private Cart c;
	@BeforeClass
	public static void init()
	{
		ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com");
		ctx.refresh();
		dao=ctx.getBean(UserDao.class);
	}
/*	@Test
	public void addTest()
	{
		u=new User();
		u.setContactNumber("123455");
		u.setEmail("A@gmail.com");
		u.setFirstName("Uves");
		u.setLastName("Ahmad");
		u.setPassword("12345");
		u.setRole("USER");
		assertEquals("Failed",true,dao.addUser(u));
		//Add the Billing address to the User
		a=new Address();
		a.setAddressLineOne("Gadan");
		a.setAddressLineTwo("Gadan");
		a.setBilling(true);
		a.setCity("Saharanpur");
		a.setCountry("India");
		a.setPostalCode("12345");
		a.setShipping(false);
		a.setState("UP");
		//linked address to  the user
		a.setUserId(u.getId());
		
		assertEquals("Failed To Add Billing Address",true,dao.addAddress(a));
		if(u.getRole().equals("USER"))
		{
			//create a cart for this user
			c=new Cart();
			//link to the user
			c.setUser(u);
		
			
			
			assertEquals("Failed To Add Cart",true,dao.addCart(c));
			//add shipping addreess
			a=new Address();
			a.setAddressLineOne("Gadan");
			a.setAddressLineTwo("Gadan");
			a.setBilling(false);
			a.setCity("Saharanpur");
			a.setCountry("India");
			a.setPostalCode("12345");
			a.setShipping(true);
			a.setState("UP");
			//linked address to  the user
			a.setUserId(u.getId());
			assertEquals("Failed To Add Shipping Address",true,dao.addAddress(a));
			
			
		}
		
		
		
	}*/
	
/*	@Test
	public void testAdd()
	{
		u=new User();
		u.setContactNumber("123455");
		u.setEmail("A@gmail.com");
		u.setFirstName("Uves");
		u.setLastName("Ahmad");
		u.setPassword("12345");
		u.setRole("USER");
		if(u.getRole().equals("USER"))
		{
			// create a cart for this user
			c=new Cart();
			c.setUser(u);
			//attach cart with the user
			u.setCart(c);
		}
		assertEquals("Failed To Add Shipping Address",true,dao.addUser(u));
		
		}*/
	
	/*@Test
	public void testCartUpdate()
	{
		//fetch the email by its email
		u=dao.getByEmail("A@gmail.com");
		//get the cart of the user
		c=u.getCart();
		c.setCartLine(2);
		c.setGrandTotal(44);
		assertEquals("FAIL", true,dao.updateCart(c));
	}*/
	
	
	  /* @Test
	   public void testAddAddresses()
	   {
		   //add an user
		   u=new User();
			u.setContactNumber("123455");
			u.setEmail("B@gmail.com");
			u.setFirstName("Juned");
			u.setLastName("Ahmad");
			u.setPassword("12345");
			u.setRole("USER");
			//create Billing address
		assertEquals("Failed ",true, dao.addUser(u));	
			a=new Address();
			a.setAddressLineOne("Gadan");
			a.setAddressLineTwo("Gadan");
			a.setBilling(true);
			a.setCity("Saharanpur");
			a.setCountry("India");
			a.setPostalCode("12345");
			a.setShipping(false);
			a.setState("UP");
			//attach the user to address
			a.setUser(u);
			assertEquals("Failed", true,dao.addAddress(a));
			//shipping address
			a=new Address();
			a.setAddressLineOne("Gadan");
			a.setAddressLineTwo("Gadan");
			a.setBilling(false);
			a.setCity("Saharanpur");
			a.setCountry("India");
			a.setPostalCode("12345");
			a.setShipping(true);
			a.setState("UP");
			//attach the user to the address
			a.setUser(u);
			assertEquals("Failed", true,dao.addAddress(a));
			
	   }*/
	
/*	@Test
	public void testAddADR()
	{
		u=dao.getByEmail("A@gmail.com");
		a=new Address();
		a.setAddressLineOne("Gadan");
		a.setAddressLineTwo("Maszid");
		a.setBilling(false);
		a.setCity("Chennai");
		a.setCountry("India");
		a.setPostalCode("12345");
		a.setShipping(true);
		a.setState("Tamil Nadu");
		//attach the user to the address
		a.setUser(u);
		assertEquals("Failed", true,dao.addAddress(a));
		
	}*/
	
	
	  @Test
	  public void testGetAddress()
	  {
		  u=dao.getByEmail("A@gmail.com");
		  assertEquals("Size is not Match",1,dao.getListOfShippingAddress(u).size());
		  
	  }
	}
	   



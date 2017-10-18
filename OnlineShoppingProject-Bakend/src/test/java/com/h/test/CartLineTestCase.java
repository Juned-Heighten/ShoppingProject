package com.h.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.h.dao.CartLineDao;
import com.h.dao.ProductDao;
import com.h.dao.UserDao;
import com.h.dto.Cart;
import com.h.dto.CartLine;
import com.h.dto.Product;
import com.h.dto.User;

public class CartLineTestCase {
	
	
	private static AnnotationConfigApplicationContext ctx;
	private static CartLineDao cartLineDao;
	private static UserDao userDao;
	private static ProductDao productDao;
	User user=null;
	Cart cart=null;
	Product product=null;
	CartLine cartLine=null;
	
	@BeforeClass
	public static void init()
	{
		ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com");
		ctx.refresh();
		cartLineDao=ctx.getBean(CartLineDao.class);
		userDao=ctx.getBean(UserDao.class);
		productDao=ctx.getBean(ProductDao.class);
				
		
	}
	@Test
	public void testAddNewCartLine() {
		
		//1. Fetch The User
		user=userDao.getByEmail("juned15@gmail.com");
		//2. Fetch The User Cart
		cart=user.getCart();
		//3.Fetch The Product
		product=productDao.get(1);
		//4. Create CartLine
		cartLine=new CartLine();
		cartLine.setBuyingPrice(product.getUnitprice());
		cartLine.setProductCount(product.getQuantity()+1);
		cartLine.setTotal(product.getUnitprice()*product.getQuantity());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		assertEquals("Failed to add in cartline",true,cartLineDao.add(cartLine));
		//5. Update The Cart
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLine(cart.getCartLine()+1);
		assertEquals("Failed to Update the cart",true,cartLineDao.updateCart(cart));
		
	}

}

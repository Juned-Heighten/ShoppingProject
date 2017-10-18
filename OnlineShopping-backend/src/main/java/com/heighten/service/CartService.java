package com.heighten.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h.dao.CartLineDao;
import com.h.dto.Cart;
import com.h.dto.CartLine;
import com.h.shopping.model.UserModel;

@Service
public class CartService {
	@Autowired
	private CartLineDao CartLineDao;
	@Autowired
	private HttpSession session;
	/**
	 * Fetch Cart of User Who has logged in
	 * @return
	 */
	private Cart getCart()
	{
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	/**
	 * Return The Entire Cartline of the particular user
	 * @return
	 */
	public List<CartLine> getCartLine()
	{    System.out.println("====getCartLine()=====");
		return CartLineDao.list(this.getCart().getId());
	}

}

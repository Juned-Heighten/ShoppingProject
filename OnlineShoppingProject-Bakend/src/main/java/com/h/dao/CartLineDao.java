package com.h.dao;

import java.util.List;

import com.h.dto.Cart;
import com.h.dto.CartLine;

public interface CartLineDao {
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	public List<CartLine> listAvailable(int cartd);
	public CartLine getByCartAbdProduct(int cartId,int productId);
	public boolean updateCart(Cart cart);
	

}

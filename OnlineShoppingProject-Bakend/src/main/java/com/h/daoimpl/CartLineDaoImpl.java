package com.h.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h.dao.CartLineDao;
import com.h.dto.Cart;
import com.h.dto.CartLine;

@Repository  
@Transactional
public class CartLineDaoImpl implements CartLineDao {
	private static final String GET_CARTLINE_BY_CARTID = "FROM CartLine WHERE cartId=:cartId";
	private static final String GET_AVAILABLE_CARTLIN_LIST = "FROM CartLine WHERE cartId=:cartId AND available=:available";
	private static final String GET_CARTLINE_BY_PRODUCTANDCARTID = "FROM CartLine WHERE cartId=:cartId AND product.id=:id";
	@Autowired
	private SessionFactory sf;  

	@Override
	public CartLine get(int id) {
		// TODO Auto-generated method stub
		try {
		return sf.getCurrentSession().get(CartLine.class,Integer.valueOf(id));
		}catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean add(CartLine cartLine) {
		System.out.println("======add()=======");
		// TODO Auto-generated method stub
		try {
			sf.getCurrentSession().save(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CartLine cartLine) {
		try {
			sf.getCurrentSession().delete(cartLine);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<CartLine> list(int cartId) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery(GET_CARTLINE_BY_CARTID, CartLine.class).setParameter("cartId", cartId)
				.getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {

		return sf.getCurrentSession().createQuery(GET_AVAILABLE_CARTLIN_LIST, CartLine.class)
				.setParameter("cartId", cartId).setParameter("available", true).getResultList();

	}

	@Override
	public CartLine getByCartAbdProduct(int cartId, int productId) {

		return sf.getCurrentSession().createQuery(GET_CARTLINE_BY_PRODUCTANDCARTID, CartLine.class)
				.setParameter("cartId", cartId).setParameter("id", productId).getSingleResult();
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {      System.out.println("======updateCart()=======");
			      sf.getCurrentSession().update(cart);
			      return true;
		} catch (Exception e) {
			return false;
		}
	}

}

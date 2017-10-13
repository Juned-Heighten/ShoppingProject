package com.h.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h.dao.UserDao;
import com.h.dto.Address;
import com.h.dto.Cart;
import com.h.dto.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	private static final String GET_USER_BY_EMAIL = "from User where email=:email";
	private static final String GET_BILLING_ADDRESS ="from Address where user=:user AND shipping= :isBilling";
	private static final String GET_SHIPPING_ADDRESS ="FROM Address WHERE user = :user AND shipping = :isShipping";
	@Autowired
	private SessionFactory sf;

	@Override
	public boolean addUser(User user) {
		try {
			System.out.println("addUser()-----");
			sf.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sf.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sf.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
        try
        {
		return sf.getCurrentSession().createQuery(GET_USER_BY_EMAIL, User.class).setParameter("email", email)
				.getSingleResult();
        }
        catch(Exception e)
        {
        	return null;
        }
	}

	@Override
	public Address getBillingAddress(User user) {

		return sf.getCurrentSession().createQuery(GET_BILLING_ADDRESS, Address.class).setParameter("user", user)
				.setParameter("isBilling", true).getSingleResult();
	}

	@Override
	public List<Address> getListOfShippingAddress(User user) {
		System.out.println("Inside  getListOfShippingAddress( ) ");
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery(GET_SHIPPING_ADDRESS, Address.class).setParameter("user", user)
				.setParameter("isShipping", true).getResultList();
	}

}

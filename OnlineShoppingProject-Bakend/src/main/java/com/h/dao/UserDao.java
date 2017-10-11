package com.h.dao;

import java.util.List;

import com.h.dto.Address;
import com.h.dto.Cart;
import com.h.dto.User;

public interface UserDao {
	//add user
	public boolean addUser(User user);
	//add address
	public boolean addAddress(Address address);
	//add cart
	public boolean updateCart(Cart cart);
	//get user by email
	public User getByEmail(String email);
	//public Address getBillingAddress(int userId);
	//public List<Address> getListOfShippingAddress(int userId);
	//alternative
	public Address getBillingAddress(User user);
	public List<Address> getListOfShippingAddress(User user);
	

}

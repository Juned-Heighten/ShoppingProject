package com.h.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="uid")
	private User user;
	@Column(name="cart_lines")
	private int cartLine;
	@Column(name="grand_total")
	private double grandTotal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCartLine() {
		return cartLine;
	}
	public void setCartLine(int cartLine) {
		this.cartLine = cartLine;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", cartLine=" + cartLine + ", grandTotal=" + grandTotal + "]";
	}
	
	
	

}

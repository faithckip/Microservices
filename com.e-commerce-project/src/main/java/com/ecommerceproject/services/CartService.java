package com.ecommerceproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.ecommerceproject.dao;
import com.ecommerceproject.models.Cart;
@Service
public class CartService {
	
	@Autowired
	private com.ecommerceproject.dao.cartDao cartDao;
	
	public Cart addCart(Cart cart) {
		
		return cartDao.addCart(cart);
	}
	//public Cart getCart(int id)
	//{
	//return cartDao.getCart(id); }
	
	public List<Cart> getCarts(){
		
		return this.cartDao.getCarts();
	}
	
	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);
	}
	public void deleteCart(Cart cart) {
		
		cartDao.deleteCart(cart);
	}
}

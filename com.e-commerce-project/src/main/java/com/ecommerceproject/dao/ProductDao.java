package com.ecommerceproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerceproject.models.Product;

import jakarta.transaction.Transactional;
import jakarta.websocket.Session;

@Repository
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<Product> getProduct(){
		return this.sessionFactory.getCurrentSession().createQuery("from PRODUCT").list();
		
	}
	
	@Transactional
	public Product addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
		return product;
	}
	
	@Transactional
	public Product getProduct(int id) {
		
		return this.sessionFactory.getCurrentSession().get(Product.class, id);
	}
	
	public Product updateProduct(Product product) {
		this.sessionFactory.getCurrentSession().update(String.valueOf(Product.class), product);
		
		return product;
	}
	
	@Transactional
	public Boolean deleteProduct(int id) {
		
		org.hibernate.Session session = this.sessionFactory.getCurrentSession();
		Object persistanceInstance = session.load(Product.class, id);
		
		if(persistanceInstance != null) {
			((org.hibernate.Session) session).delete(persistanceInstance);
			return true;
		}
		return false;
	}

}

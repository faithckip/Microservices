package com.ecommerceproject.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity(name ="CART")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User customer;
	
	@ManyToMany
	@JoinTable(
			joinColumns = @JoinColumn(name = "cart_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Cart(int id, User customer, List<Product> products) {
		
		this.id = id;
		this.customer = customer;
		this.products = products;
	}

	public Cart() {
		super();
	}
	

}

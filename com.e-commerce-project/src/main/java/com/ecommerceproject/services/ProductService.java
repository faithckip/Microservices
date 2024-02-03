package com.ecommerceproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceproject.dao.ProductDao;
import com.ecommerceproject.models.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProducts(){
		return this.productDao.getProduct();
	}
	
	public Product addProduct(Product product) {
		return this.productDao.addProduct(product);
	}
	
	public Product getProduct(int id) {
		return this.productDao.getProduct(id);
		
	}
	
	public Product updateProduct(int id, Product product) {
		product.setId(id);
		return this.productDao.updateProduct(product);
	}
	
	public boolean deleteProduct(int id) {
		return this.productDao.deleteProduct(id);
	}
}

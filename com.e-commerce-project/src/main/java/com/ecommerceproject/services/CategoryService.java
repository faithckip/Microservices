package com.ecommerceproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceproject.dao.CategoryDao;
import com.ecommerceproject.models.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Category addCategory(String name) {
		
		return this.categoryDao.addCategory(name);
	}
	
	public List<Category> getCategories(){
		
		return this.categoryDao.getCategories();
	}
	
	public Boolean deleteCategory(int id) {
		return this.categoryDao.deleteCategory(id);
		
	}
	public Category updateCategory(int id, String name) {
		return this.categoryDao.updateCategory(id, name);
	}
	
	public Category getCategory(int id) {
		return this.categoryDao.getCategory(id);
		
	}
}

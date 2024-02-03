package com.ecommerceproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceproject.dao.UserDao;
import com.ecommerceproject.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> getUsers(){
		
		return this.userDao.getAllUser();
	}
	
	public User addUser(User user) {
		return this.userDao.saveUser(user);
	}
	
	public User checkLogin(String username, String password) {
		return this.userDao.getUser(username, password);
	}
}

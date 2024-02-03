package com.banking.onlineBanking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.onlineBanking.Entity.Users;
import com.banking.onlineBanking.Repository.UserRepository;

@Service
public class RegisterService {
	
	@Autowired
	UserRepository userRepository;
	
	public void registerUser(Users users) {
		
		userRepository.save(users);
	}

}

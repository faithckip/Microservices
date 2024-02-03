package com.banking.onlineBanking.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.banking.onlineBanking.Entity.Users;

@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void findByUsername() {
		
		Users user = userRepository.findByUsername("faithckiprono@gmail.com");
		
		System.out.println(user);
	}

}

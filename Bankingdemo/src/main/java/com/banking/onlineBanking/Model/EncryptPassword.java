package com.banking.onlineBanking.Model;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component

public class EncryptPassword extends BCryptPasswordEncoder{
	
	@Override
	@Bean
	public String encode(CharSequence rawPassword) {
		
		return super.encode(rawPassword);
	}
}

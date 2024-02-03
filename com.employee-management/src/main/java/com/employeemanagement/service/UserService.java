package com.employeemanagement.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.employeemanagement.dto.UserRegistrationDto;
import com.employeemanagement.model.*;

@Service
@FeignClient
public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);

}

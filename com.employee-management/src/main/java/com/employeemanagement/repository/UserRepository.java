package com.employeemanagement.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.model.User;

@Repository
@FeignClient
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}

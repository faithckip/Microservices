package com.banking.onlineBanking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.onlineBanking.Entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByUsername(String username);
}

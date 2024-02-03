package com.banking.onlineBanking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.onlineBanking.Entity.Withdrawal;



@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
	
	List<Withdrawal> findByUserId(String username);

}

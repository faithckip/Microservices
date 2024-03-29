package com.banking.onlineBanking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.onlineBanking.Entity.Transfer;
@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long>{
	
	List<Transfer>findByUserId(String username);

}

package com.banking.onlineBanking.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.onlineBanking.Entity.Account;
@SuppressWarnings("all")
@Repository

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	List<Account> findAllByUserId(String username);
	
	@Query(nativeQuery = true, value = "select account_balance from account where account_number =?1 and user_id =?2")
	Double findByAccount_NumberAndUser_Id(@Param("account_number") Long account_number, @Param("user_id") String user_id);
	
	@Query(nativeQuery = true, value="select * from account where account_number=?1 and user_id=?2")
	Account findByAccount(@Param("account_number") Long account_number, @Param("user_id") String user_id);
	
	@Query(nativeQuery = true, value = "select * from account where account_number = ?1")
	Account findByAccount_number(@Param("account_number") Long account_number);
	
	@Query(nativeQuery = true, value = "select account_balance from account where account_number = ?1")
	Double retrieveAccountBalance(@Param("account_number") Long account_number);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update account set account_balance =?1 where account_number =?2")
	void updateBalance(@Param("account_balance") Double amount, @Param("account_number") Long account_number, @Param("user_id") String user_id);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update account set account_balance =?1 where account_number =?2")
	void updateBalanceAfterPayment(@Param("account_balance") Double amount, @Param("account_number") Long account_number);
	
	

}

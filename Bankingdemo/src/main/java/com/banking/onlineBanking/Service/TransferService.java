package com.banking.onlineBanking.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.onlineBanking.Entity.Account;
import com.banking.onlineBanking.Entity.Users;
import com.banking.onlineBanking.Entity.Payment;
import com.banking.onlineBanking.Entity.Transfer;
import com.banking.onlineBanking.Repository.AccountRepository;
import com.banking.onlineBanking.Repository.TransferRepository;

@Service
public class TransferService {
	
	@Autowired
	TransferRepository transferRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	public String transfer(Long accountHolder, Long beneficiaryAccount, Double amount, Principal principal) {
		
		try {
			Account checkAccountHolder = accountRepository.findByAccount(accountHolder, principal.getName());
			Account checkBeneficiaryAccount = accountRepository.findByAccount_number(beneficiaryAccount);
			
			System.out.println("holder: "+ checkAccountHolder);
			System.out.println("bensfiii: "+ checkBeneficiaryAccount);
			
			if(checkAccountHolder != null && checkBeneficiaryAccount !=null) {
				Double accountHolderBalance = checkAccountHolder.getAccount_balance();
				Double beneficiaryAccountBalance = checkBeneficiaryAccount.getAccount_balance();
				
				if(accountHolderBalance == null) {
					
					accountHolderBalance = 0.0;
					
				}
			
			if (beneficiaryAccountBalance ==null) {
				
				beneficiaryAccountBalance = 0.0;
			}
			
			System.out.println("account balances holder" + accountHolderBalance);
			System.out.println("account balances beneficiary" + beneficiaryAccountBalance);
			
			if(accountHolderBalance >= amount) {
				
				accountHolderBalance = accountHolderBalance - amount;
				beneficiaryAccountBalance = beneficiaryAccountBalance + amount;
				
				accountRepository.updateBalanceAfterPayment(accountHolderBalance, accountHolder);
				accountRepository.updateBalanceAfterPayment(beneficiaryAccountBalance, beneficiaryAccount);
				
				//Transfer transfer = Transfer.builder()
						//.accountHolder(accountHolder)
						//.amount(amount)
						//.beneficiaryAccount(beneficiaryAccount)
						//.reference("Transfer")
						//.localDateTime(LocalDateTime.now())
						//.userId(principal.getName())
						//.build();
				//transferRepository.save(transfer);
				//return "transaction successful";
			}
			}
			return "transaction failed check your account balance or beneficiary does not exist";
			
		
			}catch(NumberFormatException exception) {
			
			return "Invalid account entered";
		}
	}
	public List<Transfer> transferhistory(Principal principal){
		
		return transferRepository.findByUserId(principal.getName());
	}

}

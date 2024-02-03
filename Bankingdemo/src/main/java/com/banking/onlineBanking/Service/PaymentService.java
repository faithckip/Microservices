//package com.banking.onlineBanking.Service;
//
//import java.security.Principal;
//import java.time.LocalDateTime;
//import java.util.List;
//import lombok.*;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.banking.onlineBanking.Entity.Account;
//import com.banking.onlineBanking.Entity.Payment;
//import com.banking.onlineBanking.Repository.AccountRepository;
//import com.banking.onlineBanking.Repository.PaymentRepository;
//
//@Builder
//@Service
//public class PaymentService {
//	
//	@Autowired
//	AccountRepository accountRepository;
//	
//	@Autowired
//	PaymentRepository paymentRepository;
//	
//	
//	//Builder builder;
//	
//	//public string payment
//	public String payment (Long accountHolder, Long beneficiaryAccount, Double amount, String reference, Principal principal)
//	{
//		
//		//checking if accountHolder, account number and Beneficiary account exists
//		
//		Account checkAccountHolder = accountRepository.findByAccount(accountHolder, principal.getName());
//		Account checkBeneficiaryAccount = accountRepository.findByAccount_number(beneficiaryAccount);
//		System.out.println("holder: "+ checkAccountHolder);
//		System.out.println("bensfiii: " + checkBeneficiaryAccount);
//		
//		if(checkAccountHolder != null && checkBeneficiaryAccount != null) {
//			
//			Double accountHolderBalance = checkAccountHolder.getAccount_balance();
//			Double beneficiaryAccountBalance = checkBeneficiaryAccount.getAccount_balance();
//			
//			if(accountHolderBalance == null) {
//				
//				accountHolderBalance = 0.0;
//			}
//			
//			if (beneficiaryAccountBalance == null) {
//				
//				beneficiaryAccountBalance = 0.0;
//			}
//			
//			System.out.println("account balances holder" + accountHolderBalance);
//			System.out.println("account balances beneficiary" + beneficiaryAccountBalance);
//			
//			if(accountHolderBalance >= amount) {
//				
//				accountHolderBalance = accountHolderBalance - amount;
//				beneficiaryAccountBalance = beneficiaryAccountBalance + amount;
//				
//				accountRepository.updateBalanceAfterPayment(accountHolderBalance, accountHolder);
//				accountRepository.updateBalanceAfterPayment(beneficiaryAccountBalance, beneficiaryAccount);
//				
//				Payment payment = Payment.builder()
//						.accountHolder(accountHolder)
//						.amount(amount)
//						.beneficiaryAccount(beneficiaryAccount)
//						.localDateTime(LocalDateTime.now())
//						.reference(reference)
//						.userId(principal.getName())
//						.build();
//				
//				paymentRepository.save(payment);
//				
//				return "transaction successful";
//					
//			}
//		}
//			return "transaction failed check your account balance or beneficiary does not exists";
//		}
//		public List<Payment>paymentHistory(Principal principal){
//			
//			return paymentRepository.findByUserId(principal.getName());
//		}
//}

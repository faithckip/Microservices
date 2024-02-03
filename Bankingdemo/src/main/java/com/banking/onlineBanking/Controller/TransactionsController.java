package com.banking.onlineBanking.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.banking.onlineBanking.Entity.Payment;
import com.banking.onlineBanking.Entity.Transfer;
import com.banking.onlineBanking.Entity.Withdrawal;
//import com.banking.onlineBanking.Service.PaymentService;
import com.banking.onlineBanking.Service.TransferService;
import com.banking.onlineBanking.Service.WithdrawalService;

@Controller
public class TransactionsController {
	
	@Autowired
	TransferService transferService;
	
	//@Autowired
	//PaymentService paymentService;
	
	@Autowired
	WithdrawalService withdrawalService;
	
	@GetMapping("/Display_stmt.html")
	public String transactions(Model model, Principal principal) {
		
		List<Withdrawal> withdrawalList = withdrawalService.withdrawalHistory(principal);
		List<Transfer> transferList = transferService.transferhistory(principal);
		
		//List<Payment> paymentList = paymentService.paymentHistory(principal);
		
		model.addAttribute("Withdrawals", withdrawalList);
		model.addAttribute("Transfers", transferList);
		//model.addAttribute("Payments", paymentList);
		
		return "Display_stmt.html";
	}
}
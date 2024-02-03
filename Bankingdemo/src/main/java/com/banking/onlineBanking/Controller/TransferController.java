package com.banking.onlineBanking.Controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banking.onlineBanking.Service.TransferService;

@Controller
public class TransferController {
	@Autowired
	TransferService transferService;
	
	@PostMapping("/transfer")
	@ResponseBody
	
	public String transfer(HttpServletRequest request, Principal principal)
	{
		try {
			
			Long accountHolder = Long.parseLong(request.getParameter("account_number"));
			Long beneficiaryAccount = Long.parseLong(request.getParameter("beneficiary_account"));
			Double amount = Double.parseDouble(request.getParameter("transfer_amount"));
			
			return transferService.transfer(accountHolder, beneficiaryAccount, amount, principal);	
		}
		catch(Exception exception) {
			
			return "Failed :( -> Number Format Exception ... please Enter a valid account Number";
		}
	}
}

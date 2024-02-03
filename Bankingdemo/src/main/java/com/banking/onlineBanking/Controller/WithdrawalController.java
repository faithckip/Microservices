package com.banking.onlineBanking.Controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banking.onlineBanking.Service.WithdrawalService;

@Controller
public class WithdrawalController {
	
	@Autowired
	WithdrawalService withdrawalService;
	
	@PostMapping("/withdraw")
	@ResponseBody
	public String withdraw(HttpServletRequest request, Principal principal) {
		
		try {
			Long accountHolder = Long.parseLong(request.getParameter("account_number"));
			Double amount = Double.parseDouble(request.getParameter("amount"));
			
			return withdrawalService.withdrawal(accountHolder, amount, principal);
		}
		catch(Exception exception) {
			
			return "Failed :(Invalid account or Amount ";
		}
	}

}

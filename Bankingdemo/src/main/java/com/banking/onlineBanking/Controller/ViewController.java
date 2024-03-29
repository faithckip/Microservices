package com.banking.onlineBanking.Controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banking.onlineBanking.Entity.Account;
import com.banking.onlineBanking.Service.AccountService;

@Controller
public class ViewController {
	@Autowired
	AccountService accountService;
	
	@GetMapping("/home")
	public String HomePage() {
		return "index.html";
	}
	@GetMapping("/login")
	public String LoginPage() {
		
		return "login_form.html";		
	}
	
	@GetMapping("/contact-us")
	public String ContactPage() {
		
		return "Contact_form.html";
	}
	@GetMapping("/register")
	public String RegisterPage() {
		
		return "register.html";		
	}
	
	@GetMapping("/error")
	public String ErrorPage() {
		
		return "error.html";
	}
	@GetMapping("/dashboard")
	public String Dashboard(Model model, Principal principal) {
		
		List<Account> accounts = accountService.findAccounts(principal.getName());
		for(Account account: accounts) {
			
			if(account.getAccount_balance() == null) {
				account.setAccount_balance(0.000);
			}
		}
		model.addAttribute("accounts", accounts);
		model.addAttribute("message", "hi user");
		
		if(accounts.isEmpty() == true) {
			model.addAttribute("no_account", true);
		}
			
			return "Dashboard.html";
		}
		@GetMapping("/canvas")
		public String Canvas() {
			
			return "offcanvas.html";
		}
		
		@GetMapping("/email")
		public String EmailPage() {
			
			return "email.html";
		}
		@GetMapping("/password-error")
		public String PasswordError() {
			
			return "templates/error.html";
		}
		
		@PostMapping("/add-account")
		@ResponseBody
		public String AddAccount(HttpServletRequest request, Principal principal) {
			
			String account_name = request.getParameter("account_name");
			String account_type = request.getParameter("account_type");
			
			if(principal.getName().isEmpty() == false) {
				
				//Account account = Account.builder().account_type(account_type).account_name(account_name).userId(principal.getName()).date_created(LocalDateTime.now()).build();
				//accountService.SaveAccount(account);
			}
			else
			{
				return "error.html";
			}
			return "success";
		}
		@PostMapping("/deposit")
		@ResponseBody
		public String deposit(HttpServletRequest request, Principal principal) {
			try {
				Long account_number = Long.parseLong(request.getParameter("account_number"));
				Double amount = Double.parseDouble(request.getParameter("amount"));
				
				String user_id = principal.getName();
				Account DoesAccountExist = accountService.doesAccountExists(account_number, user_id);
				
				if(DoesAccountExist != null) {
					
					Double account_balance = accountService.getAccountBalance(account_number, user_id);
					
					if(account_balance == null) {
						account_balance = 0.00;
					}
					Double total = account_balance + amount;
					accountService.update_balance(total, account_number, user_id, principal);
					
					return "sucess";
				}
				else {
					return "Failed ): 1 -> Invalid Account please check your account number 2-> Invalid Amount...";
				}
			} catch(NumberFormatException e) {
				return "Error Invalid Value entered";
			}
		}
}

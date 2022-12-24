package com.sobieraj.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.services.LoginServices;

@Controller
public class CreateAccountController {
	
	@Autowired
	LoginServices loginService;
	
	@RequestMapping("/createAccountPage")
	public String createAccount() {
			
		return "createAccountPage";
		
	}

	
	@RequestMapping("/createAccount")
	public String createAccount(BlogAccount account) {
		
		loginService.save(account);
		return "loginPage";
		
	}
	
}		

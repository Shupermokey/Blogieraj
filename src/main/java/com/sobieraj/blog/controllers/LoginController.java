package com.sobieraj.blog.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.services.LoginServices;
import com.sobieraj.blog.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	LoginServices loginService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String getLoginPage() {
		return "loginPage";
	}
	
	@RequestMapping("/homePage")
	public String getHomePage(BlogAccount account, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		boolean login = loginService.loginAccount(account);
		
		BlogAccount accountUser  = userService.findBlogAccountByUsername(account.getUsername());
		
		if(login) {
			session.setAttribute("user",account.getUsername()); //set the username
			session.setAttribute("posts",accountUser.getPosts()); // retreive all the posts
			return "homePage";
		}
		
		return "loginPage";
		
		
		
		
	}

}

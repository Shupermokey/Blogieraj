package com.sobieraj.blog.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.entities.Friends;
import com.sobieraj.blog.services.FriendService;
import com.sobieraj.blog.services.UserService;

@Controller
public class FriendController {

	
	@Autowired
	FriendService friendService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/searchFriend")
	public String searchFriends(HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<BlogAccount> allUsers = userService.findAll();
		
		session.setAttribute("users", allUsers);
		
		
		return "friendListPage";
	}
	
	
	@RequestMapping("/addFriend")
	public String addFriend(BlogAccount account, HttpServletRequest req) {
		HttpSession session = req.getSession();
		BlogAccount currentUser= userService.findBlogAccountByUsername((String)session.getAttribute("user"));
		
		boolean exists = friendService.addFriend(currentUser, account);
		List<Friends> allFriends = friendService.findByFirstUser(currentUser);
		
		session.setAttribute("allFriends", allFriends);
		
		return "friendListPage";
	}
	
}

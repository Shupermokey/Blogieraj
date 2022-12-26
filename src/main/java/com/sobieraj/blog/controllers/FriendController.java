package com.sobieraj.blog.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.entities.FriendRequest;
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
	public String searchFriends(HttpServletRequest req) { //send the httpservletrequest
		HttpSession session = req.getSession(); // get the session from the request
		List<BlogAccount> allUsers = userService.findAll(); //find all friends in the repo
		session.setAttribute("users", allUsers); //set all the users to a session called 'users'
		
		
		return "friendListPage";	//return the friendListPage
	}
	
	
	@RequestMapping("/addFriend")
	public String addFriend(BlogAccount account, HttpServletRequest req) { //blog account and servletrequest
		HttpSession session = req.getSession(); // get the session from the request
		BlogAccount currentUser= userService.findBlogAccountByUsername((String)session.getAttribute("user")); //get the current user value from the session and user it to find the BlogAccount object with that username
		
		boolean exists = friendService.addFriend(currentUser, account); //addFriend finds both BlogAccounts and tries to find a Friend object. If it doesn't, it creates one
		List<Friends> allFriends = friendService.findByFirstUser(currentUser); //finds all the Friend objects sent by the current/logged in user
		
		session.setAttribute("allFriends", allFriends);
		
		return "friendListPage";
	}
	
	@RequestMapping("/AcceptRejectFriend")
	public String addOrRejectFreind(String currentUserr, HttpServletRequest req) {
		HttpSession session = req.getSession();
		BlogAccount currentUser = userService.findBlogAccountByUsername(currentUserr);
		friendService.addOrRejectFreind(currentUser);
		
		
		return "friendListPage";
	}
	
}

package com.sobieraj.blog.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.entities.Post;
import com.sobieraj.blog.services.UserService;

@Controller
public class PostController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/makePost")
	public String makeAPost(Post post, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		userService.savePost(post); // make the post and save it in the repo
		String user = (String) session.getAttribute("user"); // get the current user
		BlogAccount accountUser  = userService.findBlogAccountByUsername(user);
		accountUser.getPosts().add(post); //add the post to the current user's post list
		userService.saveBlogAccount(accountUser);
		session.setAttribute("posts", accountUser.getPosts());
		return "homePage";
	}
	
	@RequestMapping("/deletePost") //send a post to this request
	public String deletePost(Post post, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(); // get the current session
		
		
		String user = (String) session.getAttribute("user"); //returnt he current user
		
		BlogAccount accountUser  = userService.findBlogAccountByUsername(user); //get the BlogAccount by username
		
		userService.deletePost(post, accountUser); //send the post to the service repo method
		
		
		session.setAttribute("posts", accountUser.getPosts()); //get the posts by this user and set it in the session 
		
		return "profilePage";
		
	}
	

	
}

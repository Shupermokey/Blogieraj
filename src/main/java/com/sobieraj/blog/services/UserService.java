package com.sobieraj.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.entities.Friends;
import com.sobieraj.blog.entities.Post;
import com.sobieraj.blog.repos.LoginRepo;
import com.sobieraj.blog.repos.PostRepo;

@Service
public class UserService {
	
	@Autowired
	LoginRepo repo;
	
	@Autowired
	PostRepo postRepo;
	
	public BlogAccount findBlogAccountByUsername(String username) {
		
		BlogAccount user = repo.findBlogAccountByUsername(username);
		
		return user;
		
	}
	
	public void savePost(Post post) {
		
		postRepo.save(post);
		
	}
	
	public void saveBlogAccount(BlogAccount blogAccount) {
		
		repo.save(blogAccount);
	}

	public void deletePost(Post post) {

		postRepo.delete(post);
			
		}
	
	public List<BlogAccount> findAll(){
		
		return repo.findAll();
		
	}
		

}

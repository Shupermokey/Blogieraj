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

	public void deletePost(Post post, BlogAccount blogAccount) {
		
		if(post != null) {
			BlogAccount account = repo.findBlogAccountByUsername(blogAccount.getUsername());
			List<Post> posts = account.getPosts();
			for(int i = 0; i < posts.size(); i++) {
				if(posts.get(i).stringPost.equals(post.getStringPost())) {
					posts.remove(i);
					repo.save(account);
				}
			}
			

		}
		}
	
	public List<BlogAccount> findAll(){
		
		return repo.findAll();
		
	}
		

}

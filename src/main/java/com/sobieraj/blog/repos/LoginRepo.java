package com.sobieraj.blog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sobieraj.blog.entities.BlogAccount;

@Repository
public interface LoginRepo extends JpaRepository<BlogAccount, Integer> {
	
	public BlogAccount findBlogAccountByUsername(String username);
	
	

}

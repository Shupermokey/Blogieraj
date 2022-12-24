package com.sobieraj.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.repos.LoginRepo;

@Service
public class LoginServices {
	
	@Autowired
	LoginRepo loginRepo;
	
	public boolean loginAccount(BlogAccount blogAccount) {
		
		if(blogAccount!=null) {
			BlogAccount blogLoginInfo = loginRepo.findBlogAccountByUsername(blogAccount.getUsername());
			if(blogLoginInfo!=null) {
				
				if(blogAccount.getPassword().equals(blogLoginInfo.getPassword())) {
					return true;
				}
				
			}
			
		}
		
		return false;
		
	}

	public boolean save(BlogAccount blogAccount) {

		if(blogAccount!=null) {
			BlogAccount blogLoginInfo = loginRepo.findBlogAccountByUsername(blogAccount.getUsername());
			if(blogLoginInfo!=null) {
				return false;
			}
		}
		loginRepo.save(blogAccount);
		return true;
	}

}

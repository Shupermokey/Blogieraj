package com.sobieraj.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.entities.Friends;
import com.sobieraj.blog.repos.FriendRepo;
import com.sobieraj.blog.repos.LoginRepo;

@Service
public class FriendService {
	
	@Autowired
	LoginRepo userRepo;
	
	@Autowired
	FriendRepo friendRepo;
	
	public boolean addFriend(BlogAccount first, BlogAccount second) {
		
		if(first != null && second != null) {
			BlogAccount currentUser = userRepo.findBlogAccountByUsername(first.getUsername());
			BlogAccount addUserFriend = userRepo.findBlogAccountByUsername(second.getUsername());
			Friends friend = friendRepo.findByFirstUserAndSecondUser(currentUser, addUserFriend);
			if(friend == null ){
			Friends friends = new Friends();
			friends.setFirstUser(currentUser);
			friends.setSecondUser(addUserFriend);
			friendRepo.save(friends);
			
			return true;
			}
			
			
		}
		return false;
		
	}

	public List<Friends> findAll() {
		return friendRepo.findAll();
	}
	
	public List<Friends> findByFirstUser(BlogAccount user){
		BlogAccount currentUser = userRepo.findBlogAccountByUsername(user.getUsername());
		List<Friends> listFirstUserFriends = friendRepo.findByFirstUser(currentUser);

		return listFirstUserFriends;
	}
	
	public List<Friends> findBySecondUser(BlogAccount user){
		BlogAccount userFriend = userRepo.findBlogAccountByUsername(user.getUsername());
		List<Friends> listSecondUserFriends = friendRepo.findBySecondUser(userFriend);
		
		
		return listSecondUserFriends;
	}
	
	public boolean addOrRejectFreind(BlogAccount user) {
		BlogAccount userFriend = userRepo.findBlogAccountByUsername(user.getUsername());
		List<Friends> listSecondUserFriends = friendRepo.findBySecondUser(userFriend);
		return false;
	}
	


}

package com.sobieraj.blog.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sobieraj.blog.entities.BlogAccount;
import com.sobieraj.blog.entities.Friends;

@Repository
public interface FriendRepo extends JpaRepository<Friends, Integer>{
	
	boolean existsByFirstUserAndSecondUser(BlogAccount first, BlogAccount second);
	
	Friends findByFirstUserAndSecondUser(BlogAccount first, BlogAccount second);
	
	List<Friends> findByFirstUser(BlogAccount user);
	List<Friends> findBySecondUser(BlogAccount user);

}

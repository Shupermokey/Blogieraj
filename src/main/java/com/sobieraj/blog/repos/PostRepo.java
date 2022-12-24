package com.sobieraj.blog.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sobieraj.blog.entities.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
}

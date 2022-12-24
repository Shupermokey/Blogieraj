package com.sobieraj.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BlogAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aid;
	
	
	private String username;
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Post> posts = new ArrayList<>();
	
}

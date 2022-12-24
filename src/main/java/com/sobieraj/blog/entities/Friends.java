package com.sobieraj.blog.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Friends {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	
	@OneToOne(cascade = CascadeType.ALL)
	BlogAccount firstUser;
	
	@OneToOne(cascade = CascadeType.ALL)
	BlogAccount secondUser;
	
	@OneToOne(cascade = CascadeType.ALL)
	FriendRequest friendReq = new FriendRequest(); 

}

package com.example.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
	
	@Id
	Integer userId;
	String userName;
	String userAddr;
	
	@Transient    
	List<Contact> contacts;
	
	
	public User(Integer userId, String userName, String userAddr) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddr = userAddr;
	}

	
	
	public User(Integer userId, String userName, String userAddr, List<Contact> contacts) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddr = userAddr;
		this.contacts = contacts;
	}
	
	
	

}

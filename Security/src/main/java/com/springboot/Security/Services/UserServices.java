package com.springboot.Security.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Security.Models.User;

@Service
public class UserServices {

	List<User> list = new ArrayList<>();

	public UserServices() {
		list.add( new User("himmu","abc","himmu@gmail.com"));
		list.add( new User("hello","adbc","hu@gmail.com"));
	}

	//get all user api
	public List<User> getAllUser(){
		return this.list;
	}
	
	//get single use api
	public User getUser(String username)
	{
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	//add users
	public User addUser(User user)
	{
		this.list.add(user);
		return user;
		
	}
	
}

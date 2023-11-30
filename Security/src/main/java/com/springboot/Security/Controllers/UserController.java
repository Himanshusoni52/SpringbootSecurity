package com.springboot.Security.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Security.Models.User;
import com.springboot.Security.Services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServices userService;
	
	@GetMapping("/")
	public List<User> getAllUsers()
	{
		return this.userService.getAllUser();
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username)
	{
		return this.userService.getUser(username);
	}
	
	@PostMapping("/")
	public User add(@RequestBody User user)
	{
		return this.userService.addUser(user);
	}
}

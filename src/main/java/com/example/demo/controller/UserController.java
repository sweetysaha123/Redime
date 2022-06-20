package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.service.IUserService;

@RestController
public class UserController {
	@Autowired()
	IUserService service;
	
	
	@GetMapping("/users")
	public List<User> getAllEmployees()
	{
		return service.getAllUsers();
	}
	
	@GetMapping("/user/{userId}")
	public User getUserWithId(@PathVariable int userId)
	{
		return service.getUserWithId(userId);
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{	 
		 return new ResponseEntity(service.addUser(user),HttpStatus.CREATED);	
	}

	
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable int userId,@RequestBody User user) {
		return new ResponseEntity(service.updateUser(userId, user),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/user/{userId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int userId)
	{
		service.deleteUser(userId);
	}

}

package com.example.demo.service;

import java.util.*;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;

@Service
public class UserServiceImpl implements IUserService {
	
	UserDao dao = new UserDao();
	

	@Override
	public List<User> getAllUsers()
	{
		return dao.findAllUsers();
	}
	
	@Override
	public User getUserWithId(int userId)
	{
		return dao.getById(userId);
	}
	
	@Override
	public User addUser(User user)
	{
		return (User)dao.addUser(user);
	}
	
	@Override
	public User updateUser(int userId,User user)
	{
		return dao.updateUser(user);
	}
	
	@Override
	public void deleteUser(int userId)
	{
		dao.deleteById(userId);
	}
}

package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.User;

public class UserDao 
{
	static List<User> list = null;

	static 
	{
		list = new ArrayList<>();
		list.add(new User(101,"Ram","Singh","Mumbai"));
		list.add(new User(102,"Mahesh","Rajput","Pune"));
		list.add(new User(103,"Ganesh","Patel","Chennai"));
		list.add(new User(104,"Tejal","Shah","Bangalore"));
		list.add(new User(105,"Manisha","Singh","Noida"));
		list.add(new User(106,"Rony","Roy","Kolkata"));
		list.add(new User(107,"Sachin","Kulkarni","Gwalior"));
	}
	
	public List<User> findAllUsers() 
	{
		return list;
	}

	public List<User> addUser(User user) {
		list.add(user);
		return list;
	}

	public User getById(int id) {

		User user = null;

		for (User u : list) {
			if (u.getUserId() == id) {
				user = u;
				break;
			}
		}
		return user;
	}

	public List<User> deleteById(int id) {

		for (User u : list) {
			if (u.getUserId() == id) {
				list.remove(u);
				break;
			}
		}
		return findAllUsers();
	}

	public User updateUser(User user) {

		int index = 0;
		User userData = null;
		for (User u : list) {
			if (u.getUserId() == user.getUserId()) {
				index = list.indexOf(u);
				u.setFirstName(user.getFirstName());
				u.setLastName(user.getLastName());
				u.setAddress(user.getAddress());
				list.set(index, u);
				userData = u;
				break;
			}
		}
		return userData;
	}


}

package com.example.demo.service;

import java.util.List;
import com.example.demo.bean.User;

public interface IUserService {

	List<User> getAllUsers();

	User getUserWithId(int userId);

	User addUser(User user);

	User updateUser(int userId, User user);

	void deleteUser(int empId);

}
package com.example.model.service;

import java.util.List;

import com.example.model.beans.User;

// interface that declares the business logics
public interface UserService {

	// method to store
	public User store(User user);
	//method to delete by id
	public void delete(int id);
	//method to find by id
	public User fetchUser(int id);
	//method to find all users
	public List<User> fetchUsers();
}

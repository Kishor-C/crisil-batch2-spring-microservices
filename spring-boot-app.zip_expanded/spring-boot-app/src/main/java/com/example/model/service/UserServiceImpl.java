package com.example.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.beans.User;
import com.example.model.dao.UserDao;
@Service
public class UserServiceImpl implements UserService {
	// spring boot maintains proxy implementation of UserDao so you can inject it
	@Autowired
	private UserDao dao;
	
	@Override
	@Transactional
	public User store(User user) {
		User u = dao.save(user);
		return u;
	}
	@Override
	public User fetchUser(int id) {
		// findById returns Optional
		User user = dao.findById(id).orElse(null);
		// if user == null you can throw custom checked exception & handle in the controller
		return user;
	}
	@Override
	@Transactional
	public void delete(int id) {
		User user = fetchUser(id); // fetchUser() must have properly handled null pointer exceptions
		dao.delete(user);
	}
	@Override
	public List<User> fetchUsers() {
		List<User> users = dao.findAll();
		return users;
	}

}

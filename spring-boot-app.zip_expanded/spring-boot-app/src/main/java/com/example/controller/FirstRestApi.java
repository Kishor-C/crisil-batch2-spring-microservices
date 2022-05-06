package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.beans.User;
import com.example.model.service.UserService;

@RestController
@RequestMapping("first")
public class FirstRestApi {

	// inject service 
	@Autowired
	private UserService service;
	
	
	// the front-end / client sends json data like {"name":value, "dob":yyyy-MM-dd}
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> storeApi(@RequestBody User user) {
		ResponseEntity<Object> response = null;
		User savedEntity = service.store(user);
		response = ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
		return response;
	}
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> getUsersApi() {
		ResponseEntity<Object> response = null;
		List<User> list = service.fetchUsers();
		response = ResponseEntity.status(HttpStatus.OK).body(list);
		return response;
	}
	// {id} you can pass any value as fetch/100, fetch/200
	@GetMapping(path = "fetch/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> getUserApi(@PathVariable("id") int id) {
		ResponseEntity<Object> response = null;
		response = ResponseEntity.status(HttpStatus.OK).body(service.fetchUser(id));
		return response;
	}
	
}

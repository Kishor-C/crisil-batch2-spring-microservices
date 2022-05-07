package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("myfirst")
public class MyFirstRest {

	@GetMapping
	public String greet() {
		System.out.println("-----greet() is called---------");
		return "Welcome to First Microservice";
	}
}

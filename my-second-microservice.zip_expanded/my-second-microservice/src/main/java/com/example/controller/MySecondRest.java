package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.clients.MyFirstClient;

@RestController
@RequestMapping("second")
public class MySecondRest {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MyFirstClient myFirstClient;
	
	@GetMapping
	public String callMicroservice() {
		String url = "http://APP1/myfirst";
		String result = restTemplate.getForObject(url, String.class);
		// Wallet wallet = restTemplate.getForObject(url, Wallet.class);
		return "Second Microservice using "+result;
	}
	
	@GetMapping("v2")
	public String callFirstMicroservice() {
		return myFirstClient.hello(); // sends request to http://APP1/myfirst and converts to String
	}
}

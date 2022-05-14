package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clients.MyFirstClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MySecondService {

	@Autowired
	private MyFirstClient client;
	
	@CircuitBreaker(name = "callFirstService", fallbackMethod = "callFirstServiceAlternate")
	public String callFirstService() {
		System.out.println("---- call to the first microservice -----");
		return client.hello(); // this is calling microservice
	}
	
	// alternate method if call to microservice is failed
	public String callFirstServiceAlternate(Throwable t) {
		System.out.println("---- call to the fallback method -----");
		return "First Microservice is down, hence we have alternate response";
	}
}

package com.example.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * You need to use @Autowired on this interface reference
 * to inject the dynamic implementation of this interface
 */
@FeignClient("APP1")
public interface MyFirstClient {

	@GetMapping(path = "myfirst")
	public String hello();
}

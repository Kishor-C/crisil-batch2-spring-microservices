package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.ExternalConfig;

@RestController
@RequestMapping("config-client")
public class ConfigRest {

	@Autowired
	private ExternalConfig config;
	
	@GetMapping
	public String getConfig() {
		return config.getEnvironmentName();
	}
}

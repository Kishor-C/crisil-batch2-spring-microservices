package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalConfig {

	@Value("${environment.name}")
	private String environmentName;
	
	public String getEnvironmentName() {
		return environmentName;
	}
}

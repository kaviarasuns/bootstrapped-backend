package com.kaviarasu.bootstrapped_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.kaviarasu.bootstrapped_backend.Q84")
public class BootstrappedBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstrappedBackendApplication.class, args);
	}

}

package com.example.server.Shukra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ShukraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShukraApplication.class, args);
		System.out.println("Server Running");
	}

}

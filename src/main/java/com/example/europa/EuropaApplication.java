package com.example.europa;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEmailTools
public class EuropaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuropaApplication.class, args);
	}
}

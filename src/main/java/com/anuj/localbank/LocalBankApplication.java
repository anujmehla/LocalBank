package com.anuj.localbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class LocalBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalBankApplication.class, args);
	}

}

package com.advertise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AdvertiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertiseApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new Argon2PasswordEncoder();
	}

}

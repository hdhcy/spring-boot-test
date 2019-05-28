package com.cun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootJpammApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpammApplication.class, args);
	}
}

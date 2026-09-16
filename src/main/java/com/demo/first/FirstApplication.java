package com.demo.first;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.demo.first.app.repository")
@EntityScan(basePackages = "com.demo.first.app.model")
public class FirstApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstApplication.class, args);
	}

}

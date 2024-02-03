package com.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.employeemanagement.*"})
@EnableJpaRepositories(basePackages = {"com.employeemanagement.repository.*"})
@EnableFeignClients("com.employeemanagement.service.*")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

package com.banking.onlineBanking;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.banking.onlineBanking.*"})
//@EnableAutoConfiguration
@ServletComponentScan
@EntityScan("com.banking.onlineBanking.Entity.*")
@EnableJpaRepositories(basePackages = "com.banking.onlineBanking.Repository.*")
public class BankingdemoApplication {

	public static void main(String[] args) {
		System.getProperties().put( "server.port", 8484 );
		SpringApplication.run(BankingdemoApplication.class, args);
	}

}

package com.employeemanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.employeemanagement.service.UserService;


@EnableAutoConfiguration
@EnableWebSecurity
@EnableFeignClients
public class SecurityConfiguration {
	
	@Autowired
	private UserService userService;
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeHttpRequests((authorize) ->
		authorize.requestMatchers("/registration**").permitAll()
				.requestMatchers("/js/**").permitAll()
				.requestMatchers("/css/**").permitAll()
				.requestMatchers("/img/**").permitAll()
				)
		.formLogin(
						
						form -> form
						.loginPage("/login")
						.permitAll()
						)
		.logout(
				logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.permitAll());
		return http.build();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth
		.userDetailsService(userService)
		.passwordEncoder(passwordEncoder());
	}
}

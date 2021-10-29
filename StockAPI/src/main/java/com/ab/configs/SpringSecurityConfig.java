package com.ab.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import net.bytebuddy.build.Plugin.Engine.Source.InMemory;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
//			.addFilterAt(new UsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers("/**").permitAll();
//			.antMatchers(HttpMethod.POST, "/users/new").permitAll()
//			.antMatchers(HttpMethod.GET, "/users").hasRole("USER")
//			.antMatchers("/users").hasRole("USER")
//			.antMatchers(HttpMethod.POST, "/login").permitAll()
//			.antMatchers(HttpMethod.POST, "/orders").hasRole("USER");
//			.and()
//			.formLogin();
//			.successForwardUrl("/users");
//			.httpBasic();
//			.loginPage("http://localhost:6030/login");
//			.loginProcessingUrl("http://localhost:8080/users");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.userDetailsService(userDetailsService);
		
		auth.inMemoryAuthentication()
			.withUser("ben@example.com")
			.password(passwordEncoder().encode("password1234"))
			.roles("USER");
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

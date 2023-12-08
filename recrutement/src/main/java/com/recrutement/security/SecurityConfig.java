package com.recrutement.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder ; 
	
	
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		return jdbcUserDetailsManager;
		
	}
	
	
	//on==On va ignorer cette methode et la remplacer par jdbcUserDetailsManager
	//@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		String pwd =passwordEncoder.encode("1234");
		System.out.println(pwd);
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(
				User.withUsername("user1").password(pwd).roles("USER").build(),
				User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER").build(),
				User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN").build()
				);
		return inMemoryUserDetailsManager;
	}
	

	//@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.formLogin();
		//delete c'est l'URI de la requette dans @DeleteMapping
		//On utilise l'annotation @PreAuthorize avant chaque methode et @EnableMethodeSecurity dans SecutityConfig
		//httpSecurity.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN");
		//httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
		httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");
		return	httpSecurity.build();
		
	}

}

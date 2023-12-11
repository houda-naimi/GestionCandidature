package com.recrutement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class RecrutementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecrutementApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//@Bean
	CommandLineRunner commandLineRunnerJdbcUsers( JdbcUserDetailsManager jdbcUserDetailManager) {
		PasswordEncoder passwordEncoder = passwordEncoder();
		return args -> {
			jdbcUserDetailManager.createUser(
				User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build()
                );
			jdbcUserDetailManager.createUser(
					User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER").build()
	                );
			jdbcUserDetailManager.createUser(
					User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("ADMIN").build()
	                );
			
		};
	}

}

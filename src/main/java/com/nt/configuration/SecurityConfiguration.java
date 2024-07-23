package com.nt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	
	@Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		  http
		  .authorizeHttpRequests(authorize -> authorize
	                .requestMatchers("/home", "/contact").permitAll() // Allow access to /home and /contact without authentication
	                .requestMatchers("/balance", "/statement", "/myloan").authenticated() // Require authentication for /balance, /statement, and /myloan
	                .anyRequest().authenticated() // Require authentication for any other request
	            )
          .formLogin(withDefaults())
          .httpBasic(withDefaults());

      return http.build();
	 }
	
	
	  @Bean
	  public UserDetailsService userDetailsService() {
		  //Define multiple users with different roles
		  
	        UserDetails user1 = User.withUsername("ashok")
	                .password("{noop}ashok@123")	// Add {noop} prefix for NoOpPasswordEncoder
	                .authorities("admin")
	                .build();

	        UserDetails user2 = User.withUsername("raju")
	                .password("{noop}raju@123")	// Add {noop} prefix for NoOpPasswordEncoder
	                .authorities("read")
	                .build();

	        UserDetails user3 = User.withUsername("mahesh")
	                .password("{noop}mahesh@123")	// Add {noop} prefix for NoOpPasswordEncoder
	                .authorities("read")
	                .build();

	        // Create an in-memory user details manager with the defined users
	        return new InMemoryUserDetailsManager(user1, user2, user3);
	    }
	  
}

package com.example.jobseeker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/employer/**").hasAuthority("EMPLOYER")
                        .requestMatchers("/api/jobseeker/**").hasAuthority("JOBSEEKER")
                        .anyRequest().authenticated()).httpBasic(withDefaults());
		
		return http.build();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}

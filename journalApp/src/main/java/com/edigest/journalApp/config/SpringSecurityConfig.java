package com.edigest.journalApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()  // Public endpoints - no authentication needed
                .requestMatchers("/journal/**").authenticated()  // Journal endpoints need authentication
                .requestMatchers("/user/**").authenticated()  // User endpoints need authentication
                .anyRequest().authenticated()  // All other endpoints need authentication
            )
            .httpBasic(Customizer.withDefaults())  // Use HTTP Basic Authentication
            .csrf(csrf -> csrf.disable());  // Disable CSRF for REST API

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

